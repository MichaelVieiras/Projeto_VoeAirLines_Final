package br.com.voeairlines.controller;

import java.util.ArrayList;

import br.com.voeairlines.dao.ExceptionDAO;
import br.com.voeairlines.model.Aeronave;
import br.com.voeairlines.model.TipoAeronave;
import br.com.voeairlines.model.Usuario;

public class AeronaveController {

	public boolean cadastrarAeronave(String fabricante, String modelo, String codigoAeronave, TipoAeronave descricao)
			throws ExceptionDAO {
		if (fabricante != null && fabricante.length() > 0 && modelo != null && modelo.length() > 0
				&& codigoAeronave != null && codigoAeronave.length() > 0) {
			Aeronave aeronave = new Aeronave(fabricante, modelo, codigoAeronave, descricao);
			aeronave.cadastrarAeronave(aeronave);
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Aeronave> listaAeronaves(String nome) throws ExceptionDAO {
		return new Aeronave().listaAeronaves(nome);
	}

	public boolean alterarAeronave(Integer idAeronave, String fabricante, String modelo, String codigoAeronave,
			TipoAeronave descricao) throws ExceptionDAO {
		if (fabricante != null && fabricante.length() > 0 && modelo != null && modelo.length() > 0
				&& codigoAeronave != null && codigoAeronave.length() > 0) {
			Aeronave aeronave = new Aeronave(idAeronave, fabricante, modelo, codigoAeronave, descricao);
			aeronave.setIdAeronave(idAeronave);
			aeronave.alterarAeronave(aeronave);
			return true;
		}
		return false;
	}

	public boolean apagarAeronave(Integer idAeronave) throws ExceptionDAO {
		if (idAeronave == 0) {
			return false;
		} else {
			Aeronave aeronave = new Aeronave();
			aeronave.setIdAeronave(idAeronave);
			aeronave.apagarAeronave(aeronave);
			return true;
		}
	}
}
