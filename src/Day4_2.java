import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day4_2 {

	public static void main(String[] args) {
		Scanner in;
		String source = "C:" + File.separator + "Projects" + File.separator + "Advent of code 2020" + File.separator
				+ "Day 4-1.txt";

		int superCount = 0;
		String filler = null;
		boolean byr = false;
		boolean iyr = false;
		boolean eyr = false;
		boolean hgt = false;
		boolean hcl = false;
		boolean ecl = false;
		boolean pid = false;
		try {
			in = new Scanner(new FileReader(source));
			while (in.hasNext()) {
				String line = in.nextLine();
				if (line.equals("") || !(in.hasNext())) {
					if (validPass(filler)) {
						String[] passport = filler.split(" ");
						for (String at : passport) {
							if (at.length() > 3) {
								if (at.subSequence(0, 3).equals("byr")) {
									byr = validBirth(at);
									System.out.println("byr: " + byr + " " + at);
								}
								if (at.subSequence(0, 3).equals("iyr")) {
									iyr = validIssue(at);
									System.out.println("iyr: " + iyr + " " + at);
								}
								if (at.subSequence(0, 3).equals("eyr")) {
									eyr = validExpire(at);
									System.out.println("eyr: " + eyr + " " + at);
								}
								if (at.subSequence(0, 3).equals("hgt")) {
									hgt = validHeight(at);
									System.out.println("hgt: " + hgt + " " + at);
								}
								if (at.subSequence(0, 3).equals("hcl")) {
									hcl = validHair(at);
									System.out.println("hcl: " + hcl + " " + at);
								}
								if (at.subSequence(0, 3).equals("ecl")) {
									ecl = validEyes(at);
									System.out.println("ecl: " + ecl + " " + at);
								}
								if (at.subSequence(0, 3).equals("pid")) {
									pid = validPid(at);
									System.out.println("pid: " + pid + " " + at);
								}
							}
						}
						System.out.println("--------");
						if (byr && iyr && eyr && hgt && hcl && ecl && pid) {
							superCount++;
						}
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

	public static boolean validPass(String filler) {
		if (filler.contains("byr:") && filler.contains("iyr:") && filler.contains("eyr:") && filler.contains("hgt:")
				&& filler.contains("hcl:") && filler.contains("ecl:") && filler.contains("pid:")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validBirth(String filler) {
		try {
			int byr = Integer.parseInt(filler.substring(4));
			if ((byr >= 1920) && (byr <= 2002)) {
				return true;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}
		return false;
	}

	public static boolean validIssue(String filler) {
		try {
			int iyr = Integer.parseInt(filler.substring(4));
			if ((iyr >= 2010) && (iyr <= 2020)) {
				return true;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}
		return false;
	}

	public static boolean validExpire(String filler) {
		try {
			int eyr = Integer.parseInt(filler.substring(4));
			if ((eyr >= 2020) && (eyr <= 2030)) {
				return true;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}
		return false;
	}

	public static boolean validHeight(String filler) {
		String metric = filler.substring(filler.length() - 2);
		if ((metric.equals("cm")) || (metric.equals("in"))) {
			try {
				String len = filler.substring(4);
				int hgt = Integer.parseInt(len.substring(0, len.length() - 2));
				if (metric.equals("cm")) {
					if ((hgt >= 150) && (hgt <= 193)) {
						return true;
					}
				}
				if (metric.equals("in")) {
					if ((hgt >= 59) && (hgt <= 76)) {
						return true;
					}
				}
				System.out.print(hgt);
			} catch (NumberFormatException nfe) {
				return false;
			}
		}
		return false;
	}

	public static boolean validHair(String filler) {
		filler = filler.substring(4);
		if (filler.substring(0, 1).equals("#")) {
			if (filler.length() == 7) {
				filler = filler.replaceAll("[a-f0-9]", "");
				if (filler.equals("#")) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean validEyes(String filler) {
		filler = filler.substring(4);
		String[] colors = { "amb", "blu", "brn", "gry", "grn", "hzl", "oth" };
		for (String color : colors) {
			if (filler.equals(color)) {
				return true;
			}
		}
		return false;
	}

	public static boolean validPid(String filler) {
		filler = filler.substring(4);
		if (filler.length() == 9) {
			if (filler.replaceAll("[0-9]", "").equals("")) {
				return true;
			}
		}
		return false;
	}
}
