package br.edu.cesmac.aulapoo5.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.cesmac.aulapoo5.model.Pessoa;
import br.edu.cesmac.aulapoo5.model.PessoaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class VisualizarController implements Initializable  {

	private PessoaDAO dao = PessoaDAO.getInstance();
	
	@FXML
	private ListView<Pessoa> lista;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Pessoa> obs = FXCollections.observableArrayList(dao.buscar());
		lista.setItems(obs);
	}

}
