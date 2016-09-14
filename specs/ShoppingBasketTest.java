import static org.junit.Assert.*;
import org.junit.*;

import shop.*;

public class ShoppingBasketTest{

  Customer loyalCustomer;
  Customer customer;
  Item daz;
  Item cheese;

  ShoppingBasket basket;
  ShoppingBasket loyalBasket;

  @Before
  public void before(){
    loyalCustomer = new Customer("Jim", true);
    customer = new Customer("Fred", false);
    daz = new Item("Daz", 5, true);
    cheese = new Item("Cheese", 3, false);

    basket = new ShoppingBasket(customer);
    loyalBasket = new ShoppingBasket(loyalCustomer);
  }

  @Test
  public void customerHasBasket__Normal(){
    assertEquals("Fred", basket.getOwnerName());
  }

  @Test
  public void customerBAsketIsEmpty__Normal(){
    assertEquals(0, basket.getSize());
  }

  @Test
  public void itemHasBeenAddedToBasket__Normal(){
    basket.addItem(cheese);
    assertEquals(1, basket.getSize());
  }

  @Test
  public void canAddMultipleItemsAtOnce(){
    basket.addMoreThanOneItem(cheese, 2);
    assertEquals(2, basket.getSize());
  }

  @Test
  public void canCalculateTheBasketTotalCost(){
    basket.addMoreThanOneItem(cheese, 2);
    assertEquals(6, basket.getTotal());
  }

}