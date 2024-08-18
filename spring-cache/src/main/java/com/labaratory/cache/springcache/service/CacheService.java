package com.labaratory.cache.springcache.service;

import com.labaratory.cache.springcache.model.CodeDto;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@CacheConfig(cacheNames = "test")
public class CacheService {


    @Cacheable(value = "codeCacheInfo", key = "#codeDto.grpCd")
    public List<CodeDto> getCodes(CodeDto codeDto){


        List<CodeDto> codeDtos = Arrays.asList(new CodeDto(codeDto.getGrpCd()),
                new CodeDto(codeDto.getGrpCd()+1),
                new CodeDto(codeDto.getGrpCd()+2));
        return codeDtos;
    }

    @CachePut(value = "codeCacheInfo", key="#grpCd")
    public List<CodeDto> putCodes(int grpCd) {
        List<CodeDto> codeDtos = Arrays.asList(new CodeDto(grpCd),
                new CodeDto(grpCd+1),
                new CodeDto(grpCd+2));
        return codeDtos;
    }
}
