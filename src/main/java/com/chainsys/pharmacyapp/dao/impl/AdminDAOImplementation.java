package com.chainsys.pharmacyapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.chainsys.pharmacyapp.Exception.DbException;
import com.chainsys.pharmacyapp.Exception.InfoMessages;
import com.chainsys.pharmacyapp.dao.AdminDAO;
import com.chainsys.pharmacyapp.util.TestConnection;

@Repository

public class AdminDAOImplementation implements AdminDAO {

	public boolean AdminLogin(String Adminname, String pass) throws Exception {
		String sql = "select pass_word from AdminRegister where Admin_name=(select Admin_name from AdminRegister where Admin_name=?)";
		try (Connection con = TestConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, Adminname);
			ResultSet rs1 = stmt.executeQuery();
				
				if (rs1.next()) {
					String password = rs1.getString("pass_word");
					if (pass.equals(password)) {
						return true;
				}
				
				}}

		catch (SQLException e2) {
			e2.printStackTrace();
			throw new DbException(InfoMessages.lOGIN);
		}
		return false;
	}
}