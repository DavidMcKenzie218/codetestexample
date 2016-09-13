import static org.junit.Assert.*;
import org.junit.*;

import shop.*;

public class ItemTest{

  Item daz;
  Item cheese;

  @Before
  public void before(){
    daz = new Item("Daz", 4, true);
    cheese = new Item("Cheese", 2, false);
  }

  @Test
  public void itemHasName__Daz(){
    assertEquals("Daz", daz.getName());
  }

  @Test
  public void itemHasName__Cheese(){
    assertEquals("Cheese", cheese.getName());
  }

  @Test
  public void itemHasPrice__Daz(){
    assertEquals(4, daz.getPrice());
  }

  @Test
  public void itemHasPrice__Cheese(){
    assertEquals(2, cheese.getPrice());
  }

  @Test
  public void itemIsOnSpecial__Daz(){
    assertEquals(true, daz.onSpecial());
  }

  @Test
  public void itemIsOnSpecial__Cheese(){
    assertEquals(false, cheese.onSpecial());
  }
}