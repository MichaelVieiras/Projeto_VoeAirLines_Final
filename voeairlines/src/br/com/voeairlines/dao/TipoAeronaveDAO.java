package br.com.voeairlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import br.com.voeairlines.model.TipoAeronave;

public class TipoAeronaveDAO {
	public void cadastrarTipoAeronave(TipoAeronave tipoAeronave) throws ExceptionDAO {

		String sql = "INSERT INTO tipoaeronave (descricao) VALUES (?)";
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = new ConnectionMVC().getConnetion();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tipoAeronave.getDescricao());

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

	public ArrayList<TipoAeronave> listaTipoAeronave(String nome) throws ExceptionDAO {
		String sql = "SELECT * FROM tipoAeronave WHERE usuario like '%" + nome + "%' order by descricao";

		Connection con = null;
		PreparedStatement stmt = null;
		ArrayList<TipoAeronave> tpAeronaves = null;

		try {
			con = new ConnectionMVC().getConnetion();
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			if (rs != null) {
				tpAeronaves = new ArrayList<TipoAeronave>();
				while (rs.next()) {
					TipoAeronave tpAeronave = new TipoAeronave();
					tpAeronave.setIdTipoAeronave(rs.getInt("idTipoAeronave"));
					tpAeronave.setDescricao(rs.getString("descricao"));
					tpAeronaves.add(tpAeronave);

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
		return tpAeronaves;
	}

	public void alterarTipoAeronave(TipoAeronave tipoAeronave) throws ExceptionDAO {
		String sql = "UPDATE tipoaeronave set descricao = ? WHERE idTipoAeronave=?";
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = new ConnectionMVC().getConnetion();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tipoAeronave.getDescricao());
			stmt.setInt(2, tipoAeronave.getIdTipoAeronave());

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

	public void apagarTipoAeronave(TipoAeronave tipoAeronave) throws ExceptionDAO {
		String sql = "DELETE FROM tipoaeronave WHERE idTipoAeronave=?";
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = new ConnectionMVC().getConnetion();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, tipoAeronave.getIdTipoAeronave());
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

	public Vector<TipoAeronave> listarDescricao() throws ExceptionDAO {
		String sql = "SELECT * FROM tipoaeronave order by descricao";
		Vector<TipoAeronave> tpAeronaves = new Vector<TipoAeronave>();
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = new ConnectionMVC().getConnetion();
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					TipoAeronave tpAeronave = new TipoAeronave();
					tpAeronave.setIdTipoAeronave(rs.getInt("idTipoAeronave"));
					tpAeronave.setDescricao(rs.getString("descricao"));
					tpAeronaves.add(tpAeronave);
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
		return tpAeronaves;
	}
}
