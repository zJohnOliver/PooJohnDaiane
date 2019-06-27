package dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


import model.Cliente;

public class ClienteDAO {
    
    Connection con = null;
    //Método construtor
    public ClienteDAO(){
        con = Conexao.abrirConexao();
    }    
    public void salvar(Cliente cliente){
        try {
            String sql = "INSERT INTO CLIENTE(NOME, TELEFONE) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getNumeroTell());
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            }
           
        } catch (Exception e) {
        }
    }
    
     public boolean deletar(String nome){
        try {
            String sql = "DELETE FROM CLIENTE WHERE NOME = '"+nome+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void atualizar(Cliente cliente){
        try {
            String sql = "UPDATE CLIENTE SET NOME = ?, TELEFONE = ? WHERE NOME = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getNumeroTell());
            ps.setString(3, cliente.getAnome());
            if(ps.executeUpdate() !=0){
                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não Encontrado!");
        }
    }
    
    public List<Cliente> pesquisarAll(){
        List<Cliente> lista = new ArrayList<>();        
        try {
            String sql = "SELECT * FROM CLIENTE";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
             
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("NOME"));
                cliente.setNumeroTell(rs.getString("TELEFONE"));
                lista.add(cliente);                              
            }            
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu Erro!");
            return null;
        }   
    }

    public void deletar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
 }