package org.featx.templet.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Excepts
 * @since 2019/11/23 15:26
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringCloudApplication
public class SpringCloudAlibabaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAlibabaApplication.class);
	}

}
