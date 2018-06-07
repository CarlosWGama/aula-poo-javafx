package br.edu.cesmac.aulapoo5.model;

import java.util.ArrayList;

public class PessoaDAO {

	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public static PessoaDAO instancia;
	
	private PessoaDAO() {}
	
	public static PessoaDAO getInstance() {
		if (instancia == null) instancia = new PessoaDAO();
		return instancia;
	}
	
	
	public void cadastrar(Pessoa p) {
		pessoas.add(p);
	}
	
	public ArrayList<Pessoa> buscar() {
		return pessoas;
	}
}
