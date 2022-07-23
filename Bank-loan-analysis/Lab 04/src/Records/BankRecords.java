package Records;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BankRecords extends Client {

	// setup static objects for IO processing

	// array of BankRecords objects
	protected static BankRecords robjs[] = new BankRecords[600];
	// arraylist to hold spreadsheet rows & columns
	static ArrayList<List<String>> array = new ArrayList<>();

	// instance fields
	private String id;
	private int age;
	private String sex;
	private String region;
	private double income;
	private String married;
	private int children;
	private String car;
	private String save_act;
	private String current_act;
	private String mortgage;
	private String pep;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankRecords br = new BankRecords();
		br.readData();

	}

	@Override
	public void readData() {
		BufferedReader br = null;

		// initialize reader object and set file path to root of project
		try {
			br = new BufferedReader(new FileReader(new File("Lab 04/libs/bank-Detail.csv")));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		String line;

		// read each record in csv file
		try {
			while ((line = br.readLine()) != null) {
				// parse each record in csv file by a comma ( , )
				// into a list stored in the arraylist-> Arrays
				array.add(Arrays.asList(line.split(",")));
				// System.out.println(array);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		processData(); // call function for processing record data

	}

	@Override
	public void processData() {
		// create index for array while iterating thru arraylist
		int idx = 0;
		// create for each loop to cycle thru arraylist of values
		// and PASS that data into your record objects' setters
		for (List<String> rowData : array) {
			// initialize array of objects
			robjs[idx] = new BankRecords();
			// call setters below and populate them, item by item
			robjs[idx].setId(rowData.get(0)); // get 1st column
			robjs[idx].setAge(Integer.parseInt(rowData.get(1))); // get 2nd column
			/*
			 * continue processing arraylist item values into each array object -> robjs[ ]
			 * by index
			 */

			robjs[idx].setSex(rowData.get(2));
			robjs[idx].setRegion(rowData.get(3).trim());
			robjs[idx].setIncome(Double.parseDouble(rowData.get(4)));
			robjs[idx].setMarried(rowData.get(5));
			robjs[idx].setChildren(Integer.parseInt(rowData.get(6)));
			robjs[idx].setCar(rowData.get(7));
			robjs[idx].setSave_act(rowData.get(8));
			robjs[idx].setCurrent_act(rowData.get(9));
			robjs[idx].setMortgage(rowData.get(10).trim());
			robjs[idx].setPep(rowData.get(11));

			idx++;
		}

		printData();

	}

	@Override
	public void printData() {
		// 1. Set appropriate headings for displaying first 25 records
		System.out.println("ID\t\tAGE\t\tSEX\t\tREGION\t\t\tINCOME\t\t\tMORTGAGE");
		// 2. Create for loop and print each record objects instance data
		for (int i = 0; i < 25; i++) {
			if (robjs[i] != null) {
				// 3. Within for loop use appropriate formatting techniques to print out record
				// detail
				String str=String.format("%-5s\t\t%-5d\t\t%-5s\t\t%-10s\t\t%-8.2f\t\t%-5s", robjs[i].getId(), robjs[i].getAge(),
						robjs[i].getSex(), robjs[i].getRegion(), robjs[i].getIncome(), robjs[i].getMortgage()); 
				System.out.println(str);
			}

		}
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the income
	 */
	public double getIncome() {
		return income;
	}

	/**
	 * @param income the income to set
	 */
	public void setIncome(double income) {
		this.income = income;
	}

	/**
	 * @return the married
	 */
	public String getMarried() {
		return married;
	}

	/**
	 * @param married the married to set
	 */
	public void setMarried(String married) {
		this.married = married;
	}

	/**
	 * @return the children
	 */
	public int getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(int children) {
		this.children = children;
	}

	/**
	 * @return the car
	 */
	public String getCar() {
		return car;
	}

	/**
	 * @param car the car to set
	 */
	public void setCar(String car) {
		this.car = car;
	}

	/**
	 * @return the save_act
	 */
	public String getSave_act() {
		return save_act;
	}

	/**
	 * @param save_act the save_act to set
	 */
	public void setSave_act(String save_act) {
		this.save_act = save_act;
	}

	/**
	 * @return the mortgage
	 */
	public String getMortgage() {
		return mortgage;
	}

	/**
	 * @param mortgage the mortgage to set
	 */
	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}

	/**
	 * @return the pep
	 */
	public String getPep() {
		return pep;
	}

	/**
	 * @param pep the pep to set
	 */
	public void setPep(String pep) {
		this.pep = pep;
	}

	public String getCurrent_act() {
		return current_act;
	}

	public void setCurrent_act(String current_act) {
		this.current_act = current_act;
	}

}
