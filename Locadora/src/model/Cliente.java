
package model;


public class Cliente {
    private String nome;
    private String telefone;
    private String anome;

    public String getNome() {
        return nome;
    }
     public String getAnome() {
        return anome;
    }
     public void setAnome(String nome) {
        this.anome = nome.toUpperCase();
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getNumeroTell() {
        return telefone;
    }

    public void setNumeroTell(String numeroTell) {
        telefone = numeroTell;
    }

}
