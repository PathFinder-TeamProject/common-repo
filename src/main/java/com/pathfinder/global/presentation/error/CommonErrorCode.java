package com.pathfinder.global.presentation.error;

import org.springframework.http.HttpStatus;

import com.pathfinder.global.presentation.error.BaseErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 공통 예외 코드 모음 (모든 서비스 공용)
 */
@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements BaseErrorCode {

	INVALID_INPUT(HttpStatus.BAD_REQUEST, "COMMON-400-01", "요청 데이터가 유효하지 않습니다."),
	MISSING_PARAMETER(HttpStatus.BAD_REQUEST, "COMMON-400-02", "필수 파라미터가 누락되었습니다."),
	RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON-404-01", "요청한 리소스를 찾을 수 없습니다."),
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "COMMON-405-01", "요청 메서드가 허용되지 않습니다."),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON-500-01", "서버 내부 오류가 발생했습니다.");

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;
}