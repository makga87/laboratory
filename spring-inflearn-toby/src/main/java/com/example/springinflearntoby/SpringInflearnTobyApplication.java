package com.example.springinflearntoby;

import com.example.springinflearntoby.controller.HelloController;
import com.example.springinflearntoby.controller.SimpleHelloService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
public class SpringInflearnTobyApplication {

    public static void main(String[] args) {

        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh(); // NOTE : 절대 생략 하면 안되
                ServletWebServerFactory servletWebServerFactory = new TomcatServletWebServerFactory();
                WebServer webServer = servletWebServerFactory.getWebServer((servletContext) -> {

                    servletContext
                            .addServlet("dispacherServlet", new DispatcherServlet(this))
                            .addMapping("/*");
                });
                webServer.start();
            }
        };
        applicationContext.registerBean(SimpleHelloService.class);
        applicationContext.registerBean(HelloController.class);
        applicationContext.refresh();


    }

}
