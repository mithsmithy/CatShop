package clients.customer;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import middle.MiddleFactory;
import middle.Names;
import middle.RemoteMiddleFactory;

/**
 * The standalone Customer Client
 * @author  Mike Smith University of Brighton
 * @version 2.0
 */
public class CustomerClient
{
  public static void main (String args[])
  {
    String stockURL = args.length < 1         // URL of stock R
                    ? Names.STOCK_R           //  default  location
                    : args[0];                //  supplied location

    RemoteMiddleFactory mrf = new RemoteMiddleFactory();
    mrf.setStockRInfo( stockURL );
    displayGUI(mrf);                          // Create GUI
  }

  private static void displayGUI(MiddleFactory mf)
  {
    JFrame  window = new JFrame();
    window.setTitle( "Customer Client (MVC RMI)" );
    window.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

    CustomerModel model = new CustomerModel(mf);
    CustomerView  view  = new CustomerView( window, mf, 0, 0 );
    CustomerController cont  = new CustomerController( model, view );
    view.setController( cont );

    model.addObserver( view );       // Add observer to the model
    window.setVisible(true);         // Display Scree
  }
}
