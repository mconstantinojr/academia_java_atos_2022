package br.atos.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.atos.model.Coordenador;
import br.atos.model.Endereco;

public class CoordenadorDao {
	
	public boolean salvarCoordenadorNoBanco(Coordenador coordenador) {
		String sql = "insert into coordenador(nome, cpf, salario, endereco,loja, metaloja) values(?,?,?,?,?,?)";
		boolean validarSalvar = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, coordenador.getNome());
			pstm.setString(2, coordenador.getCpf());
			pstm.setDouble(3, coordenador.getSalarioLiquido());
			pstm.setString(4, coordenador.getEndereco().getEndereco());
			pstm.setString(5, coordenador.getLoja());
			pstm.setDouble(6, coordenador.getMetaLoja());
			
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
	
	public List<Coordenador> listarCoordenador() {
		String sql = "select * from coordenador";
		List<Coordenador> listarCoordenador = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			pstm = conn.prepareStatement(sql); 
			rs = pstm.executeQuery();// 
			
			while(rs.next()) {
				Coordenador coordenador = new Coordenador();
				Endereco endereco = new Endereco();
				
				coordenador.setCpf(rs.getString("cpf"));
				coordenador.setNome(rs.getString("nome"));
				coordenador.setSalarioLiquido(rs.getDouble("salario"));
				coordenador.setLoja(rs.getString("loja"));
				coordenador.setMetaLoja(rs.getDouble("metaloja"));
				endereco.setEndereco(rs.getString("endereco"));

				coordenador.setEndereco(endereco);
				listarCoordenador.add(coordenador);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar lista");
		}finally {
			try {
				
				if(rs != null) {
					rs.close();
				}
				if(conn != null) {
					conn.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Erro ao fechar conexão");
			}
			
			
		}
		
		
		return listarCoordenador;
		
		
	}
	
	public boolean deleteCoordenadorNoBanco(String cpf) {
		String sql = "delete from coordenador where cpf = ?";
		boolean validarExcluir = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, cpf);
			
			pstm.executeUpdate();
			
			validarExcluir = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro na tentativa de excluir");
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
		
		return validarExcluir;
	}
	
	public boolean alterarCoordenadorNoBanco(Coordenador coordenador) {
		String sql = "update coordenador set nome = ?, salario = ?, endereco = ?, loja = ?, metaloja = ? where cpf = ?";
		boolean validarAlterar = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, coordenador.getNome());
			pstm.setDouble(2, coordenador.getSalarioLiquido());
			pstm.setString(3, coordenador.getEndereco().getEndereco());
			pstm.setString(4, coordenador.getLoja());
			pstm.setDouble(5, coordenador.getMetaLoja());
			pstm.setString(6, coordenador.getCpf());
			
			pstm.executeUpdate();
			
			validarAlterar = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro na tentativa de alterar");
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
		
		return validarAlterar;
	}
}
