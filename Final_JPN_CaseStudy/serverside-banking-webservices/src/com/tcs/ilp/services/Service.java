package com.tcs.ilp.services;

import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.ws.WebServiceException;

import com.tcs.ilp.beans.AccountInfo;
import com.tcs.ilp.beans.UserDetails;
import com.tcs.ilp.beans.Users;
import com.tcs.ilp.dao.AccountDao;
import com.tcs.ilp.exceptions.AlreadyExistsOrBlacklistedException;

public class Service {

	AccountDao ad = new AccountDao();
	UploadService us = new UploadService();
	
	public boolean createAccount(AccountInfo account, String action) throws WebServiceException, AlreadyExistsOrBlacklistedException{
		if(ad.isBlacklist(account.getSid()) || ad.hasAccount(account.getSid(), account.getType())){
			if(!action.equals("client")) {
			 throw new AlreadyExistsOrBlacklistedException("");
			}
		}
		Users user = new Users();	
		user = this.uploadFile(account);
		System.out.println(user);
		if(user.getSid_id() != 0 && user.getDoc2() != 0 && user.getDoc1() != 0 ){
			user.setSid(account.getSid());
			user.setName(account.getName());
			user.setPhone(account.getPhone());
			user.setGender(account.getGender());
			user.setDob(account.getDob());
			user.setEmail(account.getEmail());
			user.setAddress(account.getAddress());
			user.setPassword(account.getPassword());
			System.out.println(user);
			
			boolean user_added = ad.addUser(user);
			if(user_added){
				int cid = ad.createCreditCard(account.getAddress());
				if(cid != 0){
					int ccid = ad.createCashCard(cid);
					if(ccid != 0){
						boolean result = ad.addAccount(account.getType(), ccid, account.getSid());
						if(result){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public Users uploadFile(AccountInfo account) throws WebServiceException{
		Users user = new Users();
		boolean res = us.writeToFile(account.getUploadedInputStream_sid(), account.getSid()+"_sid_"+account.getFileDetail_sid().getFileName());
		if(res){
			int sid = ad.insertFile(account.getSid()+"_sid_"+account.getFileDetail_sid().getFileName());
			System.out.println(sid);
			user.setSid_id(sid);
			boolean res1 = us.writeToFile(account.getUploadedInputStream_doc1(), account.getSid()+"_doc1_"+account.getFileDetail_doc1().getFileName());
			if(res1){
				int doc1 = ad.insertFile(account.getSid()+"_doc1_"+account.getFileDetail_doc1().getFileName());
				user.setDoc1(doc1);
				boolean res2 = us.writeToFile(account.getUploadedInputStream_doc2(), account.getSid()+"_doc2_"+account.getFileDetail_doc2().getFileName());
				if(res2){
					int doc2 = ad.insertFile(account.getSid()+"_doc2_"+account.getFileDetail_doc2().getFileName());
					user.setDoc2(doc2);
				}
			}
		}else{
			throw new WebServiceException();
		}
		return user;
	}
	
	public String checkUser(String un, String pass){
		String res =ad.checkUser(un, pass);
		return res;
	}

	public UserDetails getUserDetailsBySid(String sid) {
		// TODO Auto-generated method stub
		return ad.getUserDetailsBySid(sid);
	}

	public boolean updateUser(String sid, String address) {
		
		return ad.updateAddress(sid, address);
	}
}