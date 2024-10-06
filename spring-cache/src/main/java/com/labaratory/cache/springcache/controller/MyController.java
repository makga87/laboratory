package com.labaratory.cache.springcache.controller;

import com.labaratory.cache.springcache.model.CodeDto;
import com.labaratory.cache.springcache.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MyController {

    private final CacheService cacheService;

    @GetMapping("/data/{grpCd}")
    public ResponseEntity<List<CodeDto>> getData(@PathVariable String grpCd) {
        return ResponseEntity.ok(cacheService.getCodes(CodeDto.builder()
                .grpCd(grpCd)
                .build()));
    }
}
