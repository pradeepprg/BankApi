package com.tcs.ilp.exceptions;

import java.net.URI;

import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.tcs.ilp.exceptions.AlreadyExistsOrBlacklistedException;
import com.tcs.ilp.exceptions.ErrorMessage;


@Provider
public class AlreadyExistsOrBlacklistedExceptionMapper implements ExceptionMapper<AlreadyExistsOrBlacklistedException>{

	@Override
	public Response toResponse(AlreadyExistsOrBlacklistedException arg0) {
		ErrorMessage em = new ErrorMessage(215, "Account already exists or blacklisted.");
		 //URI targetURIForRedirection = URI.create("https://google.com");
//		    return Response.seeOther(targetURIForRedirection).build();
		return Response.status(Status.BAD_REQUEST).entity(em).build();
	}

}
