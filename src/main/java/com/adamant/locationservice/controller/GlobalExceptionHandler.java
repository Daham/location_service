package com.adamant.locationservice.controller;

import com.adamant.locationservice.entity.error_data.ErrorData;
import com.adamant.locationservice.entity.error_data.ErrorDetail;
import com.adamant.locationservice.exception.DataLoadingException;
import com.adamant.locationservice.exception.ResourceNotFoundException;
import com.adamant.locationservice.exception.UnprocessableEntityException;
import com.adamant.locationservice.exception.ValidationException;
import com.adamant.locationservice.exception.enums.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.adamant.locationservice.exception.enums.ErrorCode.*;

@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private String informationLink;

    /**
     * Handles ResourceNotFoundException
     * <p>This method delegates to {@link #handleExceptionInternal}
     *
     * @param ex      the com.adamant.locationservice.exception
     * @param request the current request
     * @return a {@code ResponseEntity} instance with HttpStatus of Not Found - 404
     */
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(ResourceNotFoundException ex, WebRequest request) {
        ex.getErrorData().setLink(informationLink);
        log.error(ex.getMessage(), ex);
        return handleExceptionInternal(ex, ex.getErrorData(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    /**
     * Handles Exception - to cover all the other com.adamant.locationservice.exception types
     * <p>This method delegates to {@link #handleExceptionInternal}
     *
     * @param ex      the com.adamant.locationservice.exception
     * @param request the current request
     * @return a {@code ResponseEntity} instance with HttpStatus of Internal Server Error - 500
     */
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleUnhandled(Exception ex, WebRequest request) {
        return handleExceptionWithoutResponseBody(ex, request, HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles ConstraintViolationException
     * <p>This com.adamant.locationservice.exception is thrown when a request parameter or path variable violates its constraints</p>
     * <p>This method delegates to {@link #handleExceptionInternal}
     *
     * @param ex      the com.adamant.locationservice.exception
     * @param request the current request
     * @return a {@code ResponseEntity} instance with HttpStatus of Bad Request - 400
     */
    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<Object> handleInvalidParams(ConstraintViolationException ex, WebRequest request) {

        List<ErrorDetail> details = ex.getConstraintViolations().stream().flatMap(violation ->
                ((List<ErrorDetail>) ((ConstraintViolationImpl) violation).getDynamicPayload(List.class)).stream())
                .collect(Collectors.toList());

        ErrorData errorData = ErrorData.builder()
                .code("invalid.input")
                .message("Invalid input(s) provided.")
                .details(details)
                .link(informationLink)
                .build();

        return handleExceptionInternal(ex, errorData, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /**
     * Handles ValidationException
     * <p>This com.adamant.locationservice.exception is thrown when the service level constraints are violated</p>
     * <p>This method delegates to {@link #handleExceptionInternal}
     *
     * @param ex      the com.adamant.locationservice.exception
     * @param request the current request
     * @return a {@code ResponseEntity} instance with HttpStatus of Bad Request - 400
     */
    @ExceptionHandler(value = {ValidationException.class})
    protected ResponseEntity<Object> handleValidation(ValidationException ex, WebRequest request) {
        ex.getErrorData().setLink(informationLink);
        log.error(ex.getMessage(), ex);
        return handleExceptionInternal(ex, ex.getErrorData(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /**
     * Handles ValidationException
     * <p>This com.adamant.locationservice.exception is thrown when the service level constraints are violated</p>
     * <p>This method delegates to {@link #handleExceptionInternal}
     *
     * @param ex      the com.adamant.locationservice.exception
     * @param request the current request
     * @return a {@code ResponseEntity} instance with HttpStatus of Bad Request - 400
     */
    @ExceptionHandler(value = {DataLoadingException.class})
    protected ResponseEntity<Object> handleDataLoadingFailure(DataLoadingException ex, WebRequest request) {
        ex.getErrorData().setLink(informationLink);
        log.error(ex.getMessage(), ex);
        return handleExceptionInternal(ex, ex.getErrorData(), new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE, request);
    }

    /**
     * Handles UnprocessableEntityException
     * <p>This com.adamant.locationservice.exception is thrown when the service level constraints are violated</p>
     * <p>This method delegates to {@link #handleExceptionInternal}
     *
     * @param ex      the com.adamant.locationservice.exception
     * @param request the current request
     * @return a {@code ResponseEntity} instance with HttpStatus of Unprocessable Entity - 422
     */
    @ExceptionHandler(value = {UnprocessableEntityException.class})
    protected ResponseEntity<Object> handleUnprocessableEntity(UnprocessableEntityException ex, WebRequest request) {
        ex.getErrorData().setLink(informationLink);
        log.error(ex.getMessage(), ex);
        return handleExceptionInternal(ex, ex.getErrorData(), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

    /**
     * Override the super class method for TypeMismatchException.
     * <p>This com.adamant.locationservice.exception is thrown when the controller level request parameter types are violated</p>
     * <p>This method delegates to {@link #handleExceptionInternal}.
     *
     * @param ex      the com.adamant.locationservice.exception
     * @param headers the headers to be written to the response
     * @param status  the selected response status
     * @param request the current request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return handleExceptionWithoutResponseBody(ex, request, HttpStatus.BAD_REQUEST, VALIDATION_ERROR);
    }

    /**
     * Override the super class method for ServletRequestBindingException.
     * <p>This com.adamant.locationservice.exception is thrown when the controller level request parameter are violated</p>
     * <p>This method delegates to {@link #handleExceptionInternal}.
     *
     * @param ex      the com.adamant.locationservice.exception
     * @param headers the headers to be written to the response
     * @param status  the selected response status
     * @param request the current request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status,
                                                                          WebRequest request) {
        log.error(ex.getMessage(), ex);
        return handleExceptionWithoutResponseBody(ex, request, HttpStatus.BAD_REQUEST, VALIDATION_ERROR);
    }

    /**
     * Override the super class method for MethodArgumentNotValidException.
     * <p>This com.adamant.locationservice.exception is thrown when the controller level validations are violated</p>
     * <p>This method delegates to {@link #handleExceptionInternal}.
     *
     * @param ex      the com.adamant.locationservice.exception
     * @param headers the headers to be written to the response
     * @param status  the selected response status
     * @param request the current request
     * @return a {@code ResponseEntity} instance with HttpStatus of Bad Request - 400
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);

        });

        return handleExceptionInternal(ex, new Object(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /**
     * Override the super class method for HttpMessageNotReadableException
     * <p>This com.adamant.locationservice.exception is thrown when an incorrect data type is provided</p>
     * <p>This method delegates to {@link #handleExceptionInternal}.
     *
     * @param ex      the com.adamant.locationservice.exception
     * @param headers the headers to be written to the response
     * @param status  the selected response status
     * @param request the current request
     * @return a {@code ResponseEntity} instance with HttpStatus of Bad Request - 400
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return handleExceptionWithoutResponseBody(ex, request, HttpStatus.BAD_REQUEST, BAD_REQUEST);
    }

    /**
     * Override the super class method for NoHandlerFoundException
     * <p>This com.adamant.locationservice.exception is thrown when attempting to access incorrect path</p>
     * <p>This method delegates to {@link #handleExceptionInternal}
     *
     * @param ex      the com.adamant.locationservice.exception
     * @param headers the headers to be written to the response
     * @param status  the selected response status
     * @param request the current request
     * @return a {@code ResponseEntity} instance with HttpStatus of Not Found - 404
     */
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status,
                                                                   WebRequest request) {
        log.error(ex.getMessage(), ex);
        return handleExceptionWithoutResponseBody(ex, request, HttpStatus.NOT_FOUND, RESOURCE_NOT_FOUND);
    }


    private ResponseEntity<Object> handleExceptionWithoutResponseBody(Exception ex, WebRequest request, HttpStatus httpStatus, ErrorCode errorCode) {

        log.error(ex.getMessage(), ex);
        return handleExceptionInternal(ex, new Object(), new HttpHeaders(), httpStatus, request);
    }

}
