package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.CartDTO;
import com.projeto.ReFood.dto.CartItemsDto;
import com.projeto.ReFood.exception.GlobalExceptionHandler.NotFoundException;
import com.projeto.ReFood.model.Cart;
import com.projeto.ReFood.model.CartItem;
import com.projeto.ReFood.model.CartItemPK;
import com.projeto.ReFood.model.Product;
import com.projeto.ReFood.model.User;
import com.projeto.ReFood.repository.CartItemRepository;
import com.projeto.ReFood.repository.CartRepository;
import com.projeto.ReFood.repository.ProductRepository;
import com.projeto.ReFood.repository.UserRepository;

import jakarta.persistence.Tuple;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

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

  @Transactional
  public CartItem addItemToUserCart(Long userId, Long productId, int quantity) throws Exception {
    // Verifica se a quantidade é válida
    if (quantity <= 0) {
      System.out.println("\n\n\nQuantidade inválida: " + quantity);
      throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
    }

    // Verifica se o usuário existe
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException());
    // System.out.println("\n\n\nUsuário encontrado: " + user);
    System.out.println("\nUsuário encontrado ID: " + user.getUserId());

    // Verifica se o produto existe
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new NotFoundException());
    // System.out.println("\n\n\nProduto encontrado: " + product);
    System.out.println("\nProduto encontrado ID: " + product.getProductId());
    System.out.println("\nProduto encontrado SellPrice: " + product.getSellPrice());

    // Busca ou cria o carrinho do usuário
    Cart cart = cartRepository.findByUser(user)
        .orElseGet(() -> {
          Cart newCart = new Cart();
          newCart.setUser(user);
          newCart.setTotalValue(0);
          newCart.setCartItems(new HashSet<>());
          Cart savedCart = cartRepository.save(newCart);
          System.out.println("\n\n\nNovo carrinho criado ID: " + savedCart.getCartId());
          return savedCart;
        });
    System.out.println("\nCarrinho do usuário: " + cart.getUser().getUserId());

    // // Busca ou cria um item no carrinho
    CartItem cartItem = cartItemRepository.findByCartAndProduct(cart, product)
        .orElse(new CartItem());

    // Atualiza os valores do item
    int newQuantity = cartItem.getQuantity() + quantity;
    cartItem.setQuantity(newQuantity);

    float unitValue = product.getSellPrice();
    cartItem.setUnitValue(unitValue);

    float newSubtotal = unitValue * newQuantity;
    cartItem.setSubtotal(newSubtotal);

    cartItem.setProduct(product);
    cartItem.setCart(cart);

    // Cria a chave composta (CartItemPK)
    CartItemPK cartItemPK = new CartItemPK(cart.getCartId(),
        product.getProductId());
    cartItem.setCartItemId(cartItemPK);

    try {

      CartItem savedCartItem = cartItemRepository.save(cartItem);
      System.out.println("\n\n\nCartItem salvo no repositório.");
      System.out.println(savedCartItem.getCartItemId());
      System.out.println(savedCartItem.getCartItemId().getCartId());
      System.out.println(savedCartItem.getCartItemId().getProductId());
    } catch (Exception e) {
      System.err.println("Erro ao salvar o item: " + e.getMessage());
      e.printStackTrace();
      return null;
    }

    // Verifica se o carrinho não é nulo
    if (cart != null) {
      System.out.println("\n\n\nCarrinho encontrado.");
      try {
        cart.getCartItems().add(cartItem);
      } catch (Exception e) {
        System.err.println("\n\n\nErro no ADD ITEM: " + e.getMessage());
        e.printStackTrace();
        return null;
      }

      // Verifica se a lista de itens do carrinho não é nula
      if (cart.getCartItems() != null) {
        System.out.println("\n\n\nItens do carrinho encontrados.");

        // Exibe/Imprime os itens do carrinho para verificação
        cart.getCartItems().forEach(elem -> {
          System.out.println("\nITEM:");
          System.out.println("ID: " + elem.getProduct().getProductId());
          System.out.println("NAME: " + elem.getProduct().getNameProduct());
          System.out.println("SUBTOTAL do item:");
          System.out.println(elem.getSubtotal());
        });

        // Atualiza o valor total do carrinho
        float totalValue = cart.getCartItems().stream()
            .map(elem -> {
              Float subtotal = elem.getSubtotal();
              return subtotal;
            })
            .reduce(0f, Float::sum);
        System.out.println("\n\n\nValor total do carrinho calculado: " + totalValue);

        cart.setTotalValue(totalValue);

        try {
          Cart cartSaved = cartRepository.save(cart);
          System.out.println("\n\n\nCarrinho salvo no repositório:");
          System.out.println(cartSaved);
        } catch (Exception e) {
          e.printStackTrace();
          System.err.println("Erro ao salvar o carrinho: " + e.getMessage());
        }

      }
    }

    System.out.println("\n\n\n///////////////////////////////");
    System.out.println("///////////////////////////////");
    System.out.println("///////////////////////////////\n");
    // return cartItem;
    return null;

  }

  @Transactional
  public void removeItemFromCart(Long cartId, Long productId) {
    CartItemPK cartItemPK = new CartItemPK(cartId, productId);
    CartItem cartItem = cartItemRepository.findById(cartItemPK)
        .orElseThrow(() -> new NotFoundException());

    if (cartItem.getQuantity() > 1) {
      cartItem.setQuantity(cartItem.getQuantity() - 1);
      cartItem.setSubtotal(cartItem.getQuantity() * cartItem.getUnitValue());
      cartItemRepository.save(cartItem);
    } else {
      cartItemRepository.deleteById(cartItemPK);
    }

    Cart cart = cartItem.getCart();
    float newTotalValue = (float) cart.getCartItems().stream()
        .mapToDouble(CartItem::getSubtotal)
        .sum();
    cart.setTotalValue(newTotalValue);
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

  @Transactional
  public void clearCart(Long cartId) {
    Cart cart = cartRepository.findById(cartId)
        .orElseThrow(() -> new NotFoundException());

    cartItemRepository.deleteByCart_CartId(cartId);

    cart.getCartItems().clear();

    cart.setTotalValue(0);

    cartRepository.save(cart);
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
