package project2;


public class MovementCommand implements UserInputCommand
{
	private String dir;
	/**
	 * This constructor sets the class variable dir to the String argument
	 * @param dir
	 */
	public MovementCommand(String dir)
	{
		this.dir = dir;
	}
	/**
	 * this method sets the class variable dir to the String argument
	 * @param dir
	 */
	public void setDir(String dir)
	{
		this.dir = dir;
	}
	/**
	 * This method returns the class variable dir
	 * @return
	 */
	public String getDir()
	{
		return this.dir;
	}
	/**
	 * this method is implemented from the UIC. It takes in a TourStatus object and calls
	 * the updateTourLocation method on it using the class variable dir
	 * then returns a receipt
	 */
	public String carryOut(TourStatus ts)
	{
		ts.updateTourLocation(dir);
		return "Movement Command has been carried out as best possible";
	}

}
