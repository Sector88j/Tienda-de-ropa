package com.ventas.springboot;

import com.ventas.springboot.modelo.entidades.entity.Estante;
import com.ventas.springboot.service.contratos.RopaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
