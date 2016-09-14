package shop;

import java.util.*;

public class ShoppingBasket{

  private Customer customer;
  private ArrayList<Item> contents; 
  private ArrayList<Item> duplicates;
  private int totalCost;


  public ShoppingBasket(Customer customer){
    this.customer = customer;
    this.contents = new ArrayList<Item>();
    this.duplicates = new ArrayList<Item>();
    this.totalCost = 0;
  }

  public String getOwnerName(){
    return customer.getName();
  }

  public int getSize(){
    return contents.size();
  }

  public int getDuplicateSize(){
    return duplicates.size();
  }

  public void addItem(Item item){
    contents.add(item);
    totalCost += item.getPrice();
    addDuplicates(item);
  }

  public void addMoreThanOneItem(Item item, int numberOfItems){
    for(int itemNumber = 0; itemNumber < numberOfItems; itemNumber++){
      addItem(item);
    }
  }

  private void addDuplicates(Item item){

    if(getDuplicateSize()!=0){

      for(int duplicateNumber = 0; duplicateNumber < getDuplicateSize(); duplicateNumber ++){

        if(item != duplicates.get(duplicateNumber)){

          duplicates.add(item);
        }
      }
    }else{
      duplicates.add(item);
    }
  }


  public int getTotal(){
    return totalCost;
  }

  public void emptyContents(){
    contents.clear();
  }

  public void applyDiscounts(){
    for(Item duplicate: duplicates){
      int counter = 0;
      for (int itemNumber = 0; itemNumber < getSize(); itemNumber++){
        if(duplicate == contents.get(itemNumber)){
          counter ++;
        }
      }
      if(duplicate.onSpecial() == true){
        totalCost -= (duplicate.getPrice() * (counter/2));
      }
    }
  }
}