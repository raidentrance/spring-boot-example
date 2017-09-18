/**
 * 
 */
package com.raidentrance.error;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.http.HttpStatus;

import com.raidentrance.model.ErrorMessage;

/**
 * @author raidentrance
 *
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage(ex.getMessage());
		StringWriter errorStackTrace = new StringWriter();
		ex.printStackTrace(new PrintWriter(errorStackTrace));
		errorMessage.setDeveloperMessage(ex.toString());
		return Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).entity(errorMessage)
				.type(MediaType.APPLICATION_JSON).build();
	}

}