import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day4_1 {

	public static void main(String[] args) {
		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 4-1.txt";
		int superCount = 0;
		String filler = null;
		try {
			in = new Scanner(new FileReader(source));
			while (in.hasNext()) {
				String line = in.nextLine();
				if (line.equals("") || !(in.hasNext())) {
					System.out.println(filler);
					if (filler.contains("byr:") && filler.contains("iyr:") && filler.contains("eyr:")
							&& filler.contains("hgt:") && filler.contains("hcl:") && filler.contains("ecl:")
							&& filler.contains("pid:")) {
						superCount++;
					}
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
