package com.tcs.ilp.filters;

import java.io.IOException;
import java.net.URI;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.tcs.ilp.banking.server_banking_webservices.MyResource;

@Provider
	public class AccessControlResponseFilter implements ContainerResponseFilter {

	    @Override
	    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
	        final MultivaluedMap<String,Object> headers = responseContext.getHeaders();
	        System.out.println("ACCESS");
	        headers.add("Access-Control-Allow-Origin", "*");
	        headers.add("Access-Control-Allow-Headers", "Authorization, Origin, X-Requested-With, Content-Type");
	        headers.add("Access-Control-Expose-Headers", "Location, Content-Disposition");
	        headers.add("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, HEAD, OPTIONS");
	        headers.add("Access-Control-Allow-Credentials", "true");
	    }
	    
	}
