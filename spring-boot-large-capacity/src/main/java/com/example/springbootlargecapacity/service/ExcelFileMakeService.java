package com.example.springbootlargecapacity.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExcelFileMakeService {

    public void createExcelFile() throws ExecutionException, InterruptedException {
        int rowAccessWindowSize = 100;
        SXSSFWorkbook workbook = new SXSSFWorkbook(rowAccessWindowSize);
        Sheet sheet = workbook.createSheet("Example Sheet");

        int totalDataCount = 10000;
        int pageCount = totalDataCount / rowAccessWindowSize;

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for(int i = 0; i < pageCount; i++) {
            final int index = i;
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
                makeBody(sheet, index * pageCount, (index+1) * pageCount);
            });
            futures.add(completableFuture);
        }

        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allDone.get();

        // 데이터를 채웁니다.
        try (FileOutputStream out = new FileOutputStream("example.xlsx")) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 디스크에 쓰여진 임시 파일을 삭제하기 위해 메모리를 정리합니다.
            workbook.dispose();
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void makeBody(Sheet sheet, int startRow, int endRow) {
        // 데이터를 채웁니다.
        for (int rowNum = startRow; rowNum < endRow; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue((double) rowNum + cellNum);
            }
        }
    }
}
