package org.example;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.mysql.jdbc.Driver;

import javax.swing.plaf.nimbus.State;

public class Main {
    //public static final String url="jdbc:mysql://localhost:3306/addressbook";
    public static final String url = "jdbc:mysql://localhost:3306/addressbook1?allowPublicKeyRetrieval=true&useSSL=false";
    public static final String user="root";
    public static final String password="root";

    public static List<Address> getAllContacts(){
        List<Address> l1=new ArrayList();
        String sql="select * from contact";
        System.out.println(sql);


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c1 = DriverManager.getConnection(url, user,password);
            Statement s1= c1.createStatement();
            ResultSet r1=s1.executeQuery(sql);
            while(r1.next()) {
                int id=r1.getInt("id");
                String fname=r1.getString("first_name");
                String lname=r1.getString("last_name");
                String phone=r1.getString("phone_number");
                String email=r1.getString("email");

                l1.add(new Address(id,fname,lname,phone,email));

            }

        }
        catch(SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return l1;

    }
    public static Connection connect() throws SQLException{
        return DriverManager.getConnection(url, user,password);
    }
    public static void addContact(String firstName, String lastName, String phone, String email){
        String query= "insert into contact values(default,'"+ firstName + "','"+ lastName + "','"+ phone +"','"+ email +"')";
        try{
            Connection conn= connect();
            Statement s= conn.createStatement();
            s.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void updateContact(int id, String firstName, String lastName, String phone, String email){
        String query= "update contact set first_name='"+ firstName +"' ,last_name='"+ lastName +"' ,phone_number='"+ phone +"' ,email='"+ email +"' where id="+id;
        try{
            Connection conn= connect();
            Statement s= conn.createStatement();
            s.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deleteContact(int id){
        String query= "delete from contact where id="+id;
        try{
            Connection conn= connect();
            Statement s= conn.createStatement();
            s.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println(getAllContacts());
        Main m1= new Main();
       // m1.addContact("Intelli","J","823413243","intellij@gmail.com");
        //m1.updateContact(3,"Abc","Def","9889988989","test1@gamil.com");
        //m1.deleteContact(4);
    }
}

