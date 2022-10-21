package br.com.voeairlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.voeairlines.model.Aeronave;
import br.com.voeairlines.model.Usuario;
import br.com.voeairlines.view.TelaLogin;
import br.com.voeairlines.view.TelaPrincipal;

public class AeronaveDAO {
	public void cadastrarAeronave(Aeronave aeronave) throws ExceptionDAO {

		String sql = "INSERT INTO aeronave(fabricante, modelo, codigoaeronave, idTipoAeronave) VALUES (?,?,?,?)";
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = new ConnectionMVC().getConnetion();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, aeronave.getFabricante());
			stmt.setString(2, aeronave.getModelo());
			stmt.setString(3, aeronave.getCodigoAeronave());
			stmt.setInt(4, aeronave.getDescricao().getIdTipoAeronave());
			stmt.execute();
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao cadastrar usuario: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
			}
		}
	}

	public ArrayList<Aeronave> listaAeronaves(String nome) throws ExceptionDAO {
		String sql = "SELECT * FROM aeronave WHERE modelo like '%" + nome + "%' order by modelo";

		Connection con = null;
		PreparedStatement stmt = null;
		ArrayList<Aeronave> aeronaves = null;

		try {
			con = new ConnectionMVC().getConnetion();
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			if (rs != null) {
				aeronaves = new ArrayList<Aeronave>();
				while (rs.next()) {
					Aeronave aeronave = new Aeronave();
					aeronave.setIdAeronave(rs.getInt("idAeronave"));
					aeronave.setFabricante(rs.getString("fabricante"));
					aeronave.setModelo(rs.getString("modelo"));
					aeronave.setCodigoAeronave(rs.getString("codigoAeronave"));
					aeronaves.add(aeronave);
				}
			}
		} catch (Exception e) {
			throw new ExceptionDAO("Erro ao consultar Usuarios: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
			}
		}
		return aeronaves;
	}

	public void alterarAeronave(Aeronave aeronave) throws ExceptionDAO {
		String sql = "UPDATE aeronave set fabricante = ?, modelo = ?, codigoAeronave = ?, idTipoAeronave = ? WHERE idAeronave=?";
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = new ConnectionMVC().getConnetion();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, aeronave.getFabricante());
			stmt.setString(2, aeronave.getModelo());
			stmt.setString(3, aeronave.getCodigoAeronave());
			stmt.setInt(4, aeronave.getDescricao().getIdTipoAeronave());
			stmt.setInt(5, aeronave.getIdAeronave());
			stmt.execute();
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao alterar usuario: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
			}
		}
	}

	public void apagarAeronave(Aeronave aeronave) throws ExceptionDAO {
		String sql = "DELETE FROM aeronave WHERE idAeronave=?";
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = new ConnectionMVC().getConnetion();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, aeronave.getIdAeronave());
			stmt.execute();
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao cadastrar usuario: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
			}
		}
	}
}