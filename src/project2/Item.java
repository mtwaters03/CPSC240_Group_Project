package project2;

import java.util.Scanner;


public class Item
{
	private String name;
	private String message;
	/**
	 * This constructor is a default constructor.
	 */
	public Item(){	
	}
	/**
	 * This constructor is a default constructor.
	 * @param s
	 */
	public Item(Scanner s)
	{
	}
	/**
	 * This method sets the class variable name to the String arg.
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * This method returns the class variable name as a String
	 * @return name
	 */
	public String getName()
	{
		return this.name;
	}
	/**
	 * This method sets the class variable message to the String arg
	 * @param mess
	 */
	public void setMessage(String mess)
	{
		this.message = mess;
	}
	/**
	 * This method returns the class variable message as a String.
	 * @return message
	 */
	public String getMessage()
	{
		return this.message;
	}
}
