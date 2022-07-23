package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.DaoModel;
import Records.BankRecords;
import views.LoanView;

public class LoanProcessing extends BankRecords {

	public static void main(String[] args)  {
		BankRecords br = new BankRecords();
		br.readData();
		DaoModel dao = new DaoModel();
		dao.createTable();
		dao.insertRecords(robjs);	// perform inserts 
		ResultSet rs = null;
		try {
			rs = dao.retrieveRecords();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new LoanView().runView(rs);
	}

}
