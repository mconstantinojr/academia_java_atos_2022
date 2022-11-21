package br.atos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.atos.model.Endereco;
import br.atos.model.Estudante;
import br.atos.model.Professor;

public class ProfessorDao {
	
	public boolean salvarProfessorNoBanco(Professor professor) {
		boolean validarSalvar = false;
		String sql = "insert into professor(nome, cpf, cidade, rua, casa, disciplina, salario) "+
		"values(?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, professor.getNome());
			pstm.setString(2, professor.getCpf());
			pstm.setString(3, professor.getEndereco().getCidade());
			pstm.setString(4, professor.getEndereco().getRua());
			pstm.setString(5, professor.getEndereco().getCasa());
			pstm.setString(6, professor.getDisciplina());
			pstm.setDouble(7, professor.getSalario());
			
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
	
	public List<Professor> listarProfessor() {
		String sql = "select * from professor";
		List<Professor> listarProfessor = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			pstm = conn.prepareStatement(sql); 
			rs = pstm.executeQuery();// 
			
			while(rs.next()) {
				Professor professor = new Professor();
				Endereco endereco = new Endereco();
				
				professor.setId(rs.getInt("id"));
				professor.setCpf(rs.getString("cpf"));
				professor.setNome(rs.getString("nome"));
				professor.setDisciplina(rs.getString("disciplina"));
				professor.setSalario(rs.getDouble("salario"));
				endereco.setCasa(rs.getString("casa"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setRua(rs.getString("rua"));

				professor.setEndereco(endereco);
				listarProfessor.add(professor);
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
		
		
		return listarProfessor;
	}
	
	public boolean deleteProfessorNoBanco(Professor professor) {
		String sql = "delete from professor where id = ?";
		boolean validarExcluir = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, professor.getId());
			
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
	
	public boolean alterarProfessorNoBanco(Professor professor) {
		String sql = "update professor set nome = ?, cpf = ?, cidade = ?, rua = ?, casa = ?, disciplina = ?, salario = ? where id = ?";
		boolean validarAlterar = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = FabricaDeConexao.criaConexaoMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, professor.getNome());
			pstm.setString(2, professor.getCpf());
			pstm.setString(3, professor.getEndereco().getCidade());
			pstm.setString(4, professor.getEndereco().getRua());
			pstm.setString(5, professor.getEndereco().getCasa());
			pstm.setString(6, professor.getDisciplina());
			pstm.setDouble(7, professor.getSalario());
			pstm.setInt(8, professor.getId());
			
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
