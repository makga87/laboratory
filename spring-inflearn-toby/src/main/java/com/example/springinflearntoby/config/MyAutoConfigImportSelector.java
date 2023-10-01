package com.example.springinflearntoby.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.StreamSupport;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        Iterable<String> importCandidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);

        return StreamSupport
                .stream(importCandidates.spliterator(), false)
                .toArray(String[]::new);
    }
}
