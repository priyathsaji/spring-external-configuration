package com.cloudnativejava.cloudconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClientApplication.class, args);
	}

}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${configuration.projectName:Hello default}")
	private String message;

	@RequestMapping("/projectName")
	String getProjectName() {
		return this.message;
	}
}
