package catalogue;

import java.io.Serializable;

public class BetterBasket extends Basket implements Serializable
{
  private static final long serialVersionUID = 1L;

  
  
  
  
  
  
  
  
  
  
  
  @Override
  public boolean add( Product pr )
  {
    return super.add( pr );     // Call add in ArrayList
  }
}
