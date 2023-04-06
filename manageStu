package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {


        int menu = 0;
        String name = "";
        int age = 0;
        String email = "";
        String phone = "";
        System.out.println("시작");

        workDB doing = new workDB();
       /* workDB create = new workDB(); //생성
        wrkDB delete = new workDB(); //삭제*/




        Scanner sc = new Scanner(System.in);


        System.out.println("----------학생관리 프로그램----------");
        System.out.println("1.전체명단 2.학생추가 3.학생삭제 4.학생수정 5.종료");

        menu = sc.nextInt();
        System.out.println(menu + " 선택");

        while (true) {
            switch (menu) {
                case 1:
                    System.out.println("★전체명단 조회★");
                    doing.listup();
                    break;

                case 2:
                    System.out.println("명단에 추가할 정보를 입력하시오.");
                    System.out.print("이름 : ");

                    name = sc.next();

                    System.out.print("나이 : ");

                    age = sc.nextInt();

                    System.out.print("전화번호 : ");

                    phone = sc.next();

                    System.out.print("이메일 : ");

                    email = sc.next();

                    doing.workInfo("add",name,age,phone,email);
                    break;

                case 3:
                    System.out.println("삭제할 인원의 정보를 입력하시오");
                    name = sc.next();
                    age = sc.nextInt();
                    doing.workInfo("delete",name,age,phone,email);
                    break;

                case 4:
                    System.out.println("수정할 인원의 정보를 입력하시오");
                    System.out.print("수정할 인원 이름 : ");

                    name = sc.next();

                    System.out.print("나이 : ");

                    age = sc.nextInt();

                    System.out.print("전화번호 : ");

                    phone = sc.next();

                    System.out.print("이메일 : ");

                    email = sc.next();

                    doing.workInfo("updaate",name,age,phone,email);
                    break;

                case 5:
                    System.out.println("종료");

            }
            break;
        }
    }
}
