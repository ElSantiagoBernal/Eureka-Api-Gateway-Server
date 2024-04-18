package com.eam.parcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HostsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostsApplication.class, args);
	}

}
