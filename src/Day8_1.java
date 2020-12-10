import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8_1 {
	
	public static void main(String[] args) {
		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 8-1.txt";
		
		ArrayList<String> instructions = new ArrayList<String>();
		ArrayList<Integer> usedIndexes = new ArrayList<Integer>();
		
		int superCount = 0;
		
		String accumulator = "acc";
		String jump = "jmp";
		String noOperation = "nop";
		
		
		try {
			in = new Scanner(new FileReader(source));
			while (in.hasNext()) {
				String line = in.nextLine().trim();
				instructions.add(line);
			}
			for (int i = 0; ; ) {
				if (usedIndexes.contains(i)) {
					break;
				}
				usedIndexes.add(i);
				String instruction = instructions.get(i);
				if (instruction.contains(accumulator)) {
					superCount += Integer.parseInt(instruction.substring(4).trim());
					i++;
				}
				else if (instruction.contains(jump)) {
					i += Integer.parseInt(instruction.substring(4).trim());
				}
				else if (instruction.contains(noOperation)) {
					i++;					
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

}
