import static org.junit.Assert.*;
import org.junit.*;

import shop.*;

public class CustomerTest{

  Customer loyalCustomer;
  Customer customer;

  @Before
  public void before(){
    loyalCustomer = new Customer("Jim", true);
    customer = new Customer("Frank", false);
  }

  @Test
  public void customerHasName__Loyal(){
    assertEquals("Jim", loyalCustomer.getName());
  }

  @Test
  public void customerHasName__Normal(){
    assertEquals("Frank", customer.getName());
  }

}