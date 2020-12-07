import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day2_1 {

	public static void main(String[] args) {
		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 2-1.txt";

		int superCount = 0;
		try {
			in = new Scanner(new FileReader(source));
			in.useDelimiter("[\\s\\-]");
			while (in.hasNext()) {
				int min = Integer.parseInt(in.next().trim());
				int max = Integer.parseInt(in.next().trim());
				char letter = in.next().trim().charAt(0);
				String pass = in.next().trim();
				if (in.hasNext()) {
					in.next();
				}
				int count = 0;
				for (int i = 0; i < pass.length(); i++) {
					if (pass.charAt(i) == letter) {
						count++;
					}
				}
				if ((count >= min) && (count <= max)) {
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
