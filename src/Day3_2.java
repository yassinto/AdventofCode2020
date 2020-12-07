import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3_2 {

	public static void main(String[] args) {
		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 3-3.txt";

		int superCount = 0;
		int right = 0;
		int iteration = 0;

		ArrayList<Character> all = new ArrayList<Character>();
		ArrayList<Character> evens = new ArrayList<Character>();
		try {
			in = new Scanner(new FileReader(source));
			while (in.hasNext()) {
				String line = in.nextLine();
				line = line.trim();
				if (right > (line.length() - 1)) {
					right = right - line.length();
				}
				all.add(line.charAt(right));
				if (iteration % 2 == 0) {
					right++;
				}
				iteration++;
			}
			for (int index = 0; index < all.size(); index += 2) {
				evens.add(all.get(index));
			}
			for (char even : evens) {
				if (even == '#') {
					superCount++;
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
