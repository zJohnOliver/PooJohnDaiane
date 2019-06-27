/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Cliente;
import view.Palco;


public class AtualizarFXMLController implements Initializable {
    @FXML
    private Button atualizar;

    @FXML
    private TextField Nnome;

    @FXML
    private TextField Nome;

    @FXML
    private TextField Ntell;

    @FXML
    void Batualizar() {
        Atualizar();
        

    }

    @FXML
    void voltar() {
        Palco.principal();

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public void Atualizar(){
        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cliente.setNome(Nnome.getText());
        cliente.setNumeroTell(Ntell.getText());
        cliente.setAnome(Nome.getText());
        
        dao.atualizar(cliente);
        limpar();
        
    }
     private void limpar() {
        Nome.setText("");
        Nnome.setText("");
        Ntell.setText("");
}
}
