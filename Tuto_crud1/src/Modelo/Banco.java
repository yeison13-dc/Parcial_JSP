package Modelo;

public class Banco {
    String ban_nit;
    String ban_nom;

    public Banco(){

    }

    public Banco(String ban_id, String ban_nom) {
        this.ban_nit = ban_id;
        this.ban_nom = ban_nom;
    }

    public String getBan_id() {
        return ban_nit;
    }

    public void setBan_id(String ban_id) {

        this.ban_nit = ban_id;
    }

    public String getBan_nom() {

        return ban_nom;
    }

    public void setBan_nom(String ban_nom) {

        this.ban_nom = ban_nom;
    }
}
