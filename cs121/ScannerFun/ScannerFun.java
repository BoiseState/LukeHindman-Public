import java.util.Scanner;

public class ScannerFun {

	public static void main(String[] args) {
		/* Declare variables for name and age */
		String name;
		int age;
		
		/* Instantiate (create) a new Scanner object */
		Scanner kbd = new Scanner(System.in);
		
		/* Prompt for name and read line from keyboard */
		System.out.print("Please enter your name: ");
		name = kbd.nextLine();
		
		System.out.println("Hello " + name + ", it is a pleasure to meet you!");
		System.out.println("\n\n\n");
		
		/* Prompt for age and read line from keyboard */
		System.out.print(name + ", how old do you feel today? ");
		age = Integer.parseInt(kbd.nextLine());
		
		System.out.println("Wow! " + age + " is a great age!");
		System.out.println("That means you were born in " + (2020 - age));
		
		kbd.close();
	}

}
