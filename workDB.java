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

        int columnCnt = rs.getMetaData().getColumnCount(); // 컬럼갯수(필요없음.)

       
        System.out.printf("%-10s %-10s %-10s %-10s\n", "StudentName", "StudentAge","StudentPhone","StudentEmail");

        while(rs.next()){
            String st_name = rs.getString("StudentName");
            String st_age = rs.getString("StudentAge");
            String st_phone = rs.getString("StudentPhone");
            String st_email = rs.getString("StudentEmail");
            System.out.printf("%-10s %-12s %-12s %-10s\n", st_name, st_age,st_phone,st_email);
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
