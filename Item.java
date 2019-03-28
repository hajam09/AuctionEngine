import java.util.Arrays;
import java.util.ArrayList;
public class Item
{
	private String itemName;
	private double basePrice;
	private double currentPrice;
	private ArrayList<Double> bids;

	Item(String in, double bp)
	{
		//This is the constructor to initialise instance variables from subclass.
		itemName = in;
		basePrice = bp;
		currentPrice = bp;
		bids = new ArrayList<Double>();
	}

	public void productInfo()
	{
		//This method prints out the property type.
		//Prints outs the properties current stock price as it fluctuates evertime it is called.
		//Prints out the properties current stock unit as the user may purchase and sell.
		String productName = "Item name is: ";
		String stockPrice = "Current item price is: $ ";

		System.out.println(productName+getName());
		System.out.println(stockPrice+getPrice());
		System.out.println();
		return;
	}

	public void setPrice(double newPrice)
	{
		currentPrice = newPrice;

	}

	public String getName()
	{
		return itemName;
	}

	public double getPrice()
	{
		return currentPrice;
	}

	public void setNewBid(double value)
	{
		bids.add(value);
	}

	public String getAllBids()
	{
		String x = "";

		for(int i = 0; i<bids.size(); i++)
		{
			x = x + ", " + bids.get(i);
		}

		return "Bids for " + itemName + " were " + x;		
	}
}