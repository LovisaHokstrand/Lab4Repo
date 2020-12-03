package wordscan;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordScan {
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String s = scan.nextLine();
			String[] inputs = s.split(" ");
			if (inputs[0].equals("search")) {
				String pattern = inputs[1];
				File f = new File(inputs[2]);

				FileReader fr = null;
				try {
					fr = new FileReader(f);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedReader br = null; 
				br = new BufferedReader(fr); // Creation of BufferedReader object

				String a;
				String[] words = null; // Intialize the word Array
				int count = 0; // Intialize the word to zero
				try {
					while ((a = br.readLine()) != null) // Reading Content from the file
					{
						words = a.split(" "); // Split the word using space
						for (String word : words) {
							if (word.equals(pattern)) // Search for the given word
							{
								System.out.println(a);
								count++;
							}
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (count != 0) // Check for count not equal to zero
				{
					System.out.println("The pattern is present " + count + " times in the file");
				} else {
					System.out.println("The pattern is not present in the file");
				}
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
