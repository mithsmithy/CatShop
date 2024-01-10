package clients.collection;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import middle.MiddleFactory;
import middle.Names;
import middle.RemoteMiddleFactory;

/**
 * The standalone Collection Client.
 * @author  Mike Smith University of Brighton
 * @version 2.0
 */


public class CollectClient
{
   public static void main (String args[])
   {
     String stockURL = args.length < 1     // URL of stock RW
                     ? Names.STOCK_RW      //  default  location
                     : args[0];            //  supplied location
     String orderURL = args.length < 2     // URL of order
                     ? Names.ORDER         //  default  location
                     : args[1];            //  supplied location

    RemoteMiddleFactory mrf = new RemoteMiddleFactory();
    mrf.setStockRWInfo( stockURL );
    mrf.setOrderInfo  ( orderURL );        //
    displayGUI(mrf);                       // Create GUI
  }

  private static void displayGUI(MiddleFactory mf)
  {
    JFrame  window = new JFrame();

    window.setTitle( "Collection Client (MVC RMI)");
    window.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

	CollectModel      model = new CollectModel(mf);
	CollectView       view  = new CollectView( window, mf, 0, 0 );
	CollectController cont  = new CollectController( model, view );
	view.setController( cont );

	model.addObserver( view );       // Add observer to the model
	window.setVisible(true);         // Display Screen
  }
}
