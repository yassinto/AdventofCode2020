import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Day1_2 {

	public static void main(String[] args) {

		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 1-1.txt";
		String line = null;

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int ding1 = 0;
		int ding2 = 0;
		int ding3 = 0;
		try {
			in = new Scanner(new FileReader(source));
			while (in.hasNext()) {
				line = in.nextLine();
				numbers.add(Integer.parseInt(line.trim()));
			}
			for (int num1 : numbers) {
				for (int num2 : numbers) {
					for (int num3 : numbers) {
						if (num1 + num2 + num3 == 2020) {
							ding1 = num1;
							ding2 = num2;
							ding3 = num3;
						}
					}
				}
			}
			in.close();
			System.out.print(ding1 + " " + ding2 + " " + ding3);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file");
		} catch (Exception e) {
			System.out.println("Error occured while reading or closing file");
			e.printStackTrace();
		}

	}
}
