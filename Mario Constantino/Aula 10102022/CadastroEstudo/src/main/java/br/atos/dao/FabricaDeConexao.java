package br.atos.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaDeConexao {
	
	private static String URL = "jdbc:mysql://bc2907vvsrno7lhoy8di-mysql.services.clever-cloud.com/bc2907vvsrno7lhoy8di?useTimezone=true&serverTimezone=UTC";
	private static String USERNAME = "uxkqgehuklhxhjel";
	private static String PASSWORD = "ZRNAaz6x6y39Dlu8rPxY";
		
	private static String dbDriver = "com.mysql.cj.jdbc.Driver";

	public static Connection criaConexaoMySql() throws Exception {
		Class.forName(dbDriver);
		
		Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		return conexao;
	}
}
