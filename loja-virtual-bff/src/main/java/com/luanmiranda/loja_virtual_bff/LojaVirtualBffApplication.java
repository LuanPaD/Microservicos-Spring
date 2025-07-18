package com.luanmiranda.loja_virtual_bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LojaVirtualBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaVirtualBffApplication.class, args);
	}

}
