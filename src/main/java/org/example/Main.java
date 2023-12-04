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
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        new Frame();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        //Description arr[장비명]배열에 장비명 입력
        System.out.println("입력할 장비를 공백으로 구분하여 입력하세요:");
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[st.countTokens()];
        for(int i = 0; i<arr.length; i++){
            arr[i] = st.nextToken();
        }

        //Description arr2[명령어]배열에 명령어 입력
        System.out.println("사용할 명령어를 공백으로 구분하여 입력하세요:");
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        String[] arr2 = new String[st2.countTokens()];
        for(int i = 0; i<arr2.length; i++){
            arr2[i] = st2.nextToken();
        }

        int Count = arr.length * arr2.length;
        System.out.println(Count);
        // 행렬 데이터 입력받기
        Object[][] matrix = new String[arr.length+1][5];

        System.out.println("고유식별번호 장비명/ENB명 명령어실행순서 명령어MATCH방식코드 명령어내용");
        String[] zero_matrix = {"고유식별번호", "장비명/ENB명", "명령어실행순서", "명령어MATCH방식코드", "명령어내용"};
        matrix[0] = zero_matrix;

        int k=1;

        for(int i=0; i<arr.length; i++){
/*            arr[i] = st.nextToken();*/
            for (int j=0; j<arr2.length; j++){
                String[] rowValues = {String.valueOf(i), arr[i], String.valueOf(j),"H", String.valueOf(arr2[j])};
                System.out.println(Arrays.toString(rowValues));
                matrix[k][0] = rowValues[j];
                k++;
            }

        }

        for (int i = 1; i < matrix.length; i++) {
            Object[] inArr = matrix[i];
            for (int j = 0; j < inArr.length; j++) {
                System.out.print(inArr[j] + " ");
            }
            System.out.println();
        }


        // Excel 파일 생성
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

        }
    }
}