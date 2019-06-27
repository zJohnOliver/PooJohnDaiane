
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Cliente;
import dao.ClienteDAO;
import view.Palco;

public class CadastroFXMLController implements Initializable {
    
    @FXML private TextField ctelefone;
    @FXML private Button bcadastrar;
    @FXML private TextField cnome;
    
    @FXML void cadatrarcliente(ActionEvent event) {
        
        salvar();
    }
    
    @FXML
    void Voltar(ActionEvent event) {
        Palco.principal();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

     }  
    @FXML
     public void salvar(){
        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cliente.setNome(cnome.getText());
        cliente.setNumeroTell(ctelefone.getText());
        
        
        dao.salvar(cliente);
        limpar();
        
    }
    private void limpar() {
        cnome.setText("");
        ctelefone.setText("");
}
    
    
}
