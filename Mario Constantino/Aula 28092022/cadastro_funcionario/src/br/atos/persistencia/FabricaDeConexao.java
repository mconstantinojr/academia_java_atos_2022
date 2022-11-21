package br.atos.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaDeConexao {

	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	private static String URL = "jdbc:mysql://localhost:3306/funcionariodb?useTimezone=true&serverTimezone=UTC";
	
	public static Connection criaConexaoMySql() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conexao = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		
		return conexao;
	}
}
