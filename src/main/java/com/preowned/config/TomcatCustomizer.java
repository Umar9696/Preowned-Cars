package com.preowned.config;

import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addContextCustomizers(context -> {
            // Increase fileCountMax
            context.addParameter("org.apache.tomcat.upload.fileCountMax", "50");
            // Optional: other params
            context.addParameter("org.apache.tomcat.upload.maxFileSize", "20971520");  // 20MB
            context.addParameter("org.apache.tomcat.upload.maxRequestSize", "26214400"); // 25MB
        });
    }
}
