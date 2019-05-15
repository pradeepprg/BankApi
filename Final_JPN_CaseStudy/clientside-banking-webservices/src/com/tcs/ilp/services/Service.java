package com.tcs.ilp.services;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.google.gson.Gson;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.tcs.ilp.bean.Address;
import com.tcs.ilp.bean.AllSales;
import com.tcs.ilp.bean.Login;
import com.tcs.ilp.bean.UserDetails;
import com.tcs.ilp.bean.Users;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Service {

public static MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	public UserDetails getDetails(String sid, String un, String pass){ 
		String cred = un+":"+pass;
		cred = Base64.encode(cred.getBytes());
		System.out.println(cred);
		OkHttpClient client = new OkHttpClient();
		  Request request = new Request.Builder()
		      .url("http://localhost:8080/serverside-banking-webservices/api/v1/account/secured/details/"+sid)
		      .addHeader("Content-type", "multipart/form-data")
		      .addHeader("Authorization", "Basic "+cred)
		      .build();

		  Response response;
		try {
			response = client.newCall(request).execute();
			  if(response.code() == 200){
				  Gson gson = new Gson();
				  UserDetails user = gson.fromJson(response.body().string(),UserDetails.class);
				  return user;
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String login(String username, String password) {
		OkHttpClient client = new OkHttpClient();
		Login user = new Login(username, password); 

		Gson gson = new Gson();
		String cred = gson.toJson(user);
		RequestBody rb = RequestBody.create(JSON, cred);
		
		  Request request = new Request.Builder()
		      .url("http://localhost:8080/serverside-banking-webservices/api/v1/account/login")
		      .post(rb)
		      .addHeader("Authorization", "Basic "+cred)
		      .build();

		  Response response;
		try {
			response = client.newCall(request).execute();
			System.out.println(response);
			  if(response.code() == 200){
				  return response.body().string();
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0";
	}



	public boolean updateUser(String un, String pass, String sid, String address) {
		String cred = un+":"+pass;
		cred = Base64.encode(cred.getBytes());
		
		OkHttpClient client = new OkHttpClient();
		Address ad = new Address(sid, address); 

		Gson gson = new Gson();
		String add = gson.toJson(ad);
		RequestBody rb = RequestBody.create(JSON, add);
		
		  Request request = new Request.Builder()
		      .url("http://localhost:8080/serverside-banking-webservices/api/v1/account/secured/update")
		      .post(rb)
		      .addHeader("Authorization", "Basic "+cred)
		      .build();

		  Response response;
		try {
			response = client.newCall(request).execute();
			System.out.println(response);
			  if(response.code() == 200){
				  return true;
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	

}
