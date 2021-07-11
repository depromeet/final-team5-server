package com.depromeet.team5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/version")
	public BaseResponse<String> checkVersion(@RequestHeader("User-Agent") String userAgent) {
		return BaseResponse.OK;
	}

}
