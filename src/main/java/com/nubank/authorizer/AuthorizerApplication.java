package com.nubank.authorizer;

import com.nubank.authorizer.service.AuthorizerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.File;

@SpringBootApplication
public class AuthorizerApplication {

    public static void main(String[] args) {

        if (args.length == 1) {
			File file = new File(args[0]);

			if (!file.isFile()){
				System.out.println("Path is not a file");
			}else{
				ApplicationContext context = SpringApplication.run(AuthorizerApplication.class, args);

				AuthorizerService authorizerService = context.getBean(AuthorizerService.class);

				authorizerService.authorize(file);
			}

        } else if (args.length == 0){
			System.out.println("Debe envíar un argumento");
		} else {
			System.out.println("Debe envíar solo un argumento");
		}


    }

}
