
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import view.Palco;


public class TelaPNovaFXMLController implements Initializable {
    
    @FXML
    private Menu Listar;

    @FXML
    private Menu Atualizar;

    @FXML
    private Menu Deletar;

    @FXML
    private Menu Cadastrar;

    @FXML
    private MenuBar Menub;

    @FXML
    void Buc() {
        Palco.cadastro();
    }

    @FXML
    void Bul() {
        Palco.listar();
    }

    @FXML
    void Bua() {
        Palco.atualizar();
    }

    @FXML
    void Bud() {
        Palco.deletar();

    }



    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
