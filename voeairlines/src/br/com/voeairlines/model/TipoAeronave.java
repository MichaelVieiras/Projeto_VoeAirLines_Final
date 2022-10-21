package br.com.voeairlines.model;

import java.util.ArrayList;
import java.util.Vector;

import br.com.voeairlines.dao.ExceptionDAO;
import br.com.voeairlines.dao.TipoAeronaveDAO;
import br.com.voeairlines.dao.UsuarioDAO;

public class TipoAeronave {
	private Integer idTipoAeronave;
	private String descricao;

	public TipoAeronave() {

	}

	public TipoAeronave(Integer idTipoAeronave) {
		this.idTipoAeronave = idTipoAeronave;
	}

	public TipoAeronave(String descricao) {
		this.descricao = descricao;
	}

	public TipoAeronave(Integer idTipoAeronave, String descricao) {
	}

	public Integer getIdTipoAeronave() {
		return idTipoAeronave;
	}

	public void setIdTipoAeronave(Integer idTipoAeronave) {
		this.idTipoAeronave = idTipoAeronave;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void cadastrarTipoAeronave(TipoAeronave tipoAeronave) throws ExceptionDAO {
		new TipoAeronaveDAO().cadastrarTipoAeronave(tipoAeronave);
	}

	public ArrayList<TipoAeronave> listaTipoAeronave(String nome) throws ExceptionDAO {
		return new TipoAeronaveDAO().listaTipoAeronave(nome);
	}

	public void alterarTipoAeronave(TipoAeronave tipoAeronave) throws ExceptionDAO {
		new TipoAeronaveDAO().alterarTipoAeronave(tipoAeronave);
	}

	public void apagarTipoAeronave(TipoAeronave tipoAeronave) throws ExceptionDAO {
		new TipoAeronaveDAO().apagarTipoAeronave(tipoAeronave);
	}

	public Vector<TipoAeronave> listarDescricao() throws ExceptionDAO {
		return new TipoAeronaveDAO().listarDescricao();
	}

	@Override
	public String toString() {
		return getDescricao();
	}
}
