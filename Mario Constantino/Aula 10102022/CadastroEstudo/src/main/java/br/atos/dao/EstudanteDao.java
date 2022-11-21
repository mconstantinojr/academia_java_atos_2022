package br.atos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.atos.model.Endereco;
import br.atos.model.Estudante;

public class EstudanteDao {
	
	public boolean salvarEdudanteNoBanco(Estudante estudante) {
		boolean validarSalvar = false;
		String sql = "insert into Estudante(nome, cpf, cidade, rua, casa, turma, media) "+
		"values(?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, estudante.getNome());
			pstm.setString(2, estudante.getCpf());
			pstm.setString(3, estudante.getEndereco().getCidade());
			pstm.setString(4, estudante.getEndereco().getRua());
			pstm.setString(5, estudante.getEndereco().getCasa());
			pstm.setString(6, estudante.getTurma());
			pstm.setDouble(7, estudante.getMedia());
			
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
	
	public List<Estudante> listarEstudante() {
		String sql = "select * from Estudante";
		List<Estudante> listarEstudante = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			pstm = conn.prepareStatement(sql); 
			rs = pstm.executeQuery();// 
			
			while(rs.next()) {
				Estudante estudante = new Estudante();
				Endereco endereco = new Endereco();
				
				estudante.setId(rs.getInt("id"));
				estudante.setCpf(rs.getString("cpf"));
				estudante.setNome(rs.getString("nome"));
				estudante.setTurma(rs.getString("turma"));
				estudante.setMedia(rs.getDouble("media"));
				endereco.setCasa(rs.getString("casa"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setRua(rs.getString("rua"));

				estudante.setEndereco(endereco);
				listarEstudante.add(estudante);
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
		
		
		return listarEstudante;
	}
	
	public boolean deleteEstudanteNoBanco(Estudante estudante) {
		String sql = "delete from Estudante where id = ?";
		boolean validarExcluir = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, estudante.getId());
			
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
	
	public boolean alterarEstudanteNoBanco(Estudante estudante) {
		String sql = "update Estudante set nome = ?, cpf = ?, cidade = ?, rua = ?, casa = ?, turma = ?, media = ? where id = ?";
		boolean validarAlterar = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, estudante.getNome());
			pstm.setString(2, estudante.getCpf());
			pstm.setString(3, estudante.getEndereco().getCidade());
			pstm.setString(4, estudante.getEndereco().getRua());
			pstm.setString(5, estudante.getEndereco().getCasa());
			pstm.setString(6, estudante.getTurma());
			pstm.setDouble(7, estudante.getMedia());
			pstm.setInt(8, estudante.getId());
			
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
