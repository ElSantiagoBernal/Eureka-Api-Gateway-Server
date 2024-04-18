package com.eam.parcial

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class CommentsApplication

fun main(args: Array<String>) {
	runApplication<CommentsApplication>(*args)
}
