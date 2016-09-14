package shop;

import java.util.*;

public class ShoppingBasket{

  private Customer customer;
  private ArrayList<Item> contents; 

  public ShoppingBasket(Customer customer){
    this.customer = customer;
    this.contents = new ArrayList<Item>();
  }

  public String getOwnerName(){
    return customer.getName();
  }

  public int getSize(){
    return contents.size();
  }

  public void addItem(Item item){
    contents.add(item);
  }

  public void addMoreThanOneItem(Item item, int numberOfItems){
    for(int itemNumber = 0; itemNumber < numberOfItems; itemNumber++){
      contents.add(item);
    }
  }

}