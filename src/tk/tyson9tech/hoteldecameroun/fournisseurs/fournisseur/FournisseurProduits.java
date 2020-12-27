/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.tyson9tech.hoteldecameroun.fournisseurs.fournisseur;

/**
 *
 * @author tyson
 */
public class FournisseurProduits extends Fournisseur {
    
    //ATTRIBUTS
    private String produits;

    //CONSTRUCTEURS
    public FournisseurProduits() { super(); }
    public FournisseurProduits(int id, String nom, String prenom, char sexe,
            String adresse, String telephone, String email, String produits) {
        super(id, nom, prenom, sexe, adresse, telephone, email);
        this.produits = produits;
    }

    //ACCESSEURS
    public String getProduits() { return this.produits; }
    
    //MUTATEUR
    public void setProduits(String services) { this.produits = services; }
    
    //METHODES
    public String toString() {
        return super.toString()
                + "\nProduits Fournis       : "+this.produits;
    }
}
