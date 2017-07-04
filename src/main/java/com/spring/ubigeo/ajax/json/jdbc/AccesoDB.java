package com.spring.ubigeo.ajax.json.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {
	 public static Connection getConnection() throws Exception {
	        Connection cn = null;
	        try {
	            //1- cargar driver en memoria
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            //url de la base de datos
	            String url = "jdbc:mysql://localhost:3306/spring_uno";
	            // obtener la conexion
	            cn = DriverManager.getConnection(url, "root", "mysql");
	            System.out.println("CONEXION EXITOSA!...");
	        } catch (ClassNotFoundException | SQLException e) {
	        	System.out.println("error en la conexion Mensaje: " + e.getMessage());
	            throw e;
	        }
	        return cn;
	    }
}
