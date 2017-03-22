package org.wahid.rests.massenger.resource;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/inject")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("annotations")
	public String demoAnotation(@MatrixParam("param")String matrixParam
								,@HeaderParam("header") String headerParam
								,@CookieParam("cookie") String cookie){
		return "matrixParam : " + matrixParam +"  "+"headerParam "+headerParam
				+ " cookie"+cookie;
		
	}
	@GET
	@Path("context")
	public String demoContext(@Context UriInfo uriInfo,@Context HttpHeaders header){
		String path = uriInfo.getAbsolutePath().toString();
		String cookie = header.getCookies().toString();
		String authkey =header.getHeaderString("authkey");
		return "Path : "+path
				+"cookie"+cookie
				+"authkey"+authkey;
	}

}
