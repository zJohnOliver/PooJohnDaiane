package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jhonatan Sousa
 */
public class Palco extends Application {

    private static Stage palco;
    
    private static Scene principal;
    private static Scene cadastro;
    private static Scene listar;
    private static Scene deletar;
    private static Scene atualizar;
    
    
    @Override
    public void start(Stage stage) throws IOException {
        palco = stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("CadastroFXML.fxml"));
        cadastro = new Scene(root);
        
        root = FXMLLoader.load(getClass().getResource("TelaPNovaFXML.fxml"));
        principal = new Scene(root);
        
        root = FXMLLoader.load(getClass().getResource("FXMLVisualisar.fxml"));
        listar = new Scene(root);
        
        root = FXMLLoader.load(getClass().getResource("DeletarFXML.fxml"));
        deletar = new Scene(root);
        
        root = FXMLLoader.load(getClass().getResource("AtualizarFXML.fxml"));
        atualizar = new Scene(root);

        stage.setTitle("Sistema Locadora");
        stage.setScene(principal);
        stage.setResizable(false);
        stage.show();
    }
    
    public static void cadastro(){
        palco.setScene(cadastro);
    }
    
    public static void listar(){
        palco.setScene(listar);
    }

    public static void principal(){
        palco.setScene(principal);
    }
    
    public static void deletar(){
        palco.setScene(deletar);
    }
    
    public static void atualizar(){
        palco.setScene(atualizar);
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }

}
