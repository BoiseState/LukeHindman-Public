/* 0.5 Import File class */
import java.io.File;
import java.io.FileNotFoundException;
/* 0.75 Import Scanner class */
import java.util.Scanner;

public class CSVParser {

	public static void main(String[] args) {

		/* 1. Create a new File object */
		File bobsFile = new File("jimmy_buffett-collection.csv");

		/* 1.5 Check if file exists */
		if (bobsFile.exists() && bobsFile.isFile()) {

			/* 2. Create a Scanner to read the file */
			try {
				Scanner bobsScanner = new Scanner(bobsFile);

				/* 3. Create a loop to read each line from the Scanner */
				while(bobsScanner.hasNextLine()) {
					String line = bobsScanner.nextLine();

					/* 4. Print each line */
					System.out.println("Original Line: " + line);

					/* 5. Print out each word on its own line */
					Scanner bobsLineScanner = new Scanner (line);
					bobsLineScanner.useDelimiter(",");

					/* 6. Extract the individual fields from each line */
					String artist = bobsLineScanner.next();
					String album = bobsLineScanner.next();
					String title = bobsLineScanner.next();
					int duration = bobsLineScanner.nextInt();

					/* 7. Print each song */
					System.out.println("**************************");
					System.out.println("Artist:" + artist);
					System.out.println("Album:" + album);
					System.out.println("Title: " + title);
					System.out.println("Duration: " + duration);
					System.out.println("**************************");

				}

			} catch (FileNotFoundException e) {
				System.out.println("Unable to open file: " + bobsFile);
				System.exit(1);
			}

		} else {
			System.out.println("Unable to open file: " + bobsFile);
			System.exit(1);
		}


	}

}
