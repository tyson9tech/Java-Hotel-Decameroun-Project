/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.tyson9tech.hoteldecameroun.chambres;

import java.text.DecimalFormat;

/**
 *
 * @author tyson
 */
public class Chambre {
    
    //ATTRIBUTS
    private String id;
    private String type;
    private String nom;
    private double prixLocation;
    
    private boolean chambreReservee;
    
    //CONSTRUCTEURS
    public Chambre() {}
    public Chambre(String id, String type, String nom, double prixLocation) {
        this.id = id;
        this.type = type;
        this.nom = nom;
        this.prixLocation = prixLocation;
        this.chambreReservee = false;
    }
    
    //ACCESSEURS
    public String getId() { return this.id; }
    public String getType() { return this.type; }
    public String getNom() {return this.nom; }
    public double getPrixLocation() { return this.prixLocation; }
    public boolean isChambreReservee() { return chambreReservee; }
    
    
    //MUTATEURS
    public void setId(String id) { this.id = id; }
    public void setType(String type) { this.type = type; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrixLocation(double prixLocation) { this.prixLocation = prixLocation; }
    public void setChambreReservee(boolean chambreReservee) { this.chambreReservee = chambreReservee; }
    

    //METHODES
    public String toString() {
        
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String statutLocation = (this.chambreReservee)? "Déjà Louée" : "Pas Encore Louée";
        
        String chambreInfos = ""
                + "\nID Chambre         :   "+this.id
                + "\nType Chambre       :   "+this.type
                + "\nNom Chambre        :   "+this.nom
                + "\nPrix Chambre       :   "+decimalFormat.format(this.prixLocation)+" HTG."
                + "\nStatut Location    :   "+statutLocation;
        
        return chambreInfos;
    }
}
