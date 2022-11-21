package br.atos.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.atos.model.LoginEntidade;

public class LoginDao {
	
	private static String URL = "jdbc:mysql://bc2907vvsrno7lhoy8di-mysql.services.clever-cloud.com/bc2907vvsrno7lhoy8di?useTimezone=true&serverTimezone=UTC";
	//private static String URL = "jdbc:mysql://localhost:3306/projetoweb?useTimezone=true&serverTimezone=UTC";
	//private static String USERNAME = "root";
	//private static String PASSWORD = "root";
	private static String USERNAME = "uxkqgehuklhxhjel";
	private static String PASSWORD = "ZRNAaz6x6y39Dlu8rPxY";
		
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void carregarDrive(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Deu ruim ao tentar carregar o driver");
		}
	}
	
	public Connection pegarConexao() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Deu ruim ao criar conexao");
		}
		
		return conn;
	}
	
	public boolean validaLogin(LoginEntidade loginEntidade) {
		boolean validacao = false;
		
		carregarDrive(dbDriver);
		
		Connection conn = pegarConexao();
		
		String sql = "select * from login where username = ? and senha = ?";
		
		PreparedStatement pst = null;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, loginEntidade.getUsername());
			pst.setString(2, loginEntidade.getPassword());
			
			ResultSet resultado = pst.executeQuery();
			
			validacao = resultado.next();
					
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deu ruim no validaLogin");
		} finally {
			try {
				if(pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("Erro ao tentar encerrrar as conexões");
			}
		}
		
		
		
		return validacao;
	}

	public boolean validaSeUsuarioExiste(LoginEntidade loginEntidade) {
		boolean validacao = false;
		
		carregarDrive(dbDriver);
		
		Connection conn = pegarConexao();
		
		String sql = "select * from login where upper(username) = ?";
		
		PreparedStatement pst = null;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, loginEntidade.getUsername().toUpperCase());
			
			ResultSet resultado = pst.executeQuery();
			
			validacao = resultado.next();
					
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deu ruim no validaSeUsuarioExiste");
		} finally {
			try {
				if(pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("Erro ao tentar encerrrar as conexões");
			}
		}
		
		
		
		return validacao;
	}

	public boolean salvaUsuarioNoBanco(LoginEntidade loginEntidade) {
		String sql = "insert into login(username, senha) values(?,?)";
		boolean validarSalvar = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = pegarConexao();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, loginEntidade.getUsername());
			pstm.setString(2, loginEntidade.getPassword());
			
			pstm.execute();
			
			validarSalvar = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro na tentativa de registrar");
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("Erro ao tentar encerrrar as conexões");
			}
		}
		
		return validarSalvar;
	}
}
