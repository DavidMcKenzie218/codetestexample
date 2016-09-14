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
    assertEquals(6.00, basket.getTotal(), 0.01);
  }

  @Test
  public void canTheBasketBeEmptied(){
    basket.addMoreThanOneItem(cheese, 10);
    basket.emptyContents();
    assertEquals(0, basket.getSize());
  }

  @Test
  public void anApplyDiscounts__OnOffer(){
    basket.addMoreThanOneItem(daz, 2);
    basket.applyDiscounts();
    assertEquals(5.00, basket.getTotal(), 0.01);
  }

  @Test
  public void anApplyDiscounts__NotOnOffer(){
    basket.addMoreThanOneItem(cheese, 2);
    basket.applyDiscounts();
    assertEquals(6.00, basket.getTotal(), 0.01);
  }

  @Test
  public void duplicateCountIsWorking(){
    basket.addMoreThanOneItem(daz, 2);
    assertEquals(1, basket.getDuplicateSize());
  }

  @Test
  public void discountOverTwenty(){
    basket.addMoreThanOneItem(cheese, 7);
    basket.moneyOffOverTwenty();
    assertEquals(18.90, basket.getTotal(), 0.01);
  }

  @Test
  public void loyaltyCardDiscount__No(){
    basket.addMoreThanOneItem(cheese, 3);
    basket.applyLoyaltyCard();
    assertEquals(9.00, basket.getTotal(), 0.01);
  }

  @Test
  public void loyaltyCardDiscount__Yes(){
    loyalBasket.addMoreThanOneItem(cheese, 3);
    loyalBasket.applyLoyaltyCard();
    assertEquals(8.82, loyalBasket.getTotal(), 0.01);
  }

}