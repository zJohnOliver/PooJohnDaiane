
package controller;

import dao.ClienteDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cliente;
import view.Palco;


public class ListarFXMLController implements Initializable {
    
    @FXML
    private TableView<Cliente> Tabela;
    
    @FXML
    private TableColumn<Cliente, String> Cclientes;

    @FXML
    private TableColumn<Cliente, String> Ctelefone;
    
    @FXML
    private Button Bv;

    @FXML
    void Voltar() {
        Palco.principal();
    }
    
     ClienteDAO dao = new ClienteDAO();

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            iniciartabela();
        } catch (SQLException e) {
        }
        
    }    
    public void iniciartabela()throws SQLException{                    
            Cclientes.setCellValueFactory(new PropertyValueFactory<>("nome"));
            Ctelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
            
            Tabela.setItems(listaCliente());    
        
        
        
   
    }
    public ObservableList<Cliente> listaCliente() throws SQLException{
             List<Cliente> lista = dao.pesquisarAll();             
             return FXCollections.observableArrayList(lista);
            
        }
}
