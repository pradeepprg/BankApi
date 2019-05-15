package com.tcs.ilp.exceptions;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable e) {
		ErrorMessage em1 = new ErrorMessage(404, e.getMessage());
		return Response.status(Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(em1).build();
	}

}
