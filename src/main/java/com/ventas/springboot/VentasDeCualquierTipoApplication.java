package com.ventas.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//http://localhost:9082/api/v2/ventas_de_cualquier_tipo/swagger-ui/index.html
@SpringBootApplication
public class VentasDeCualquierTipoApplication {

	public static void main(String[] args) {
		String[] beanDefinitionNames =
		       SpringApplication.run(VentasDeCualquierTipoApplication.class, args).getBeanDefinitionNames();
		/*for (String str : beanDefinitionNames){
			System.out.println(str);
		}*/
	}



}
