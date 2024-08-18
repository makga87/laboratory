package com.labaratory.cache.springcache.service;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GeneralTest {

    @Test
    public void test1() {
//        String S = "1111010101111";
        String S = "001";

     int firstOne =  S.indexOf("1");
        System.out.println(firstOne);

        String convStr =   S.substring(firstOne);
        System.out.println(convStr);

        long t = convStr.length() - 1;
        long strCnt = S.chars().filter(ch -> ch == '1').count();

       long cnt = t+ strCnt;

        System.out.println(cnt);

    }

    @Test
    public void test2(){

        assertThatThrownBy(() -> new Version(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("test");

        assertT

    }

    class Version {
        private final String version;
        public Version(String version){
            if(version == null) {
                throw new IllegalArgumentException("test");
            }
            this.version = version;
        }
    }
}
