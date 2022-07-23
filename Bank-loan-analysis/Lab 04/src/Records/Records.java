package Records;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

public class Records extends BankRecords { // The implementation of BankRecords.java  
	static FileWriter fw = null;

	public Records() {
		try {
			fw = new FileWriter("bankrecords.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) { // the main program: that calls all methods compiled 

		BankRecords br = new Records(); // the BufferedReader method inherited from BankRecords.java 
		br.readData();

		writeHeadInfo();
		AvgComp();
		FemaleAny();
		RegionAny();
		addDate();
		closeFileWriter();
	}

	private static void addDate() { // addDate method writes my name and current system time on the output txt file 
		
		Date date1 = new Date();
		try {
			fw.write("Zhenglin Jin\n");
			fw.write(date1.toString());
			fw.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void writeHeadInfo() {	// The writeHeadIndo method: prints "Data analytic results:" title on console and txt file
		System.out.println("Data analytic results:");
		System.out.println();

		try {
			fw.write("Data analytic results:\n");
			fw.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void AvgComp() {	// The avgComp method: this method calculates The average income for males and females and print them as shown

		Arrays.sort(robjs, new SexComparator());

		// set up needed variables to gather counts & income by sex
		// to determine average income by sex

		int maleCt = 0, femCt = 0;
		double maleInc = 0, femInc = 0;

		for (int i = 0; i < robjs.length; i++) {
			if (robjs[i].getSex().equals("FEMALE")) {
				++femCt;
				femInc += robjs[i].getIncome();
			} else {
				++maleCt;
				maleInc += robjs[i].getIncome();
			}
		}

		// display resulting averages to console and to file

		System.out.printf("Avg inc. for Females: $%.2f\n", (femInc / femCt));
		System.out.printf("Avg inc. for Males: $%.2f\n", (maleInc / maleCt));
		System.out.println();

		try {
			fw.write("Avg inc. for Females: $" + (femInc / femCt) + "\n");
			fw.write("Avg inc. for Males: $" + (maleInc / maleCt) + "\n");
			fw.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void FemaleAny() {	// The FemaleAny method: this method calculate Num.of Females with Mortage & savings account and print then as shown
		int count = 0;
		for (int i = 0; i < robjs.length; i++) {
			if (robjs[i].getSex().equals("FEMALE") && robjs[i].getMortgage().equals("YES")
					&& robjs[i].getSave_act().equals("YES")) {
				count++;
			}
		}
		System.out.printf("Num.of Females with Mortage & savings acct: saving act: %d\n", count);
		System.out.println();
		try {
			fw.write("Num.of Females with Mortage & saving act: " + count + "\n");
			fw.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void RegionAny() { 	// The RegionAny method: this method counts the number of males with both a car and 1 child per location and print then as shown
		Arrays.sort(robjs, new LocationComparator());
		
		List<String> regionSet = new ArrayList<String>();
		for (int i = 0; i < robjs.length; i++) {
			if(!regionSet.contains(robjs[i].getRegion()))
			   regionSet.add(robjs[i].getRegion());
		}

		Map<String, Integer> regions = new HashMap<String, Integer>();
		for (int i = 0; i < robjs.length; i++) {
			String region = robjs[i].getRegion();

			if (robjs[i].getChildren() == 1 && robjs[i].getCar().equals("YES") && robjs[i].getSex().equals("MALE")) {

				if (regions.containsKey(region)) {
					regions.replace(region, regions.get(region) + 1);

				} else {
					regions.put(region, 1);
				}
			}
		}

		/*
		 * for(String region:regions.keySet()) {
		 * System.out.printf(region+".......: %d\n", regions.get(region)); }
		 */

		for (String region : regionSet) {
			if (regions.containsKey(region))
				System.out.printf(region + " males with car & 1 child: : %d\n", regions.get(region));
		}

		try {
			/*
			 * for(String region:regions.keySet()) {
			 * fw.write(region+".......: "+regions.get(region)+"\n"); }
			 */
			for (String region : regionSet) {
				if (regions.containsKey(region))
					fw.write(region + " males with car & 1 child: " + regions.get(region) + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeFileWriter() {
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

