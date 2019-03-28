import java.util.Scanner;
import java.util.ArrayList;
public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		ArrayList<Item> myBids = new ArrayList<Item>();

		Item[] itemList = {new Item("CPU", 55.3), new Item("RAM", 33.5), new Item("MotherBoard", 23.2)};

		System.out.println("Choose one of the options below (enter integer).");
		System.out.println("1. Bid");
		System.out.println("2. Get current winning bid");
		System.out.println("3. Get all bids");
		System.out.println("4. Get my bids");
		System.out.println("5. exit");
		System.out.println();
		System.out.println("Enter the number here: ");
		String choice = scanner.nextLine();

		while(!choice.equals("5"))
		{
			if(choice.equals("1"))
			{
				biddingMethod(itemList, myBids);
			}
			else if (choice.equals("2"))
			{
				currentwinningbid(itemList);
			}
			else if (choice.equals("3"))
			{
				getAllBidsOnItem(itemList);
			}
			else if (choice.equals("4"))
			{
				getAllUserBids(myBids);
			}

			System.out.println();
			System.out.println("1. Bid");
			System.out.println("2. Get current winning bid for an item");
			System.out.println("3. Get all the bids for an item");
			System.out.println("4. Get my bids");
			System.out.println("5. exit");
			System.out.println();
			System.out.println("Enter the number here: ");
			choice = scanner.nextLine();
		}

		getAllUserBids(myBids);
		getAllBidsOnItem(itemList);
	}

	public static void biddingMethod(Item[] itemList, ArrayList<Item> myBids)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println();

		for(int i = 0; i<itemList.length; i++)
		{
			System.out.println(itemList[i].getName() + " for " + itemList[i].getPrice());
		}

		System.out.println("Above are the items for bidding, choose one: ");
		String choice = (scanner.nextLine()).toLowerCase();

		for(int j = 0; j<itemList.length; j++)
		{
			if(choice.equals(itemList[j].getName().toLowerCase()))
			{
				try
				{
					System.out.println("How much do you want to bid for?: ");
					Double bidPrice = Double.parseDouble(scanner.nextLine());

					while(bidPrice<itemList[j].getPrice())
					{
						System.out.println("Bidding price must be higher that the current price: ");
						bidPrice = Double.parseDouble(scanner.nextLine());
					}

					itemList[j].setPrice(bidPrice);
					itemList[j].productInfo();
					itemList[j].setNewBid(bidPrice);

					if(!myBids.contains(itemList[j]))
					{
						myBids.add(itemList[j]);
					}

				}
				catch(Exception e)
				{
					System.out.println("Cannot enter String for purchasing units. So enter an Integer or double.");
					biddingMethod(itemList, myBids);
				}
			}
		}
		System.out.println();
	}

	public static void currentwinningbid(Item[] itemList)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Below are the items that can be bidded on.");
		System.out.println();
		for(int i = 0; i<itemList.length; i++)
		{
			System.out.println(itemList[i].getName());
		}
		System.out.println();
		System.out.println("Enter the item name to find current winning bid");
		String itemName = (scanner.nextLine()).toLowerCase();
		for(int i = 0; i<itemList.length; i++)
		{
			if(itemName.equals(itemList[i].getName().toLowerCase()))
			{
				System.out.println(itemList[i].getName() + " for " + itemList[i].getPrice());
				return;
			}
		}

		System.out.println("Item not found");

	}

	public static void getAllUserBids(ArrayList<Item> myBids)
	{
		System.out.println();
		System.out.println("You have bidded on the following items below.");

		for(int i = 0; i<myBids.size(); i++)
		{
			System.out.println(myBids.get(i).getName() + " for " + myBids.get(i).getPrice());
			//System.out.println(myBids[i].getName() + " for " + myBids[i].getPrice());
		}
		System.out.println();
	}
	

	public static void getAllBidsOnItem(Item[] itemList)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Below are the items that can be bidded on.");
		System.out.println();
		for(int i = 0; i<itemList.length; i++)
		{
			System.out.println(itemList[i].getName());
		}
		System.out.println();
		System.out.println("Enter the item name to find all the biddings.");
		String itemName = (scanner.nextLine()).toLowerCase();
		for(int i = 0; i<itemList.length; i++)
		{
			if(itemName.equals(itemList[i].getName().toLowerCase()))
			{
				System.out.println(itemList[i].getAllBids());
				return;
			}
		}

		System.out.println("Item not found");
	}
}