import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day5_1 {

	public static void main(String[] args) {
		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 5-1.txt";
		ArrayList<Integer> ids = new ArrayList<Integer>();
		int myID = 0;
		try {
			in = new Scanner(new FileReader(source));
			while (in.hasNext()) {
				String line = in.nextLine().trim();
				Integer[] resultRow = { 0, 127 };
				Integer[] resultCol = { 0, 7 };
				for (int i = 0; i < 7; i++) {
					resultRow = getRow(line, resultRow[1], resultRow[0], i);
				}
				int row = resultRow[0];

				for (int i = 7; i < 10; i++) {
					resultCol = getColumn(line, resultCol[1], resultCol[0], i);
				}
				int col = resultCol[0];

				int id = row * 8 + col;
				ids.add(id);
			}
			Collections.sort(ids, Collections.reverseOrder());

			for (int i = ids.get(ids.size() - 1); i < ids.get(0); i++) {
				if (ids.contains(i) == false) {
					myID = i;
				}
			}
			System.out.println("Highest ID: " + ids.get(0));
			System.out.println("My ID is: " + myID);
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file");
		} catch (Exception e) {
			System.out.println("Error occured while reading or closing file");
			e.printStackTrace();
		}
	}

	public static Integer[] getRow(String line, int max, int min, int index) {
		Integer[] result = new Integer[2];
		if (line.charAt(index) == 'F') {
			result[0] = min;
			result[1] = (max - ((max - min) / 2)) - ((max - min) % 2);
			return result;
		}
		if (line.charAt(index) == 'B') {
			result[0] = (min + ((max - min) / 2)) + ((max - min) % 2);
			result[1] = max;
			return result;
		}
		return null;
	}

	public static Integer[] getColumn(String line, int max, int min, int index) {
		Integer[] result = new Integer[2];
		if (line.charAt(index) == 'L') {
			result[0] = min;
			result[1] = (max - ((max - min) / 2)) - ((max - min) % 2);
			return result;
		}
		if (line.charAt(index) == 'R') {
			result[0] = (min + ((max - min) / 2)) + ((max - min) % 2);
			result[1] = max;
			return result;
		}
		return null;
	}
}