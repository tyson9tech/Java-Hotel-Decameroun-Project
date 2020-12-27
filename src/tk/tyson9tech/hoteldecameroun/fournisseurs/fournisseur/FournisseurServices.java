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
public class FournisseurServices extends Fournisseur{
    
    //ATTRIBUTS
    private String services;

    //CONSTRUCTEURS
    public FournisseurServices() { super(); }
    public FournisseurServices(int id, String nom, String prenom, char sexe,
            String adresse, String telephone, String email, String services) {
        super(id, nom, prenom, sexe, adresse, telephone, email);
        this.services = services;
    }

    //ACCESSEURS
    public String getServices() { return services; }
    
    //MUTATEUR
    public void setServices(String services) { this.services = services; }
    
    //METHODES
    public String toString() {
        return super.toString()
                + "\nServices Fournis       : "+this.services;
    }
}
