package com.example.springinflearntoby;


import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
    public static void run(Class<?> applicationClass, String... args) {

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh(); // NOTE : 절대 생략 하면 안되
                ServletWebServerFactory servletWebServerFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
                WebServer webServer = servletWebServerFactory.getWebServer((servletContext) -> {

                    servletContext.addServlet("dispacherServlet", dispatcherServlet)
                            .addMapping("/*");

                });
                webServer.start();
            }
        };
        applicationContext.register(SpringInflearnTobyApplication.class);
        applicationContext.refresh();
    }
}
