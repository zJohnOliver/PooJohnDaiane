 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Cliente;
import view.Palco;


public class DeletarFXMLController implements Initializable {

    @FXML
    private Button Bd;

    @FXML
    private Button Bv;
    
    @FXML
    private TextField cnome;

    @FXML
    void deletar() {
        delete();

    }

    @FXML
    void voltar() {
        Palco.principal();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
     public void delete(){
        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cliente.setNome(cnome.getText());
        
        
        dao.deletar(cliente);
        limpar();
        
        
        JOptionPane.showMessageDialog(null, "Sucesso ao Deletar!");
        
    }
     private void limpar() {
        cnome.setText("");
}
}
