package project2;

import java.util.ArrayList;

public class Location
{
 private String name;
 private String description;
 private Boolean haveVisited;
 private Boolean isOutside;
 private ArrayList<Door> doors;
 private ArrayList<Item> items;
 
 /**
  * This constructor instantiates each variable to it's base value. haveVisited is set to false
  * and doors is instantiated as an ArrayList<Door>
  */
 public Location()
 {
	 name = "";
	 description = "";
	 haveVisited = false;
	 isOutside = false;
	 items = new ArrayList<Item>();
	 doors = new ArrayList<Door>();
 }
 
 /**
  * I didn't use this one, but it instantiates name and description to the arguments that were passed.
  * @param name
  * @param description
  */
 public Location(String name, String description)
 {
	 this.name = name;
	 this.description = description;
 }
 
 /**
  * returns the variable name
  * @return
  */
 public String getName()
 {
	 return name;
 }
 
 /**
  *   sets name to the passed argument
  * @param n
  */
 public void setName(String n)
 {
	 this.name = n;
 }
 
 /**
  * returns the variable description
  * @return description
  */
 public String getDescription()
 {
	 return description;
 }
 
 /**
  * sets the variable description to the passed argument
  * ensures that the +++ is not included in the description.
  * @param d
  */
 public void setDescription(String d)
 {
	 d = d.replace('+', ' ');
	 this.description = d;
 }
 
 /**
  * this method returns a string consisting of each of the cardinal directions of the doors for this
  * location. It is used when determining if a user input can be carried out at the currentLocation
  * @return doorlist
  */
 public String getDoors()
 {
	String doorlist = "";
	for (int index = 0; index < doors.size(); index++)
	{
		doorlist = doorlist + doors.get(index).getDirection();
	}
	return doorlist;
 }
 
 /**
  * sets the boolean haveVisited equal to the argument vis
  * @param vis
  */
 public void setVisited(boolean vis)
 {
	 this.haveVisited = vis;
 }
 
 /**
  * returns the variable haveVisited
  * @return
  */
 public Boolean getVisited()
 {
	 return haveVisited;
 }
 
 /**
  * This method updates haveVisited to true. it also iterates through the doors ArrayList
  * If a door has the same direction as the argument, it returns that door's enteringLocation.
  * @param dir
  * @return Location (the location the door enters.)
  */
 public Location leaveLocation(String dir)
 {
	 haveVisited = true;
	 for (int index = 0; index < doors.size(); index++)
	 {
		 if (dir.equals(doors.get(index).getDirection()))
		 {
			 return doors.get(index).getEntering();
		 }
	 }
	return null;
 }
 
 /**
  * this method takes the argument door and adds it to the doors ArrayList
  * @param door
  */
 public void addDoor(Door door)
 {
	 doors.add(door);
	 
 }
 
 /**

  * This method prints out all the Location's data, including all of the stored Door data from the 
  * ArrayList
  * @ return String (all the location data)
  */
 public String toString()
 {
	 String temp = "";
	 for (int i = 0; i < doors.size(); i++)
	 {
		 temp = temp + doors.get(i).describe() + "\n";
	 }
	 return "\n" + name + description + "\nThere are " + doors.size() + " door(s):\n" + temp + this.getItemsinLocation();
 }
 
 /**
  * This method functions as a toString, but excludes description.
  * @return String (everything except description)
  */
 public String alreadyVisited()
 {
	 String temp = "";
	 for (int i = 0; i < doors.size(); i++)
	 {
		 temp = temp + doors.get(i).describe() + "\n";
	 }
	 return name + "\n" + "\nThere are " + doors.size() + " door(s):\n" + temp + this.getItemsinLocation();
 }
 /**
  * This method adds the argument item to the argument arraylist and prints a receipt to the console
  * @param item
  */
 public void addItem(Item item)
 {
	 this.items.add(item);
	 System.out.println(item.getName() + " added to " + this.name);
 }
 /**
  * This method removes an item from the location. It searches through the arraylist for the
  * desired item, saving it in a placeholder to avoid concurrent modification errors, then
  * it removes the item once found, or prints a receipt that it isn't at this location.
  * @param item
  */
 public void removeItem(Item item)
 {
	 Item temporary = null;
	 for (Item stored: items)
	 {
		 if (item == stored)
		 {
			 temporary = stored;
			 break;
		 }
		 else
		 {
			 System.out.println("Item isn't present at this location.");
		 }
	 }
	 items.remove(temporary);
 }
 /**
  * This method iterates through the items arrayList, finding and returning the matching item
  * if it exists, and saying it doesn't exist if it doesnt.
  * @param name
  * @return Item stored/ null
  */
 public Item getItemNamed(String name)
 {
	 for (Item stored: items)
	 {
		if (name.equals(stored.getName()))
		{
			return stored;
		}
	 }
	 System.out.println("There's no Item with that name at this location.");
	 return null;
 }
 /**
  * This method concatonates all the items and their info into a string and returns it
  * @return concat list of items.
  */
 public String getItemsinLocation()
 {
	 String concat = "The items at this Location are: ";
	 for (Item stored: items)
	 {
		 concat = concat + "\n" + stored.getName() + ": " + stored.getMessage();
	 }
	 return concat;
 }
}
