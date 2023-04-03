package com.example.springinflearntoby;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
public class SpringInflearnTobyApplication {

    public static void main(String[] args) {

        ServletWebServerFactory servletWebServerFactory = new TomcatServletWebServerFactory();
        WebServer webServer = servletWebServerFactory.getWebServer((servletContext) -> {
            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    resp.setStatus(200);
                    resp.setHeader("Content-Type", "text/plain");
                    resp.getWriter().println("Hello Servlet");
                }
            }).addMapping("/hello");
        });
        webServer.start();
    }

}
