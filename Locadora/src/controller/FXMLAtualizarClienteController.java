package controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;

/**
 * FXML Controller class
 *
 * @author Israel
 */
public class FXMLAtualizarClienteController implements Initializable {
    @FXML private TextField txtNome;
    @FXML private TextField txtTelefone; 
    private Stage stage;
    private boolean btnAtualizar = false;
    private Cliente cliente;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    Cliente aluno = new Cliente();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isBtnSalvar() {
        return btnAtualizar;
    }

    public void setBtnSalvar(boolean btnSalvar) {
        this.btnAtualizar = btnSalvar;
    }
    @FXML
    void handleSalvar() {        
        cliente.setNome(txtNome.getText());
        cliente.setNumeroTell(txtTelefone.getText());     
        btnAtualizar = true;
        stage.close();
        
    }

    @FXML
    void handleCancelar() {
        stage.close();
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
        txtNome.setText(String.valueOf(cliente.getNome()));
        txtTelefone.setText(String.valueOf(cliente.getNumeroTell()));
       
    }
   
  
}
