package com.exb.server.client.server.communication.fileservicecommunication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages={
		"com.exb.client.fileserviceclient.service",
		"com.exb.server.client.server.communication.fileservicecommunication"},
		exclude = {SecurityAutoConfiguration.class })
@EnableFeignClients(basePackages = "com.exb.server.client.server.communication.fileservicecommunication.feign")
public class FileServiceCommunicationApplication {


	public static void main(String[] args) {
		SpringApplication.run(FileServiceCommunicationApplication.class, args);
	}
}
