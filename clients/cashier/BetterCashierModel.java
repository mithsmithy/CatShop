package clients.cashier;

import java.io.Serializable;
import catalogue.BetterBasket;
import middle.MiddleFactory;


public class BetterCashierModel extends CashierModel implements Serializable
{
	
	
	
	
	//BetterCashierModel using bBetterBasker
	@Override
	  protected BetterBasket makeBasket()
	  {
	    return new BetterBasket();
	  }
	


	
	
	public BetterCashierModel(MiddleFactory mf) {
		super(mf);

	}

	private static final long serialVersionUID = 1L;}