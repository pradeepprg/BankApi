package com.tcs.ilp.banking.server_banking_webservices;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.xml.ws.WebServiceException;

import com.tcs.ilp.beans.AccountInfo;
import com.tcs.ilp.beans.Address;
import com.tcs.ilp.beans.Login;
import com.tcs.ilp.beans.UserDetails;
import com.tcs.ilp.exceptions.AlreadyExistsOrBlacklistedException;
import com.tcs.ilp.exceptions.ErrorMessage;
import com.tcs.ilp.services.Service;
import com.tcs.ilp.services.UploadService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/account")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @POST
    @Path("/{a:create|create/csystem}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response createAccount(@BeanParam AccountInfo account, @Context UriInfo uriInfo) {
    	String action = "api";
    	if(uriInfo.getPath().contains("csystem")) {
    		System.out.println(uriInfo.getBaseUri());
    		action = "client";
    	}
		// save it
    	Service s = new Service();
    	try{
	    	boolean res = s.createAccount(account, action);
	    	System.out.println(action);
	    	if(res && !action.equals("client")){
	    		return Response.status(200).entity("suucessfull").build();
	    	}else if(res) {
				return Response.seeOther(URI.create("http://localhost:8080/clientside-banking-webservices/successful.jsp")).build();
	    	}
    	}catch(WebServiceException e){
    		ErrorMessage er = new ErrorMessage(422,"Unsupported Media Type");
    		return Response.status(Status.UNSUPPORTED_MEDIA_TYPE).entity(er).build();
    	}
		if(!action.equals("client")) {
		return Response.status(404).entity("failed").build();
		}else {
			return Response.seeOther(URI.create("http://localhost:8080/clientside-banking-webservices/failure.jsp")).build();
		}
			
		
    }
    
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login( Login user) {
    	Service s = new Service();
    	System.out.println(user.getUsername()+" "+ user.getPassword());
    	String res = s.checkUser(user.getUsername(), user.getPassword());
    	if("0".equals(res)){
    		ErrorMessage em = new ErrorMessage(400, "Bad Request.");
    		return Response.status(Status.BAD_REQUEST).entity(em).build();
    	}else{
    		return Response.status(Status.OK).entity(res).build();
    	}
    	
    }
    
    @GET
    @Path("/secured/details/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDetails(@PathParam("id") String sid) {
    	Service s = new Service();
    	UserDetails ud = s.getUserDetailsBySid(sid);
    	if(ud != null){
    		return Response.status(Status.OK).entity(ud).build();
    	}else{
    		ErrorMessage em = new ErrorMessage(400, "Bad Request.");
    		return Response.status(Status.BAD_REQUEST).entity(em).build();
    	}
    }
    
    @POST
    @Path("/secured/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update( Address address) {
    	Service s = new Service();
    	boolean res = s.updateUser(address.getSid(),address.getAddress());
    	if(!res){
    		ErrorMessage em = new ErrorMessage(400, "Bad Request.");
    		return Response.status(Status.BAD_REQUEST).entity(em).build();
    	}else{
    		return Response.status(Status.OK).entity(res).build();
    	}
    	
    }
    
}