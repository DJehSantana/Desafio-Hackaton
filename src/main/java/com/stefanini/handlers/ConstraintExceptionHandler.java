package com.stefanini.handlers;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import java.util.stream.Collectors;

@Provider
public class ConstraintExceptionHandler implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        String message = exception.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("; "));
        return Response.status(Response.Status.BAD_REQUEST)
                .entity("Houve um erro relacionado ao banco, olhe na console para mais detalhes.\n"
                        .concat(exception.getMessage() + message))
                .build();
    }
}