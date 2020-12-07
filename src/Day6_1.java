import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day6_1 {

	public static void main(String[] args) {
		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 6-1.txt";

		int superCount = 0;
		String filler = "";
		String yes = "";

		try {
			in = new Scanner(new FileReader(source));
			while (in.hasNext()) {
				String line = in.nextLine().trim();
				if (line.equals("")) {
					for (int i = 0; i < filler.length(); i++) {
						if (yes.contains(Character.toString(filler.charAt(i))) == false) {
							yes += Character.toString(filler.charAt(i));
						}
					}
					yes = yes.replaceAll("\\s", "");
					superCount += yes.length();
					yes = "";
					filler = "";
				} else {
					filler = filler + " " + line;
				}
			}
			System.out.print(superCount);
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file");
		} catch (Exception e) {
			System.out.println("Error occured while reading or closing file");
			e.printStackTrace();
		}
	}

}
