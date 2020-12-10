import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day9_2 {

	public static void main(String[] args) {
		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 9-1.txt";

		ArrayList<Long> allNumbers = new ArrayList<Long>();
		final long invalid = 20874512;
		long theNumber = 0;

		try {
			in = new Scanner(new FileReader(source));
			while (in.hasNext()) {
				String line = in.nextLine().trim();
				allNumbers.add(Long.parseLong(line.trim()));
			}
			outerloop: for (int i = 0; i < allNumbers.size(); i++) {
				long lead = allNumbers.get(i);
				ArrayList<Long> set = new ArrayList<Long>();
				set.add(lead);
				long counter = lead;
				for (int j = i + 1; j < allNumbers.size(); j++) {
					long add = allNumbers.get(j);
					counter += add;
					if (counter > invalid) {
						break;
					} else {
						set.add(add);
						if (counter == invalid) {
							Collections.sort(set);
							theNumber = set.get(0) + set.get(set.size() - 1);
							break outerloop;
						}
					}
				}
			}
			System.out.println(theNumber);
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file");
		} catch (Exception e) {
			System.out.println("Error occured while reading or closing file");
			e.printStackTrace();
		}
	}

}
