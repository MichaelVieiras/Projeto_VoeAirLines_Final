package br.com.voeairlines.controller;

import java.util.ArrayList;
import java.util.Vector;

import br.com.voeairlines.dao.ExceptionDAO;
import br.com.voeairlines.model.TipoAeronave;

public class TipoAeronaveController {

	public boolean cadastrarTipoAeronave(String descricao) throws ExceptionDAO {
		if (descricao != null && descricao.length() > 0) {
			TipoAeronave desc = new TipoAeronave(descricao);
			desc.cadastrarTipoAeronave(desc);
			return true;
		}
		return false;
	}

	public ArrayList<TipoAeronave> listaTipoAeronave(String nome) throws ExceptionDAO {
		return new TipoAeronave().listaTipoAeronave(nome);
	}

	public boolean alterarTipoAeronave(Integer idTipoAeronave, String descricao) throws ExceptionDAO {
		if (idTipoAeronave != null && idTipoAeronave > 0 && descricao != null && descricao.length() > 0) {
			TipoAeronave tpAeronave = new TipoAeronave(idTipoAeronave, descricao);
			tpAeronave.setIdTipoAeronave(idTipoAeronave);
			tpAeronave.alterarTipoAeronave(tpAeronave);
			return true;
		}
		return false;
	}

	public boolean apagarTipoAeronave(Integer idTipoAeronave) throws ExceptionDAO {
		if (idTipoAeronave == 0) {
			return false;
		} else {
			TipoAeronave tpAeronave = new TipoAeronave();
			tpAeronave.setIdTipoAeronave(idTipoAeronave);
			tpAeronave.apagarTipoAeronave(tpAeronave);
			return true;
		}
	}

	public Vector<TipoAeronave> listarDescricao() throws ExceptionDAO {
		return new TipoAeronave().listarDescricao();
	}
}
