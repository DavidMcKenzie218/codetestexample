package shop;

public class ShoppingBasket{

  Customer customer;

  public ShoppingBasket(Customer customer){
    this.customer = customer;
  }

  public String getOwnerName(){
    return customer.getName();
  }

}