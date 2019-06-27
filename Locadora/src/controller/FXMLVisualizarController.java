
package controller;


import dao.ClienteDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Cliente;
import view.Palco;

/**
 * FXML Controller class
 *
 * @author Israel
 */
public class FXMLVisualizarController implements Initializable {
    @FXML private TableColumn<Cliente, String> colNome;
    @FXML private TableView<Cliente> tabela;
    @FXML private TableColumn<Cliente, String> colTelefone;
    ClienteDAO dao = new ClienteDAO();
    
   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
        mostrarTabela();
    }    

    
        
    @FXML
    public void btExcluir(){        
        Cliente cliente = new Cliente();
        cliente = tabela.getSelectionModel().getSelectedItem();        
        if(cliente != null){            
            if(dao.deletar(cliente.getNome())){
                Alert alert = new Alert(Alert.AlertType.WARNING);            
                alert.setTitle("Exclusão com sucesso");
                alert.setHeaderText("Exclusão");
                alert.setContentText("Dados excluidos com sucesso");
                alert.showAndWait();
                mostrarTabela();
            }else{
                System.out.println("Erro ao excluir");
            }                             
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);            
            alert.setTitle("Exclusão");
            alert.setHeaderText("Cabeçalho do alerta");
            alert.setContentText("Você deve selecionar um Cliente para excluir");
            alert.show();
        }        
    }

    public void mostrarTabela(){
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));         
        tabela.setItems(listaClientes());
    }
    public ObservableList<Cliente> listaClientes(){
        ArrayList<Cliente> lista =  (ArrayList<Cliente>) dao.pesquisarAll();
        return FXCollections.observableArrayList(lista);        
    }
    @FXML
    void btVoltar() {
        Palco.principal();
    }
    
    @FXML
    public void btAlterar() throws IOException{
        Cliente cliente = tabela.getSelectionModel().getSelectedItem();
        if(cliente != null){
            boolean buttonConfirmaClick = showTela(cliente);
            if(buttonConfirmaClick){                
                dao.atualizar(cliente);
                mostrarTabela();
            }            
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);            
            alert.setTitle("Alterar");
            alert.setHeaderText("Cabeçalho do alerta");
            alert.setContentText("Você deve selecionar um cliente para alterar");
            alert.show();
        }           
    }

    private boolean showTela(Cliente cliente)throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAtualizarClienteController.class.getResource("/view/FXMLAtualizarCliente.fxml"));
        AnchorPane pagina = (AnchorPane) loader.load();        
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Atualizar aluno");
        Scene scener = new Scene(pagina);
        dialogStage.setScene(scener);
        
        FXMLAtualizarClienteController alterarController = loader.getController();
        alterarController.setStage(dialogStage);
        alterarController.setCliente(cliente);
        dialogStage.showAndWait();
        return alterarController.isBtnSalvar();
    }
}
