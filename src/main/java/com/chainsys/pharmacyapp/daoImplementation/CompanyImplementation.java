package com.chainsys.pharmacyapp.daoImplementation;
//Test class

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.chainsys.pharmacyapp.companyDetails.TestConnection;
import com.chainsys.pharmacyapp.dao.CompanyDAO;
import com.chainsys.pharmacyapp.model.CompanyModel;

public class CompanyImplementation implements CompanyDAO {


	public int addCompanyDetails(CompanyModel p) throws Exception {
		// TODO Auto-generated method stub
		int n=0;
		String sql = "Insert into company( company_id, company_name, company_type,company_address) values (?,?,?,?)";
		Connection con = TestConnection.getConnection();
		System.out.println(sql);
		System.out.println(con);
		PreparedStatement stmp = con.prepareStatement(sql);
		stmp.setInt(1, p.getCompanyId());
		stmp.setString(2, p.getCompanyName());
		stmp.setString(3, p.getCompanyType());
		stmp.setString(4, p.getCompanyAddress());
	  n= stmp.executeUpdate();
	  System.out.println(n);
		
	

	return n;
	}
}
