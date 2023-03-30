package project2;


public class BackpackCommand implements UserInputCommand
{
	/**
	 * This constructor doesn't do anything except instantiate an object
	 */
	public BackpackCommand(){
	}
	
	/**
	 * This method returns a list of backpack items as a string
	 * @param TourStatus ts
	 * @return String list of items
	 */
	@Override
	public String carryOut(TourStatus ts)
	{
		
		return ts.listBackpackItems();
	}

}
