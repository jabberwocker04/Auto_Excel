package org.example;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.xml.security.algorithms.implementations.IntegrityHmac;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        new Frame();
        Scanner sc = new Scanner(System.in);

        // Description  <장비명[장비명/ENB명]> 배열에 장비명 입력
        System.out.println("사용할 장비명을 엔터를 눌러 구분하여 입력하세요. 종료시엔"+"Stop!"+"을 입력해주세요");
        //Description
        ArrayList<String> arr = new ArrayList<>(); // 명령어 넣어준 배열
        String temp_Equip = null;
        int equip_Count = 0;

        while (true) {

            temp_Equip = sc.nextLine();

            if(temp_Equip.equals("Stop!")) {
                System.out.println("Stop! 입력됌");
                break;
            }

            arr.add(temp_Equip);
            equip_Count++;
        }

        // Description  <Command[명령어]> 배열에 명령어 입력
        System.out.println("사용할 명령어를 엔터를 눌러 구분하여 입력하세요:");
        //Description
        ArrayList<String> arr2 = new ArrayList<>(); // 명령어 넣어준 배열
        String a = null;
        int command_Count = 0;

        while (true) {

            a = sc.nextLine();

            if(a.equals("Stop!")) {
                System.out.println("Stop! 입력됌");
                break;
            }

            arr2.add(a);
            command_Count++;
        }

        //Description Count 계산
        int Count = equip_Count * command_Count;
        System.out.println(Count);



        System.out.println("고유식별번호 장비명/ENB명 명령어실행순서 명령어MATCH방식코드 명령어내용");
        String[] zero_matrix = { "고유식별번호", "장비명/ENB명", "명령어실행순서", "명령어MATCH방식코드", "명령어내용" };


        for(int i=0; i<equip_Count; i++) {
            for (int j=0; j<command_Count; j++) {
                String[] rowValues = {String.valueOf(i+1), String.valueOf(arr.get(i)),String.valueOf(j+1),"H",String.valueOf(arr2.get(j))};
                System.out.println(Arrays.toString(rowValues));
                }
           }


    /*    // Excel 파일 생성
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("MatrixSheet");

        // 데이터 쓰기
        for (int i = 0; i < arr.length; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < arr2.length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(matrix[i][j].toString());
            }
        }

        // 파일로 저장
        try (FileOutputStream fileOut = new FileOutputStream("matrix.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel 파일이 성공적으로 생성되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }*/

        System.out.println(Count+"행 생성됌");
        System.exit(0);
    }
}