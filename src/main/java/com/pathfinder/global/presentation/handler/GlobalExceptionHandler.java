package com.pathfinder.global.presentation.handler;

import org.hibernate.query.PathException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.pathfinder.global.presentation.error.BaseErrorCode;
import com.pathfinder.global.presentation.error.CommonErrorCode;
import com.pathfinder.global.presentation.response.ApiResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PathException.class)
	public ResponseEntity<ApiResponse<Void>> handlePathException(
		com.pathfinder.global.presentation.exception.PathException ex){
		BaseErrorCode errorCode = ex.getErrorCode();
		log.warn("PathException: code : {} , message : {}", errorCode.getCode(), errorCode.getMessage(), ex);
		return buildErrorResponse(errorCode);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Void>> handlerGeneralException(Exception ex){
		log.error("Unexpected exception"  , ex);
		CommonErrorCode errorCode = CommonErrorCode.INTERNAL_SERVER_ERROR;
		return buildErrorResponse(errorCode);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<Void>> handlerValidationException(MethodArgumentNotValidException ex){
		CommonErrorCode errorCode = CommonErrorCode.INVALID_INPUT;

		String validationMessage = ex.getBindingResult()
			.getFieldErrors()
			.stream()
			.findFirst()
			.map(FieldError::getDefaultMessage)
			.filter(StringUtils::hasText)
			.orElse(errorCode.getMessage());

		return ResponseEntity.badRequest().body(ApiResponse.fail(errorCode.getCode(), validationMessage));
	}

	private ResponseEntity<ApiResponse<Void>> buildErrorResponse(BaseErrorCode errorCode){
		return ResponseEntity.status(errorCode.getHttpStatus())
			.body(ApiResponse.fail(errorCode.getCode(), errorCode.getMessage()));
	}

	private ResponseEntity<ApiResponse<Void>> buildErrorResponse(BaseErrorCode errorCode, String customMessage){
		return ResponseEntity.status(errorCode.getHttpStatus())
			.body(ApiResponse.fail(errorCode.getCode(), customMessage));
	}
}
