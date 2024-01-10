package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import catalogue.Basket;
import middle.OrderException;
import orders.Order;

/**
 * The order processing handling.
 * This code is incomplete
 * @author  Mike Smith University of Brighton
 * @version 2.0
 */

public class      R_Order
       extends    UnicastRemoteObject
       implements RemoteOrder_I
{
  private static final long serialVersionUID = 1;
  private Order aOrder = null;

  public R_Order( String url )
         throws RemoteException, OrderException
  {
    aOrder = new Order();
  }

  @Override
public void newOrder( Basket bought )
         throws RemoteException, OrderException
  {
     aOrder.newOrder( bought );

  }

  @Override
public int uniqueNumber()
         throws RemoteException, OrderException
  {
    return aOrder.uniqueNumber();
  }

  @Override
public Basket getOrderToPick()
         throws RemoteException, OrderException
  {
      return aOrder.getOrderToPick();
  }

  @Override
public boolean informOrderPicked( int orderNum )
         throws RemoteException, OrderException
  {
     return aOrder.informOrderPicked(orderNum);
  }

  @Override
public boolean informOrderCollected( int orderNum )
         throws RemoteException, OrderException
  {
      return aOrder.informOrderCollected(orderNum);
  }


  @Override
public Map<String, List<Integer>> getOrderState()
          throws RemoteException, OrderException
  {
    return aOrder.getOrderState();
  }

}
