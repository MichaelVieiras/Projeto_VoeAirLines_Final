package br.com.voeairlines.model;

import java.util.ArrayList;

import br.com.voeairlines.dao.AeronaveDAO;
import br.com.voeairlines.dao.ExceptionDAO;
import br.com.voeairlines.dao.UsuarioDAO;

public class Aeronave {
	private Integer idAeronave;
	private String fabricante;
	private String modelo;
	private String codigoAeronave;
	private TipoAeronave descricao;

	public Aeronave() {
		descricao = new TipoAeronave();
	}

	public Aeronave(String fabricante, String modelo, String codigoAeronave, TipoAeronave descricao) {
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.codigoAeronave = codigoAeronave;
		this.descricao = descricao;
	}

	public Aeronave(Integer idAeronave, String fabricante, String modelo, String codigoAeronave) {
		this.idAeronave = idAeronave;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.codigoAeronave = codigoAeronave;
	}

	public Aeronave(Integer idAeronave, String fabricante, String modelo, String codigoAeronave,
			TipoAeronave descricao) {
		this.idAeronave = idAeronave;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.codigoAeronave = codigoAeronave;
		this.descricao = descricao;
	}

	public Integer getIdAeronave() {
		return idAeronave;
	}

	public void setIdAeronave(Integer idAeronave) {
		this.idAeronave = idAeronave;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCodigoAeronave() {
		return codigoAeronave;
	}

	public void setCodigoAeronave(String codigoAeronave) {
		this.codigoAeronave = codigoAeronave;
	}

	public TipoAeronave getDescricao() {
		return descricao;
	}

	public void setDescricao(TipoAeronave idTipoAeronave) {
		descricao = idTipoAeronave;
	}

	public void cadastrarAeronave(Aeronave aeronave) throws ExceptionDAO {
		new AeronaveDAO().cadastrarAeronave(aeronave);
	}

	public ArrayList<Aeronave> listaAeronaves(String nome) throws ExceptionDAO {
		return new AeronaveDAO().listaAeronaves(nome);
	}

	public void alterarAeronave(Aeronave aeronave) throws ExceptionDAO {
		new AeronaveDAO().alterarAeronave(aeronave);
	}

	public void apagarAeronave(Aeronave aeronave) throws ExceptionDAO {
		new AeronaveDAO().apagarAeronave(aeronave);
	}
}
