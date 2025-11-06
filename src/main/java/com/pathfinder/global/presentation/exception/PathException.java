package com.pathfinder.global.presentation.exception;

import com.pathfinder.global.presentation.error.BaseErrorCode;

import lombok.Getter;

@Getter
public class PathException extends RuntimeException {

	private final BaseErrorCode errorCode;

	public PathException(BaseErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public PathException(BaseErrorCode errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}
}
