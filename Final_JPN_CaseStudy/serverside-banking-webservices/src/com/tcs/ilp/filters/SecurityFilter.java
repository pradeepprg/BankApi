package com.tcs.ilp.filters;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.tcs.ilp.dao.AccountDao;


@Provider
public class SecurityFilter implements ContainerRequestFilter{

	private static final String AUTHORIZATION_HEADER ="Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX ="Basic ";
	private static final String AUTHORIZATION_URL_PREFIX ="secured";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("hello");
		requestContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		requestContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, Authorization");
		requestContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
		requestContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		requestContext.getHeaders().add("Access-Control-Max-Age", "1209600");
		
		System.out.println(requestContext.getHeaderString(AUTHORIZATION_HEADER));
		
		
		if ("OPTIONS".equalsIgnoreCase(requestContext.getMethod())) {
			 return;
		}
		System.out.println(requestContext.getUriInfo().getPath());
		if(requestContext.getUriInfo().getPath().contains(AUTHORIZATION_URL_PREFIX)){
		List<String> authHeaders = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
			if(authHeaders != null ){
			if(authHeaders.size() > 0){
				String authToken = authHeaders.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX,"");
				byte[] decodedauthToken = Base64.decode(authToken);
				String decoded = new String(decodedauthToken);
				StringTokenizer tokenizer = new StringTokenizer(decoded,":");
				AccountDao ad = new AccountDao();
				if(!"0".equals(ad.checkUser(tokenizer.nextToken(), tokenizer.nextToken()))){
					return;
				}
			 }
			}
			Response unauthorized = Response.status(401)
									.entity("Unauthorized access.")	
									.build();
			requestContext.abortWith(unauthorized);
		}else{
			return;
		}
	}

}
