/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_pertanian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rokhis
 */

public class Koneksi2 {
    private static Connection mysqlKoneksi;
    public static Connection koneksi() {
        try {
            String url= "jdbc:mysql://localhost:3306/db_pertanian";
            String user= "root";
            String pass= "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlKoneksi=DriverManager.getConnection(url,user,pass);
            System.out.println("Koneksi Berhasil");
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal"+e.getMessage());         
        }
        return mysqlKoneksi;
    }
    public static void main(String[] args) {
        koneksi();
    }
}