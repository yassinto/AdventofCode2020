import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7_2 {

	public static void main(String[] args) {
		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 7-1.txt";

		ArrayList<String> rules = new ArrayList<String>();
		ArrayList<LowerBag> bags = new ArrayList<LowerBag>();
		int superCount = 0;
		String myBag = "shiny gold bags contain";
		String filter = "bag";

		try {
			in = new Scanner(new FileReader(source));
			while (in.hasNext()) {
				String line = in.nextLine().trim();
				rules.add(line);
			}
			for (int i = 0; i < rules.size(); i++) {
				if (rules.get(i).contains(myBag)) {
					System.out.println(rules.get(i));
					String[] myRule = rules.get(i).split(" ");
					for (int j = 3; j < myRule.length; j++) {
						if (myRule[j].contains(filter)) {
							String color = myRule[j-2] + " " + myRule[j-1];
							int number = Integer.parseInt(myRule[j-3]);
							System.out.println(color);
							System.out.println(number);
							LowerBag lowerBag = new LowerBag(color, number);
							bags.add(lowerBag);
							superCount += number;
						}
					}
				}
			}
			for (int j = 0; j < bags.size(); j++) {
				for (int i = 0; i < rules.size(); i++) {
					if (rules.get(i).contains(bags.get(j).color + " bags contain")) {
						String[] myRule = rules.get(i).split(" ");
						for (int k = 3; k < myRule.length; k++) {
							if (myRule[k].contains(filter)) {
								if (!(myRule[k-2].equals("no"))) {
								String color = myRule[k-2] + " " + myRule[k-1];
								int number = Integer.parseInt(myRule[k-3]) * bags.get(j).number;
								System.out.println(color);
								System.out.println(number);
								LowerBag lowerBag = new LowerBag(color, number);
								bags.add(lowerBag);
								superCount += number;
								}
							}
						}
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
	
	public static class LowerBag {
		String color;
		int number;
		
		public LowerBag(String color, int number) {
			this.color = color;
			this.number = number;
		}
	}

}
