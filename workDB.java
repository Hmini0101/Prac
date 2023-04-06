package org.example;

import java.sql.*;

public class workDB  {
    String url = "jdbc:mysql://localhost:3306/db_prac?serverTimezone=UTC";
    String userName = "root";
    String password = "뭘봐";


    public void listup() throws SQLException {


        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * from t_managestudent");
        //ResultSetMetaData rsmd = rs.getMetaData();

        int columnCnt = rs.getMetaData().getColumnCount(); // 컬럼갯수

        for(int i = 1; i<= columnCnt; i++ ){
            System.out.print(rs.getMetaData().getColumnName(i));
            System.out.print(" ");
        }

        System.out.println("");
        while(rs.next()){
            for(int i = 1; i< columnCnt; i++) {

                    System.out.println("   " + rs.getString(i) + "   ");

            }
        }
        rs.close();
        stmt.close();
        connection.close();
    }
        public void workInfo(String flag, String name, int age, String phone, String Email) throws SQLException{
            String query ="";
            Connection connection = DriverManager.getConnection(url, userName, password);

            Statement stmt = connection.createStatement();
            if(flag == "add") {// 추가시
                query = "INSERT INTO t_managestudent(StudentName,StudentAge,StudentPhone,StudentEmail) VALUES ('"+name+"', "+age+", '"+phone+"', '"+Email+"')";
            }else if(flag =="delete"){
                query = "DELETE * FROM t_managestudent WHERE StudentName ="+name+" ,StudentAge ="+age+" ,StudentPhone ="+phone+" StudentEmail ="+Email;
            }else if(flag =="update"){
                query = "UPDATE t_managestudent SET StudentAge ="+age+" ,StudentPhone ="+phone+" ,StudentEmail ="+Email+" WHERE StudentName = "+name;
            }
            int result = stmt.executeUpdate(query);
            
            System.out.println(result + "개 작업완료");


            stmt.close();
            connection.close();
        }
}
