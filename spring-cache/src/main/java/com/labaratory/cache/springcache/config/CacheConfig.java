package com.labaratory.cache.springcache.config;

import org.ehcache.jsr107.EhcacheCachingProvider;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean(name = "ehCacheManager")
    public CacheManager cacheManager() throws IOException {

        CachingProvider provider = Caching.getCachingProvider(EhcacheCachingProvider.class.getName());

        javax.cache.CacheManager cacheManager = provider.getCacheManager(
                new ClassPathResource("/ehcache.xml").getURI(),
                getClass().getClassLoader());

        return new JCacheCacheManager(cacheManager);

    }

}
