package shop;

public class Item{

  private String name;
  private int cost;
  private boolean offers;

  public Item(String name, int cost, boolean offer){
    this.name = name;
    this.cost = cost;
    this.offers = offer;
  }

  public String getName(){
    return name;
  }

  public int getPrice(){
    return cost;
  }

  public boolean onSpecial(){
    return offers;
  }

}