package br.edu.cesmac.aulapoo5.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.edu.cesmac.aulapoo5.model.Pessoa;
import br.edu.cesmac.aulapoo5.model.PessoaDAO;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InicioController implements Initializable {
	
	private PessoaDAO dao = PessoaDAO.getInstance();
	
	@FXML
	private Label labelTitulo;
	
	@FXML
	private Button btnCadastrar;
	
	@FXML
	private TextField tfNome;
	
	@FXML
	private CheckBox checkbox;
	
	@FXML
	private ToggleGroup genero;
	
	@FXML
    private ListView<Pessoa> listaPessoa;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void clicou() {
		String nome = tfNome.getText();
		Alert alerta;
		
		if (nome.equals("")) {
			alerta = new Alert(AlertType.ERROR, "Preencha o nome", ButtonType.OK);
		} else {
			alerta = new Alert(AlertType.NONE, "Cadastrado com Sucesso", ButtonType.OK);
			
			Pessoa.Genero genero;
			RadioButton radio = (RadioButton) this.genero.getSelectedToggle();
			switch(radio.getText()) {
				case "Masculino": genero = Pessoa.Genero.MASCULINO; break;
				case "Feminino": genero = Pessoa.Genero.FEMININO; break;
				default: genero = Pessoa.Genero.OUTRO;
			}
			
			tfNome.setText("");
			dao.cadastrar(new Pessoa(nome, genero));
		}
		
		alerta.show();
		
	}
	
	public void menuVisualizar() {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("../view/Visualizar.fxml"));
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		
			//btnCadastrar.getScene().getWindow().hide();
		} catch (Exception e) {
			new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
		}
	}
	
	public void menuSair() {
		System.exit(0);
	}
	
	public void menuSobre() {
		new Alert(AlertType.NONE, "Criado por Carlos", ButtonType.OK).show();
	}
	
	
}
