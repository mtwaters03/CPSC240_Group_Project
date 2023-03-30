package project2;

public class PickupCommand implements UserInputCommand
{
	private String itemName;
	/**
	 * This constructor sets the class variable itemName to the argument
	 * @param name
	 */
	public PickupCommand(String name)
	{
		this.itemName = name;
	}
	/**
	 * THis method sets the class variable itemName to the argument
	 * @param name
	 */
	public void setName(String name)
	{
		this.itemName = name;
	}
	/**
	 * This method returns the class variable itemName as a String
	 * @return itemName
	 */
	public String getName()
	{
		return this.itemName;
	}
	/**
	 * This method is implemented from the UIC. It takes in a TourStatus object, which it uses 
	 * to pull the item from the current location and place in the backpack. it removes the
	 * item from its spot in the current location to avoid duplication, and then prints a receipt
	 * @param TourStatus ts
	 * @return receipt
	 */
	@Override
	public String carryOut(TourStatus ts)
	{
		Item placeholder = ts.getCurrentLocation().getItemNamed(itemName);
		ts.addToBackpack(placeholder);
		ts.getCurrentLocation().removeItem(placeholder);
		return "The " + itemName + " has been added if it exists at this location.";
	}
	
}
