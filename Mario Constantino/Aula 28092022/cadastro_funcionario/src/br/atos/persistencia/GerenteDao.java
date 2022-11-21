package br.atos.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.atos.model.Endereco;
import br.atos.model.Gerente;

public class GerenteDao {
	
	public boolean salvarGerenteNoBanco(Gerente gerente) {
		String sql = "insert into gerente(nome, cpf, salario, endereco,regional, metaRegional) values(?,?,?,?,?,?)";
		boolean validarSalvar = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, gerente.getNome());
			pstm.setString(2, gerente.getCpf());
			pstm.setDouble(3, gerente.getSalarioLiquido());
			pstm.setString(4, gerente.getEndereco().getEndereco());
			pstm.setString(5, gerente.getRegional());
			pstm.setDouble(6, gerente.getMetaRegional());
			
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
	
	public List<Gerente> listarGerente() {
		String sql = "select * from gerente";
		List<Gerente> listarGerentes = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			pstm = conn.prepareStatement(sql); 
			rs = pstm.executeQuery();// 
			
			while(rs.next()) {
				Gerente gerente = new Gerente();
				Endereco endereco = new Endereco();
				
				gerente.setCpf(rs.getString("cpf"));
				gerente.setNome(rs.getString("nome"));
				gerente.setSalarioLiquido(rs.getDouble("salario"));
				gerente.setRegional(rs.getString("regional"));
				gerente.setMetaRegional(rs.getDouble("metaRegional"));
				endereco.setEndereco(rs.getString("endereco"));

				gerente.setEndereco(endereco);
				listarGerentes.add(gerente);
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
		
		
		return listarGerentes;
		
		
	}
	
	public boolean deleteGerenteNoBanco(String cpf) {
		String sql = "delete from gerente where cpf = ?";
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
	
	public boolean alterarGerenteNoBanco(Gerente gerente) {
		String sql = "update gerente set nome = ?, salario = ?, endereco = ?, regional = ?, metaRegional = ? where cpf = ?";
		boolean validarAlterar = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, gerente.getNome());
			pstm.setDouble(2, gerente.getSalarioLiquido());
			pstm.setString(3, gerente.getEndereco().getEndereco());
			pstm.setString(4, gerente.getRegional());
			pstm.setDouble(5, gerente.getMetaRegional());
			pstm.setString(6, gerente.getCpf());
			
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
