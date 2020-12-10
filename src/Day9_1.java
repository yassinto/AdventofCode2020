import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day9_1 {

	public static void main(String[] args) {
		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 9-1.txt";

		ArrayList<Long> allNumbers = new ArrayList<Long>();
		
		long theNumber = 0;
		
		try {
			in = new Scanner(new FileReader(source));
			while (in.hasNext()) {
				String line = in.nextLine().trim();
				allNumbers.add(Long.parseLong(line.trim()));
			}
			for (int i = 25; i < allNumbers.size(); i++ ) {
				ArrayList<Long> pairs = new ArrayList<Long>();
				long number = allNumbers.get(i);
				for (int j = i - 25; j < i ; j++) {
					long first = allNumbers.get(j);
					for (int k = i - 25; k < i ; k++ ) {
						long second = allNumbers.get(k);
						if (j == k) {
							continue;
						}
						else {
							pairs.add(first + second);
						}
					}
				}
					if (!(pairs.contains(number))) {
						theNumber = number;
						break;
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
