package project2;

public interface UserInputCommand
{		
		/**
		 * This method is where the commands are carried out in all classes that implement.
		 * @param ts
		 * @return String receipt
		 */
		public String carryOut(TourStatus ts);
}
