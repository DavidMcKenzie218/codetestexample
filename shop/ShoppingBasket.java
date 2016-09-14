package shop;

import java.util.*;

public class ShoppingBasket{

  private Customer customer;
  private ArrayList<Item> contents; 
  private int totalCost;

  public ShoppingBasket(Customer customer){
    this.customer = customer;
    this.contents = new ArrayList<Item>();
    this.totalCost = 0;
  }

  public String getOwnerName(){
    return customer.getName();
  }

  public int getSize(){
    return contents.size();
  }

  public void addItem(Item item){
    contents.add(item);
    totalCost += item.getPrice();
  }

  public void addMoreThanOneItem(Item item, int numberOfItems){
    for(int itemNumber = 0; itemNumber < numberOfItems; itemNumber++){
      contents.add(item);
    totalCost += item.getPrice();
    }
  }

  public int getTotal(){
    return totalCost;
  }

}