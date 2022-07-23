package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Records.BankRecords;

public class DaoModel {
		
		// Declare DB objects
		DBConnect conn = null;
		Statement stmt = null;
		
		// Constructor
		public DaoModel() { // create a DB object instance 
			conn = new DBConnect();
		}
		
		// Create table method
		public void createTable() {
			try {
				
				// open a connection 
				System.out.println("Connecting to database to create Table..");
				System.out.println("Connected database successfully..");
				
				// Excute create query
				System.out.println("Creating table in given database..");
				
				stmt = conn.connect().createStatement();
				
				String sql = "CREATE TABLE Z_Jin_tab2" +
						"(pid INTEGER not NULL AUTO_INCREMENT, " +
						" id VARCHAR(10), " +
						" income numeric(8,2), " +
						" pep VARCHAR(3), " +
						" PRIMARY KEY ( pid ))";
				stmt.executeUpdate(sql);
				System.out.println("Created table in given database...");
				conn.connect().close(); // close DB connection
			} catch(SQLException se) { // Handle errors for JDBC 
				se.printStackTrace();
			}
		}
		
		// insert into method
		public void insertRecords(BankRecords[] robjs) {
			try {
				// Execute a query 
				System.out.println("Inserting records into the table...");
				stmt = conn.connect().createStatement();
				String sql = null;
				
				// Include all object data to the database table
				for(int i = 0; i < robjs.length;++i) {
					// finish string assignment below to insert all array object data
					// (id, income, pep) into your database table
					sql = "INSERT INTO Z_Jin_tab2(id, income, pep)" + "VALUES ('"+ robjs[i].getId() + "', '"+ robjs[i].getIncome()  + "', '"+ robjs[i].getPep() + "')";
					stmt.execute(sql);
					
				}
				 System.out.println(" Records Inserted !");
				conn.connect().close(); // close DB connection
			}catch(SQLException se) {se.printStackTrace();} // Handle errors for JDBC 
			
			
		}
		//Include a method to retrieve records for display called retrieveRecords().
				public ResultSet retrieveRecords() throws SQLException {
					ResultSet rs = null;
					
					stmt = conn.connect().createStatement();
					
					String sql = "SELECT * FROM Z_Jin_tab2 order by pep desc";
					rs = stmt.executeQuery(sql);
					conn.connect().close();
					return rs;
					
				}
		

}
