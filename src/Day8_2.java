import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8_2 {

	public static void main(String[] args) {
		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 8-1.txt";

		ArrayList<String> instructions = new ArrayList<String>();

		int superCount = 0;

		String jump = "jmp";
		String noOperation = "nop";

		try {
			in = new Scanner(new FileReader(source));
			while (in.hasNext()) {
				String line = in.nextLine().trim();
				instructions.add(line);
			}
			for (int i = 0; i < instructions.size(); i++) {
				String instruction = instructions.get(i);
				if (instruction.contains(jump)) {
					ArrayList<String> testInstructions = new ArrayList<String>(instructions);
					String testIntruction = noOperation + instruction.substring(3);
					testInstructions.set(i, testIntruction);
					superCount = findCorruptInstruction(testInstructions);
					if (superCount != 0) {
						break;
					}
				} else if (instruction.contains(noOperation)) {
					ArrayList<String> testInstructions = new ArrayList<String>(instructions);
					String testIntruction = jump + instruction.substring(3);
					testInstructions.set(i, testIntruction);
					superCount = findCorruptInstruction(testInstructions);
					if (superCount != 0) {
						break;
					}
				}
			}
			System.out.print("Accumlator: ");
			System.out.print(superCount);
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file");
		} catch (Exception e) {
			System.out.println("Error occured while reading or closing file");
			e.printStackTrace();
		}
	}

	public static int findCorruptInstruction(ArrayList<String> instructions) {
		ArrayList<Integer> usedIndexes = new ArrayList<Integer>();

		String accumulator = "acc";
		String jump = "jmp";
		String noOperation = "nop";

		int superCount = 0;

		for (int i = 0;;) {
			if (usedIndexes.contains(i)) {
				return 0;
			}
			if (i >= instructions.size()) {
				return superCount;
			}
			String instruction = instructions.get(i);
			usedIndexes.add(i);
			if (instruction.contains(accumulator)) {
				superCount += Integer.parseInt(instruction.substring(4).trim());
				i++;
			} else if (instruction.contains(jump)) {
				i += Integer.parseInt(instruction.substring(4).trim());
			} else if (instruction.contains(noOperation)) {
				i++;
			}
		}

	}

}
