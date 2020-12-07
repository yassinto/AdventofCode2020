import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6_2 {
	public static void main(String[] args) {
		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 6-1.txt";

		int superCount = 0;
		String filler = "";
		ArrayList<String> group = new ArrayList<String>();

		try {
			in = new Scanner(new FileReader(source));
			while (in.hasNext()) {
				String line = in.nextLine().trim();
				if (line.equals("")) {
					for (int i = 0; i < group.size(); i++) {
						for (int j = 0; j < group.get(i).length(); j++) {
							if (group.get(0).contains(Character.toString(group.get(i).charAt(j)))) {
								if (filler.contains(Character.toString(group.get(i).charAt(j))) == false) {
									filler += (Character.toString(group.get(i).charAt(j)));
								}
							} else if (filler.contains(Character.toString(group.get(i).charAt(j)))) {
								filler = filler.replace(Character.toString(group.get(i).charAt(j)), "");
							}
						}
					}
					if (group.size() > 1) {
						for (int j = 0; j < group.get(0).length(); j++) {
							for (int i = 1; i < group.size(); i++) {
								if (group.get(i).contains(Character.toString(group.get(0).charAt(j))) == false) {
									if (filler.contains(Character.toString(group.get(0).charAt(j)))) {
										filler = filler.replace(Character.toString(group.get(0).charAt(j)), "");
									}
								}
							}
						}
					}
					System.out.println(filler);
					System.out.println(filler.length());
					superCount += filler.length();
					System.out.println(superCount);
					filler = "";
					group = new ArrayList<String>();
				} else {
					group.add(line);
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
