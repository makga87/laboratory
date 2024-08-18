package com.labaratory.cache.springcache.service;

import com.labaratory.cache.springcache.model.CodeDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class CacheServiceTest {

    @Autowired
    CacheService cacheService;

    @Test
    public void cacheableTest() {

        List<CodeDto> codeDtos1 = cacheService.getCodes(new CodeDto(1));
        log.info("###### {}", codeDtos1);

        List<CodeDto> codeDtos2 = cacheService.getCodes(new CodeDto(1));
        log.info("###### {}", codeDtos2);

        List<CodeDto> codeDtos3 = cacheService.getCodes(new CodeDto(2));
        log.info("###### {}", codeDtos3);

    }


    @Test
    public void cacheputTest() {

        List<CodeDto> codeDtos1 = cacheService.putCodes(1);
        log.info("###### {}", codeDtos1);

        List<CodeDto> codeDtos2 = cacheService.putCodes(1);
        log.info("###### {}", codeDtos2);
    }
}
