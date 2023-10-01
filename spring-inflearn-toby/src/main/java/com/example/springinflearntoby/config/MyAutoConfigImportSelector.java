package com.example.springinflearntoby.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "com.example.springinflearntoby.config.autoconfig.DispatcherServletConfig",
                "com.example.springinflearntoby.config.autoconfig.TomcatWebserverConfig",
        };
    }
}
