package com.projeto.ReFood.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class CartItemPK implements Serializable {

  private Long cartId;
  private Long productId;

  public CartItemPK() {
  }

  public CartItemPK(Long cartId, Long productId) {
    this.cartId = cartId;
    this.productId = productId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    CartItemPK that = (CartItemPK) o;
    return Objects.equals(cartId, that.cartId) && Objects.equals(productId, that.productId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cartId, productId);
  }

}
