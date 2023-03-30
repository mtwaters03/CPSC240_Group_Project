package project2;

import java.util.Hashtable;
import java.util.Set;

public class Campus
{
	private String campusName;
	private Hashtable<String, Location> locations;
	private Location startingLocation;
	private String filename;
	/**
	 * This constructor instantiates all the variables to their base form, except locations which it instantiates
	 * as a new Hashtable<String, Location>
	 */
	public Campus()
	{
		campusName = "";
		locations = new Hashtable<String, Location>();
		filename = "";
		startingLocation = null;
	}
	
	
	/**
	 * I didnt use this one. But it should set the variable name to the argument, and add a location to the hashtable
	 * @param entry
	 * @param name
	 */
	public Campus(Location entry, String name)
	{
		this.addLocation(entry);
		this.campusName = name;
	}
	
	/**
	 * This method takes the argument location and adds it to the locations hashtable
	 * @param location
	 */
	public void addLocation(Location location)
	{
		locations.put(location.getName(), location);
	}
	
	/**
	 *  This method returns a Location by using the String argument as a key in the hashtable
	 * @param name
	 * @return Location
	 */
	public Location getLocation(String name)
	{
		return locations.get(name);
	}
	
	/**
	 * removes the Location that corresponds to the key that is the String argument
	 * @param name
	 */
	public void removeLocation(String name)
	{
		locations.remove(name);
	}
	
	/**
	 * sets the campus name equal to the String argument
	 * @param n
	 */
	public void setCampusName(String n)
	{
		this.campusName = n;
	}
	
	/**
	 * returns the campusName variable
	 * @return campusName
	 */
	public String getCampusName()
	{
		return campusName;
	}
	
	/**
	 * sets the startingLocation variable to the argument
	 * @param start
	 */
	public void setStartLocation(Location start)
	{
		this.startingLocation = start;
	}
	
	/**
	 * returns the startingLocation variable
	 * @return Location
	 */
	public Location getStartLocation()
	{
		return startingLocation;
	}
	
	/**
	 * sets the variable filename to the argument
	 * @param f
	 */
	public void setFilename(String f)
	{
		this.filename = f;
	}
	
	/**
	 * returns the variable filename
	 * @return filename
	 */
	public String getFilename()
	{
		return filename;
	}
	/**
	 * This method prints out all the data stored in the campus for the developers ease of use
	 */
	public String toString()
	{
		String concat = "The campus contains:";
		Set<String> iterator = locations.keySet();
		for (String keys: iterator)
		{
			concat = concat + "\n" + locations.get(keys).toString();
		}
		return concat;
	}
}