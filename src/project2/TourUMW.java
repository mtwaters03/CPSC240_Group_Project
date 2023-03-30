package project2;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class TourUMW
{

	/**
	 * This method creates a new Campus object, as well as several Location and Door
	 * objects. The method reads through a file read by the scanner and detects and
	 * creates each Location. These Locations are stored in a hashtable in the
	 * Campus class. It then reads through the doors, assigning doors to the correct
	 * Locations. Then it reads each Item, creating and storing it at the appropriate location
	 * Finally, it prints the starting location, which is assumed to be
	 * the first Location in the file.
	 * 
	 * @param Scanner s
	 * @return Campus
	 */
	public Campus setUpCampus(Scanner s)
	{
		Campus campus = new Campus();
		Location first = new Location();
		campus.setCampusName(s.nextLine());
		s.nextLine();
		s.nextLine();
		String next = s.nextLine();
		next.trim();
		String nameHolder = "";
		first.setName(next);
		while (!(next.equals("+++")))
		{
			if (!(next.equals("+++")))
			{
				next = s.nextLine();
				next.trim();
				first.setDescription(first.getDescription() + "\n" + next + " ");
			} else
			{
				break;
			}
		}
		campus.addLocation(first);
		campus.setStartLocation(first);
		// System.out.println(first.toString());
		while (s.hasNextLine())
		{

			if (next.equals("+++"))
			{
				next = s.nextLine();
				next.trim();
				if (next.equals("*****"))
				{
					break;
				}
				Location loc = new Location();
				loc.setName(next);
				nameHolder = next;
				nameHolder.trim();
				campus.addLocation(loc);
				// System.out.println(loc.toString());
			}
			while (!(next.equals("+++")))
			{
				if ((!(next.equals("+++"))) && s.hasNextLine())
				{
					next = s.nextLine();
					next.trim();
					campus.getLocation(nameHolder)
							.setDescription(campus.getLocation(nameHolder).getDescription() + "\n" + next + " ");
				} else
				{
					break;
				}
			}
		}
		s.nextLine();
		while (s.hasNextLine())
		{
			nameHolder = s.nextLine();
			nameHolder.trim();
			// System.out.println(nameHolder);
			if (nameHolder.equals("*****"))
			{
				break;
			}
			Door pathway = new Door();
			pathway.setLeaving(campus.getLocation(nameHolder));
			pathway.setDirection(s.nextLine().trim());
			pathway.setEntering(campus.getLocation(s.nextLine().trim()));
			campus.getLocation(nameHolder).addDoor(pathway);
			s.nextLine();
		}
		s.nextLine();
		while (s.hasNextLine())
		{

			nameHolder = s.nextLine().trim();
			if (nameHolder.equals("*****"))
			{
				break;
			}
			// System.out.println(nameHolder);
			next = s.nextLine().trim();
			// System.out.println(next);
			String placeholder = s.nextLine().trim();
			// System.out.println(placeholder);
			if (!(placeholder == "+++") && !(placeholder == "*****"))
			{
				Item newItem = new Item();
				newItem.setName(nameHolder);
				newItem.setMessage(placeholder);
				campus.getLocation(next).addItem(newItem);
				// System.out.println(campus.getLocation(next).getItemsinLocation());
				s.nextLine();
			}
		}
		System.out.println("You are currently at: ");
		System.out.println(campus.getStartLocation().toString());
		campus.getStartLocation().setVisited(true);
		return campus;
	}

	/**
	 * This method takes in a scanner, reading input from the user. It decides which 
	 * type of input this is and returns a UIC of the according type.
	 * 
	 * @param input
	 * @return String
	 */
	public UserInputCommand promptUser(Scanner input)
	{
		System.out.println(
				"Please enter a direction (n,s,e,w), backpack, drop (itemName), pickup (itemName),  or quit (q).");
		input = new Scanner(System.in);
		String userInput = input.nextLine();
		userInput.toLowerCase();
		UserInputCommand pass;
		if (userInput.equals("q"))
		{
			System.out.println("You have quit the program");
			System.exit(0);
		}
		else if (userInput.equals("n") || userInput.equals("s") || userInput.equals("e") || userInput.equals("w"))
		{
			pass = new MovementCommand(userInput);
			return pass;
		}
		else if (userInput.substring(0, 4).equals("drop"))
		{
			try
			{
			pass = new DropCommand(userInput.substring(5));
			return pass;
			}
			catch (StringIndexOutOfBoundsException e)
			{
				System.out.println("You must have the word 'drop' followed by a space followed by an item name");

			}
		}
		else if (userInput.substring(0, 6).equals("pickup"))
		{
			try
			{
			pass = new PickupCommand(userInput.substring(7));
			return pass;
			}
			catch (StringIndexOutOfBoundsException e)
			{
				System.out.println("You must have the word 'pickup' followed by a space followed by an item name");
			}
		} 
		else if (userInput.equals("backpack"))
		{
			pass = new BackpackCommand();
			return pass;
		}
		else
		{
			pass = new InvalidCommand(userInput);
			return pass;
		}
		
		return null;
	}

	/**
	 * Main method creates TourUMW, Campus, TourStatus, UserInputCommand, and Scanner
	 *  objects. It requires the user to input a valid file, which it reads, and then prompts the user for input
	 *  until they enter q to quit. During the whole process, information is printed to the
	 *  console about the tour.
	 * @param args
	 */
	public static void main(String[] args)
	{
		TourUMW tour = new TourUMW();
		Scanner scanner = null;
		String userInput = "";
		Campus campus = null;
		TourStatus status = new TourStatus();
		UserInputCommand command;
		boolean whilelooper = true;
		while (whilelooper)
		{
			System.out.println("Enter a .txt file");
			scanner = new Scanner(System.in);
			userInput = scanner.nextLine();
			if (userInput.equals("q"))
			{
				System.exit(0);
			}
			try
			{
				File in = new File(userInput);
				scanner = new Scanner(in);
				whilelooper = false;
			} catch (FileNotFoundException e)
			{
				System.out.println("Error: File name not found. Please enter a valid file name.");

			}
			campus = tour.setUpCampus(scanner);
			status.setCampus(campus);
		}
		whilelooper = true;
		while (whilelooper)
		{
			command = tour.promptUser(scanner);
			System.out.println(command.carryOut(status));
		}
		scanner.close();
	}
}
