package shop;

public class Item{

  private String name;
  private float cost;
  private boolean offers;

  public Item(String name, float cost, boolean offer){
    this.name = name;
    this.cost = cost;
    this.offers = offer;
  }

  public String getName(){
    return name;
  }

  public float getPrice(){
    return cost;
  }

  public boolean onSpecial(){
    return offers;
  }

}