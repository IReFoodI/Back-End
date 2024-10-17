package com.projeto.ReFood.service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.projeto.ReFood.exception.NotFoundException;
import com.projeto.ReFood.model.Address;
import com.projeto.ReFood.model.Card;
import com.projeto.ReFood.model.Cart;
import com.projeto.ReFood.model.HistoricalOrder;
import com.projeto.ReFood.model.Order;
import com.projeto.ReFood.model.Product;
import com.projeto.ReFood.model.Restaurant;
import com.projeto.ReFood.model.Transaction;
import com.projeto.ReFood.model.User;
import com.projeto.ReFood.repository.AddressRepository;
import com.projeto.ReFood.repository.CardRepository;
import com.projeto.ReFood.repository.CartRepository;
import com.projeto.ReFood.repository.OrderRepository;
import com.projeto.ReFood.repository.ProductRepository;
import com.projeto.ReFood.repository.RestaurantRepository;
import com.projeto.ReFood.repository.TransactionRepository;
import com.projeto.ReFood.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtilityService {

  private final UserRepository userRepository;
  private final RestaurantRepository restaurantRepository;
  private final TransactionRepository transactionRepository;
  private final OrderRepository orderRepository;
  private final AddressRepository addressRepository;
  private final CardRepository cardRepository;
  private final ProductRepository productRepository;
  private final CartRepository cartRepository;

  public boolean isEmailUnique(String email) {
    return !userRepository.existsByEmail(email) && !restaurantRepository.existsByEmail(email);
  }

  public void associateUser(Consumer<User> userSetter, Long userId) {
    if (userId != null) {
      User user = userRepository.findById(userId)
          .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));
      userSetter.accept(user);
    } else {
      throw new IllegalArgumentException("User ID cannot be null when creating a card.");
    }
  }

  public void associateRestaurant(Consumer<Restaurant> restaurantSetter, Long restaurantId) {
    Restaurant restaurant = restaurantRepository.findById(restaurantId)
        .orElseThrow(() -> new NotFoundException("Restaurante não encontrado com ID: " + restaurantId));
    restaurantSetter.accept(restaurant);
  }

  public void associateTransactions(Card card, Set<Long> transactionIds) {
    if (transactionIds != null && !transactionIds.isEmpty()) {
      Set<Transaction> transactions = transactionIds.stream()
          .map(transactionId -> transactionRepository.findById(transactionId)
              .orElseThrow(() -> new NotFoundException("Transaction not found with ID: " + transactionId)))
          .collect(Collectors.toSet());
      card.setCardTransactions(transactions);
    }
  }

  public void associateOrder(HistoricalOrder historicalOrder, Long orderId) { // Novo método
    if (orderId != null) {
      Order order = orderRepository.findById(orderId)
          .orElseThrow(() -> new NotFoundException("Order not found with ID: " + orderId));
      historicalOrder.setAssociatedHistoricalOrder(order);
    } else {
      throw new IllegalArgumentException("Order ID cannot be null when creating a historical order.");
    }
  }

  public void associateAddress(Consumer<Address> addressSetter, Long addressId) {
    if (addressId != null) {
      Address address = addressRepository.findById(addressId)
          .orElseThrow(() -> new NotFoundException("Endereço não encontrado com ID: " + addressId));
      addressSetter.accept(address);
    } else {
      throw new IllegalArgumentException("Address ID cannot be null when associating an address.");
    }
  }

  public void associateOrder(Consumer<Order> orderSetter, Long orderId) {
    if (orderId != null) {
      Order order = orderRepository.findById(orderId)
          .orElseThrow(() -> new NotFoundException("Pedido não encontrado com ID: " + orderId));
      orderSetter.accept(order);
    } else {
      throw new IllegalArgumentException("Order ID cannot be null when associating an order.");
    }
  }

  public void associateCard(Consumer<Card> cardSetter, Long cardId) {
    if (cardId != null) {
      Card card = cardRepository.findById(cardId)
          .orElseThrow(() -> new NotFoundException("Cartão não encontrado com ID: " + cardId));
      cardSetter.accept(card);
    } else {
      throw new IllegalArgumentException("Card ID cannot be null when associating a card.");
    }
  }

  public void associateProduct(Consumer<Product> productSetter, Long productId) {
    if (productId != null) {
      Product product = productRepository.findById(productId)
          .orElseThrow(() -> new NotFoundException("Produto não encontrado com ID: " + productId));
      productSetter.accept(product);
    } else {
      throw new IllegalArgumentException("Product ID cannot be null when associating a product.");
    }
  }

  public void associateCart(Consumer<Cart> cartSetter, Long cartId) {
    if (cartId != null) {
      Cart cart = cartRepository.findById(cartId)
          .orElseThrow(() -> new NotFoundException("Carrinho não encontrado com ID: " + cartId));
      cartSetter.accept(cart);
    } else {
      throw new IllegalArgumentException("Cart ID cannot be null when associating an cart.");
    }
  }

}
