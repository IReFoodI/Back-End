package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.CartDTO;
import com.projeto.ReFood.dto.CartItemDTO;
import com.projeto.ReFood.dto.CartItemsDto;
import com.projeto.ReFood.exception.GlobalExceptionHandler.NotFoundException;
import com.projeto.ReFood.model.Cart;
import com.projeto.ReFood.model.CartItem;
import com.projeto.ReFood.model.CartItemPK;
import com.projeto.ReFood.model.Product;
import com.projeto.ReFood.model.Restaurant;
import com.projeto.ReFood.model.User;
import com.projeto.ReFood.repository.CartItemRepository;
import com.projeto.ReFood.repository.CartRepository;
import com.projeto.ReFood.repository.ProductRepository;
import com.projeto.ReFood.repository.UserRepository;

import jakarta.persistence.Tuple;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class CartService {

  private final CartRepository cartRepository;
  private final UtilityService utilityService;
  private final CartItemRepository cartItemRepository;
  private final ProductRepository productRepository;
  private final UserRepository userRepository;

  private static final int EXPIRATION_TIME_IN_SECONDS = 600; // tempo de expiração em segundos

  @Scheduled(fixedRate = 60_000) // Executa a cada ??_000 segundos
  public void checkCartExpirations() {
    LocalDateTime expirationThreshold = LocalDateTime.now().minusSeconds(EXPIRATION_TIME_IN_SECONDS);

    // Busca itens expirados
    List<CartItem> expiredItems = cartItemRepository.findExpiredItems(expirationThreshold);

    for (CartItem item : expiredItems) {
      // Restaura o estoque do produto
      Product product = item.getProduct();
      product.setQuantity(product.getQuantity() + item.getQuantity());
      productRepository.save(product);

      // remove o item
      cartItemRepository.delete(item);
    }
    System.out.println("CART ITEMS EXPIRED: " + expiredItems.size());
  }

  @Transactional
  public CartItemDTO addItemToUserCart(Long userId, Long productId, int quantity) throws Exception {
    // Valida a quantidade fornecida na requisição
    if (quantity <= 0) {
      throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
    }

    // Recupera usuário e produto ou lança exceção
    User user = findUserById(userId);
    Product product = findProductById(productId);

    // Busca ou cria o carrinho do usuário
    Cart cart = findOrCreateCart(user);

    // Obtém o restaurante do produto
    Restaurant productRestaurant = product.getRestaurant();

    // Verifica se o carrinho já possui itens
    if (!cart.getCartItems().isEmpty()) {
      // Obtém o restaurante associado aos itens do carrinho
      Restaurant existingRestaurant = cart.getCartItems().iterator().next().getProduct().getRestaurant();

      // Valida se o restaurante do produto é o mesmo do carrinho
      if (!existingRestaurant.getRestaurantId().equals(productRestaurant.getRestaurantId())) {
        System.out.println("O carrinho só pode conter produtos de um único restaurante.");
        throw new IllegalArgumentException("O carrinho só pode conter produtos de um único restaurante.");
      }
    }

    // Verifica se o produto já existe no carrinho e calcula a quantidade total
    CartItem existingCartItem = cart.getCartItems().stream()
        .filter(item -> item.getProduct().getProductId().equals(productId))
        .findFirst()
        .orElse(null);

    int totalQuantityInCart = existingCartItem != null ? existingCartItem.getQuantity() : 0;
    int totalQuantityRequested = totalQuantityInCart + quantity;

    // Valida a quantidade total (já no carrinho + nova quantidade)
    if (product.getQuantity() < totalQuantityRequested) {
      throw new IllegalArgumentException("Quantidade solicitada maior que a quantidade disponível.");
    }

    // Cria ou atualiza o CartItem
    CartItem cartItem = findOrCreateCartItem(cart, product, quantity, totalQuantityRequested);

    // atualiza estoque (quantity) de Product
    product.setQuantity(product.getQuantity() - quantity);
    productRepository.save(product);

    // Atualiza o total do carrinho
    updateCartTotal(cart);

    // Cria e retorna o DTO do CartItem
    return createCartItemDTO(cartItem);
  }

  private User findUserById(Long userId) throws NotFoundException {
    return userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException());
  }

  private Product findProductById(Long productId) throws NotFoundException {
    return productRepository.findById(productId)
        .orElseThrow(() -> new NotFoundException());
  }

  private Cart findOrCreateCart(User user) {
    return cartRepository.findByUser(user)
        .orElseGet(() -> createNewCart(user));
  }

  private Cart createNewCart(User user) {
    Cart newCart = new Cart();
    newCart.setUser(user);
    newCart.setTotalValue(0);
    newCart.setCartItems(new HashSet<>());
    return cartRepository.save(newCart);
  }

  private CartItem findOrCreateCartItem(Cart cart, Product product, int quantity, int totalQuantityRequested) {
    // Busca o item do carrinho
    CartItem cartItem = cartItemRepository.findByCartAndProduct(cart, product)
        .orElse(new CartItem());

    // Atualiza os valores do item
    cartItem.setQuantity(totalQuantityRequested);
    cartItem.setUnitValue(product.getSellPrice());
    cartItem.setSubtotal(cartItem.getUnitValue() * cartItem.getQuantity());
    cartItem.setProduct(product);
    cartItem.setCart(cart);
    cartItem.setCartItemId(new CartItemPK(cart.getCartId(), product.getProductId()));
    cartItem.setAddedAt(LocalDateTime.now());

    return cartItemRepository.save(cartItem);
  }

  private void updateCartTotal(Cart cart) {
    float totalValue = cart.getCartItems().stream()
        .map(elem -> {
          Float subtotal = elem.getSubtotal();
          return subtotal;
        })
        .reduce(0f, Float::sum);
    cart.setTotalValue(totalValue);
    cartRepository.save(cart);
  }

  private CartItemDTO createCartItemDTO(CartItem cartItem) {
    return new CartItemDTO(
        cartItem.getCartItemId(),
        cartItem.getQuantity(),
        cartItem.getUnitValue(),
        cartItem.getSubtotal(),
        cartItem.getCartItemId().getCartId(),
        cartItem.getCartItemId().getProductId(),
        cartItem.getRestaurant() != null ? cartItem.getRestaurant().getRestaurantId() : null);
  }

  @Transactional
  public void removeItemFromCart(Long cartId, Long productId) {
    CartItemPK cartItemPK = new CartItemPK(cartId, productId);
    CartItem cartItem = cartItemRepository.findById(cartItemPK)
        .orElseThrow(() -> new NotFoundException());

    Product product = cartItem.getProduct();

    Cart cart = cartItem.getCart();

    if (cartItem.getQuantity() > 1) {
      cartItem.setQuantity(cartItem.getQuantity() - 1);
      cartItem.setSubtotal(cartItem.getQuantity() * cartItem.getUnitValue());
      cartItemRepository.save(cartItem);

      float newTotalValue = (float) cart.getCartItems().stream()
          .mapToDouble(CartItem::getSubtotal)
          .sum();
      cart.setTotalValue(newTotalValue);
      cartRepository.save(cart);

      // att estoque
      product.setQuantity(product.getQuantity() + 1);
      productRepository.save(product);
    } else {
      // busca o valor do item para subtrair do total do carrinho antes do delete
      float newTotalValue = cart.getTotalValue() - cartItem.getSubtotal();
      cart.setTotalValue(newTotalValue);
      cartRepository.save(cart);

      // att estoque
      product.setQuantity(product.getQuantity() + cartItem.getQuantity());
      productRepository.save(product);

      cartItemRepository.deleteById(cartItemPK);
    }
  }

  @Transactional
  public void removeAllQuantityFromCartItem(Long cartId, Long productId) {
    CartItemPK cartItemPK = new CartItemPK(cartId, productId);
    CartItem cartItem = cartItemRepository.findById(cartItemPK)
        .orElseThrow(() -> new NotFoundException());

    Product product = cartItem.getProduct();

    Cart cart = cartItem.getCart();

    // Subtrair o subtotal do item, garantindo que o total seja no mínimo zero
    float newTotalValue = Math.max(cart.getTotalValue() - cartItem.getSubtotal(), 0);
    cart.setTotalValue(newTotalValue);
    cartRepository.save(cart);

    // att o estoque
    product.setQuantity(product.getQuantity() + cartItem.getQuantity());
    productRepository.save(product);

    cartItemRepository.deleteById(cartItemPK);
  }

  @Transactional
  public void clearCart(Long cartId) {
    Cart cart = cartRepository.findById(cartId)
        .orElseThrow(() -> new NotFoundException());

    // att estoque
    for (CartItem cartItem : cart.getCartItems()) {
      Product product = cartItem.getProduct();
      product.setQuantity(product.getQuantity() + cartItem.getQuantity());
      productRepository.save(product);
    }

    // continua a limpeza
    cartItemRepository.deleteByCart_CartId(cartId);

    cart.getCartItems().clear();

    cart.setTotalValue(0);

    cartRepository.save(cart);
  }

  @Transactional(readOnly = true)
  public List<CartItemsDto> getCartDetailsByUserId(Long userId) {
    List<Tuple> cartItemsTuples = cartRepository.getCartItemsByUserId(userId);

    if (cartItemsTuples.isEmpty()) {
      throw new NotFoundException();
    }

    List<CartItemsDto> cartItems = cartItemsTuples.stream()
        .map(tuple -> new CartItemsDto(
            tuple.get(0, Long.class), // cartId
            tuple.get(1, Long.class), // productId
            tuple.get(2, String.class), // nameProduct
            tuple.get(3, String.class), // descriptionProduct
            tuple.get(4, Integer.class), // quantity
            tuple.get(5, Float.class), // unitValue
            tuple.get(6, Float.class) // subtotal
        ))
        .collect(Collectors.toList());

    return cartItems;
  }

  @Transactional(readOnly = true)
  public List<CartDTO> getAllCarts() {
    return cartRepository
        .findAll()
        .stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public CartDTO getCartById(Long cartId) {
    return cartRepository.findById(cartId)
        .map(this::convertToDTO)
        .orElseThrow(() -> new NotFoundException());
  }

  @Transactional
  public CartDTO createCart(@Valid CartDTO cartDTO) {
    Cart cart = convertToEntity(cartDTO);
    utilityService.associateUser(cart::setUser, cartDTO.userId());
    cart = cartRepository.save(cart);
    return convertToDTO(cart);
  }

  @Transactional
  public CartDTO updateCart(Long cartId, @Valid CartDTO cartDTO) {
    Cart cart = cartRepository.findById(cartId)
        .orElseThrow(() -> new NotFoundException());

    cart.setTotalValue(cartDTO.totalValue());

    utilityService.associateUser(cart::setUser, cartDTO.userId());

    cart = cartRepository.save(cart);
    return convertToDTO(cart);
  }

  @Transactional
  public void deleteCart(Long cartId) {
    if (!cartRepository.existsById(cartId)) {
      throw new NotFoundException();
    }
    cartRepository.deleteById(cartId);
  }

  private CartDTO convertToDTO(Cart cart) {
    return new CartDTO(
        cart.getCartId(),
        cart.getTotalValue(),
        cart.getUser().getUserId());
  }

  private Cart convertToEntity(CartDTO cartDTO) {
    Cart cart = new Cart();
    cart.setCartId(cartDTO.cartId());
    cart.setTotalValue(cartDTO.totalValue());
    utilityService.associateUser(cart::setUser, cartDTO.userId());
    return cart;
  }

}
