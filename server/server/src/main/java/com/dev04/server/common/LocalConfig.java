package com.dev04.server.common;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

public class LocalConfig {

	@Value("${serverInfo.upload_path}")
	@Getter@Setter
	private String uploadFilepath;
	
	
	@Value("${serverInfo.base_url}")
	@Getter@Setter
	private String baseUrl;
	
	
}
