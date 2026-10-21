package com.priyamart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication
public class PriyaMartApplication extends SpringBootServletInitializer {
 public static void main(String[] args){SpringApplication.run(PriyaMartApplication.class,args);}
 protected SpringApplicationBuilder configure(SpringApplicationBuilder b){return b.sources(PriyaMartApplication.class);}
}