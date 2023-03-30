package project2;

import java.util.ArrayList;

public class TourStatus
{
	private Campus campus;
	private Location currentLocation;
	private ArrayList<Item> backpack;

	/**
	 * This constructor instantiates all class variables as Null. It is the default Construcor
	 */
	public TourStatus()
	{
		this.campus = null;
		this.currentLocation = null;
		this.backpack = new ArrayList<Item>();
	}

	/**
	 * This constructor sets the currentLocation variable to the startLocation of the argument campus.
	 * It also sets this.campus equal to the argument campus.
	 * @param campus
	 */
	public void setCampus(Campus campus)
	{
		this.setCurrentLocation(campus.getStartLocation());
		this.campus = campus;
	}

	/**
	 * returns the variable campus
	 * @return campus
	 */
	public Campus getCampus()
	{
		return campus;
	}

	/**
	 * sets the currentLocation variable to the argument location.
	 * @param location
	 */
	public void setCurrentLocation(Location location)
	{
		this.currentLocation = location;
	}

	/**
	 * returns current Location
	 * @return currentLocation
	 */
	public Location getCurrentLocation()
	{
		return currentLocation;
	}

	/**
	 * This method checks to see if the argument direction matches the directions that the currentLocation
	 * doors are facing by using the .getDoors method. If it does, then it updates the currentLocation by using the
	 * .leaveLocation method which will return that door's enteringLocation. If that Location has been visited already
	 * it prints a modified version of the toString info. If the location hasn't been visited, it prints the toString.
	 * Otherwise, if the direction argument doesn't match a door at the currentLocation, it informs the user.
	 * @param dir
	 */
	public void updateTourLocation(String dir)
	{
		if (currentLocation.getDoors().contains(dir))
		{
			this.currentLocation = currentLocation.leaveLocation(dir);
			if(currentLocation.getVisited())
			{
				System.out.println("You are now at: " + currentLocation.alreadyVisited());
			}
			else 
			{
				System.out.println("You are now at: " + currentLocation.toString());
			}
		}
		else
		{
			System.out.println("There is no door that goes " + dir + ".");
		}
	}
	/**
	 * This method adds the argument method to the backpack arraylist, unless it is null.
	 * @param item
	 */
	public void addToBackpack(Item item)
	{
		if (item == null) {
		}
		else {
		this.backpack.add(item);
		System.out.println("Added " + item.getName() + " to the backpack.");
		}
	}
	/**
	 * This method iterates through the backpack, finding the desired item and removing it.
	 * If the item is not there it prints this fact to the console.
	 * @param name
	 */
	public void removeFromBackpack(String name)
	{
		for (Item stored: backpack)
		{
			if (stored.getName().equals(name))
			{
				this.backpack.remove(stored);
				return;
			}
		}
		System.out.println("Item not found in backpack.");
	}
	/**
	 * This method does the same as removeFromBackPack, but also stores that item in the 
	 * items arraylist for the current Location
	 * @param name
	 * @return stored
	 */
	public Item dropItemFromBackpack(String name)
	{
		for (Item stored: backpack)
		{
			if (stored.getName().equals(name))
			{
				this.currentLocation.addItem(stored);
				this.backpack.remove(stored);
				return stored;
			}
		}
		return null;
	}
	/**
	 * This method takes an item from the location, removes it, and stores it in the backpack.
	 * @param name
	 * @return item
	 */
	public Item pickupItemFromLocation(String name)
	{
		return this.currentLocation.getItemNamed(name);
	}
	/**
	 * This method creates a list of all items currently in the backpack and returns them
	 * as a String.
	 * @return
	 */
	public String listBackpackItems()
	{
		String placeholder = "Backpack Items: ";
		for (Item stored: backpack)
		{
			placeholder = placeholder + "\n" + stored.getName();
		}
		return placeholder;
	}
}
