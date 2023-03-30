package project2;

public class InvalidCommand implements UserInputCommand
{
	private String invalidCommand;
	/**
	 * This constructor sets the String invalidCommand to the String argument
	 * @param invalidCommand
	 */
	public InvalidCommand(String invalidCommand)
	{
		this.invalidCommand = invalidCommand;
	}
	/**
	 * this method sets the String invalidCommand to the String argument
	 * @param invalid
	 */
	public void setInvalid(String invalid)
	{
		this.invalidCommand = invalid;
	}
	/**
	 * This method returns the class variable invalidCommand
	 * @return invalidCommand
	 */
	public String getInvalid()
	{
		return this.invalidCommand;
	}
	/**
	 * This method is implemented from the UIC interface. It prints the invalid command back to the user.
	 * @param TourStatus ts
	 * @return invalidCommand String
	 */
	public String carryOut(TourStatus ts)
	{
		return "The command: " + invalidCommand + " is invalid. Try again.";
	}
}
