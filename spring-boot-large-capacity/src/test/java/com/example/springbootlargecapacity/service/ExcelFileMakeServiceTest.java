package com.example.springbootlargecapacity.service;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class ExcelFileMakeServiceTest {

    @Test
    void test() throws ExecutionException, InterruptedException {
        ExcelFileMakeService excelFileMakeService = new ExcelFileMakeService();
        excelFileMakeService.createExcelFile();
    }

}