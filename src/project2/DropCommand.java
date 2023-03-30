package project2;


public class DropCommand implements UserInputCommand
{
	private String itemName;
	/**
	 * This constructor instantiates itemName to the String argument
	 * @param itemName
	 */
	public DropCommand(String itemName)
	{
		this.itemName = itemName;
	}
	/**
	 * This method sets itemName to the String argument
	 * @param name
	 */
	public void setName(String name)
	{
		this.itemName = name;
	}
	/**
	 * This method returns the class variable itemName as a String
	 * @return String itemName
	 */
	public String getName()
	{
		return this.itemName;
	}
	/**
	 * This method is implemented fromm the UIC interface. It takes in a TourStatus argument
	 * and then uses that ts' dropItemfromBackpack method. Then it returns a receipt that the item
	 * has been dropped.
	 * @param TourStatus ts
	 * @return String dropped receipt.
	 */
	@Override
	public String carryOut(TourStatus ts)
	{
		ts.dropItemFromBackpack(itemName);
		return "The " + itemName + " has been dropped from the backpack at " + ts.getCurrentLocation().getName() + ".";
	}
}
