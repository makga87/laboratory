package com.labaratory.cache.springcache.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Builder
@AllArgsConstructor
public class CodeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    private String grpCd;
}
