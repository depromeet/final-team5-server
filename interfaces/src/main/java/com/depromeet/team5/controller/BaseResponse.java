package com.depromeet.team5.controller;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseResponse<T> {

	public static final BaseResponse<String> OK = of("OK");

	private final String resultCode;

	private final String message;

	private final T data;

	public static <T> BaseResponse<T> of(T data) {
		return new BaseResponse<>("", "", data);
	}

}
