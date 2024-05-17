import java.util.Scanner;
import java.io.*;

public class PatchMain {

	public static void main(String[] args) throws IOException {
		/*
		Patch test = new Patch("test");
		test.makeConnection("slew out", "fm");
		test.makeConnection("envelope out", "vca");

		System.out.println(test);
		*/
		
		askForPatch();
	}
	
	public static void askForPatch() throws IOException {
		Scanner in = new Scanner(System.in);
		String input = "";
		System.out.println("Enter the name of a patch to create, or enter a saved patch to view it");
		input = in.nextLine();
		
		if (patchExists(input)) {
			Scanner saved = new Scanner("SavedPatches.txt");

			printPatch(input, saved);
		}
		else {
			newPatch(input);
		}
		
		

		
	}
	
	public static void newPatch(String name) throws IOException {
		
		try {
			
			

			Scanner in = new Scanner(System.in);
			String input = "";
			System.out.println("Enter the details of the patch in this format: 'out in, out in,' etc");
			input = in.nextLine();
			
			BufferedWriter out = new BufferedWriter(new FileWriter("SavedPatches.txt", true));
			out.append(name + " " + input + "\n");
			
			out.close();
			
			System.out.println("Patch saved!");
			
			String noCommas = input;
			noCommas = noCommas.replace(',', ' ');
			Scanner details = new Scanner(noCommas);
			
			printPatch(name, details);

			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.out.println("SavedPatches.txt was not found");
		}
	}
	
	
	
	public static boolean patchExists(String name) {
		Scanner saved = new Scanner("SavedPatches.txt");
		while (saved.hasNext()) {
			if (saved.next() == name) {
				return true;
			}
		}
		return false;
	}
	
	public static void printPatch(String name, Scanner details) {
		
		Patch toPrint = new Patch(name);
		while (details.hasNext()) {
			toPrint.makeConnection(details.next(), details.next());
		}
		
		System.out.println(toPrint);
	}

}
