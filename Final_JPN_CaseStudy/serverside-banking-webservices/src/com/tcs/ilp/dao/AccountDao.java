package com.tcs.ilp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.ilp.beans.UserDetails;
import com.tcs.ilp.beans.Users;
import com.tcs.ilp.utils.DBUtility;

import oracle.jdbc.OracleTypes;

public class AccountDao {

	
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	CallableStatement cs= null;
	int affected= 0;
	
	public int insertFile(String name){
		try {
			con = DBUtility.createConnection();
			System.out.println(name);
			String query = "BEGIN INSERT INTO FILES_BANKING values (files_seq.NEXTVAL, ?) returning fid into ?; END;";
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, name);
			cs.registerOutParameter(2, OracleTypes.NUMBER);
			cs.execute();
			System.out.print(cs.getInt(2));
			return cs.getInt(2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	public boolean addUser(Users user) {
		try {
			con = DBUtility.createConnection();
			String query = "INSERT INTO USERS_BANKING values (?, ?, ?, ?, ?, ?, ?, TO_DATE(?,'YYYY-MM-DD'), ?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getSid());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getGender());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getPassword());
			pstmt.setString(8, user.getDob());
			pstmt.setInt(9, user.getSid_id());
			pstmt.setInt(10, user.getDoc1());
			pstmt.setInt(11, user.getDoc2());
			pstmt.setInt(12, 1);
			affected = pstmt.executeUpdate();
			if(affected > 0){
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int createCreditCard(String address) {
		try {
			con = DBUtility.createConnection();
			String query = "BEGIN INSERT INTO CREDIT_CARD_BANKING values (crd_seq.NEXTVAL, crdn_seq.NEXTVAL, ?) returning cid into ?; END;";
			CallableStatement cs = con.prepareCall(query);
			cs.setString(1, address);
			cs.registerOutParameter(2, OracleTypes.NUMBER);
			cs.execute();
			return cs.getInt(2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	public int createCashCard(int cid) {
		try {
			con = DBUtility.createConnection();
			String query = "BEGIN INSERT INTO CASH_CARD_BANKING values (cc_seq.NEXTVAL, ccn_seq.NEXTVAL, ?) returning ccid into ?; END;";
			CallableStatement cs = con.prepareCall(query);
			cs.setInt(1, cid);
			cs.registerOutParameter(2, OracleTypes.NUMBER);
			cs.execute();
			return cs.getInt(2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean addAccount(String type, int ccid, String sid) {
		try {
			con = DBUtility.createConnection();
			String query = "INSERT INTO ACCOUNTS_BANKING values (acc_seq.NEXTVAL, ?, ?, ?, ?) ";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, sid);
			pstmt.setString(2, type);
			pstmt.setDouble(3, 0.0);
			pstmt.setInt(4, ccid);
			affected = pstmt.executeUpdate();
			if(affected > 0){
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isBlacklist(String sid) {
		try {
			con = DBUtility.createConnection();
			String query = "SELECT COUNT(*) as count FROM BLACK_LIST_BANKING WHERE sid = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			rs.next();
			if(rs.getInt("count") > 0){
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean hasAccount(String sid, String acctype) {
		try {
			con = DBUtility.createConnection();
			String query = "SELECT COUNT(*) as count FROM ACCOUNTS_BANKING WHERE sid = ? and acctype = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, sid);
			pstmt.setString(2, acctype);
			rs = pstmt.executeQuery();
			rs.next();
			if(rs.getInt("count") > 0){
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String checkUser(String mobileNo,String password){
		System.out.println(mobileNo + password);
		boolean result = false ; 
		String sid = null ; 
		try {
			
			con = DBUtility.createConnection();
			pstmt = con.prepareStatement("select sid from Users_Banking where phone = ? and password = ? ");
			pstmt.setString(1,mobileNo);
			pstmt.setString(2,password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result = true ;
				sid = rs.getString(1);
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtility.closeResultSet(rs);
			DBUtility.closePreparedStatement(pstmt);
			DBUtility.closeConnection();
		}
		
		if(result)
			return sid ;
		else
			return "0";
		
	}
	
	

public UserDetails getUserDetailsBySid(String sid){
		UserDetails userDet = null ; 
		try {
			
			con = DBUtility.createConnection();
			pstmt = con.prepareStatement("select users_banking.name , users_banking.phone , users_banking.address ,ACCOUNTS_BANKING.accno   from users_banking join ACCOUNTS_BANKING on  users_banking.sid = ACCOUNTS_BANKING.sid  where ACCOUNTS_BANKING.sid = ?"); 
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				userDet  = new UserDetails();	
				userDet.setName(rs.getString(1));
				userDet.setPhone(rs.getString(2));
				userDet.setAddress(rs.getString(3));
				userDet.setAccno(rs.getString(4));
				
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtility.closeResultSet(rs);
			DBUtility.closePreparedStatement(pstmt);
			DBUtility.closeConnection();
		}
		
		return userDet ; 
}

public boolean updateAddress(String sid,String address){
	boolean result = false ; 
	int res = 0 ; 
	String tempCid = null ; 
	try {
		
		con = DBUtility.createConnection();
		pstmt = con.prepareStatement("select CREDIT_CARD_BANKING.cid from accounts_banking join USERS_BANKING on  accounts_banking.sid = USERS_BANKING.sid join CASH_CARD_BANKING on accounts_banking.cashcid= CASH_CARD_BANKING.ccid join  CREDIT_CARD_BANKING on   CASH_CARD_BANKING.cid = CREDIT_CARD_BANKING.cid where USERS_BANKING.sid = ? " ); 
		pstmt.setString(1,sid);

		rs = pstmt.executeQuery();

		if(rs.next()){
			result = true ;
			tempCid = rs.getString(1);
		}
		
	if(result){
		con = DBUtility.createConnection();
		pstmt = con.prepareStatement("update credit_card_banking set caddress = ? where cid = ? "); 
		pstmt.setString(1,address);
		pstmt.setString(2,tempCid);
				
		res = pstmt.executeUpdate();
		
		if(res>0){
			pstmt = con.prepareStatement("update USERS_BANKING set address = ? where sid = ? "); 
			pstmt.setString(1,address);
			pstmt.setString(2,sid);
			res = pstmt.executeUpdate();
			if(res>0)
				result = true ;
			else
				result = false;
		}
		else
			result = false ;
		}			
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally{
		DBUtility.closeResultSet(rs);
		DBUtility.closePreparedStatement(pstmt);
		DBUtility.closeConnection();
	}
	
	return result ; 
	
}
	
	
}
