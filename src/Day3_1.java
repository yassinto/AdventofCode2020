import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day3_1 {
	public static void main(String[] args) {
		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 3-3.txt";
		int superCount = 0;
		int right = 0;
		try {
			in = new Scanner(new FileReader(source));
			while (in.hasNext()) {
				String line = in.nextLine();
				line = line.trim();
				if (right > (line.length() - 1)) {
					right = right - line.length();
				}
				if (line.charAt(right) == '#') {
					superCount++;
				}
				right += 7;
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
