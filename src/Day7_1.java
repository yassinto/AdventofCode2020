import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7_1 {

	public static void main(String[] args) {
		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 7-1.txt";

		ArrayList<String> rules = new ArrayList<String>();
		ArrayList<String> upperBags = new ArrayList<String>();
		int superCount = 0;
		String myBag = "shiny gold";

		try {
			in = new Scanner(new FileReader(source));
			while (in.hasNext()) {
				String line = in.nextLine().trim();
				rules.add(line);
			}

			for (int i = 0; i < rules.size(); i++) {
				if (rules.get(i).contains(myBag) && !(rules.get(i).contains(myBag + " bags contain"))) {
					superCount++;
					String[] myRule = rules.get(i).split(" ");
					upperBags.add(myRule[0] + " " + myRule[1]);
					rules.set(i, "");
				}
			}
			for (int j = 0; j < upperBags.size(); j++) {
				for (int i = 0; i < rules.size(); i++) {
					if (rules.get(i).contains(upperBags.get(j))
							&& !(rules.get(i).contains(upperBags.get(j) + " bags contain"))) {
						superCount++;
						String[] myRule = rules.get(i).split(" ");
						upperBags.add(myRule[0] + " " + myRule[1]);
						rules.set(i, "");
					}
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
