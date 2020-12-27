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
public class Fournisseur {
    
    //ATTRIBUTS
    private int id;
    private String nom;
    private String prenom;
    private char sexe;
    private String adresse;
    private String telephone;
    private String email;
    
    //CONSTRUCTEURS
    public Fournisseur() {}
    public Fournisseur(int id, String nom, String prenom, char sexe,
            String adresse, String telephone, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }
    
    //ACCESSEURS
    public int getId() { return this.id; }
    public String getNom() { return this.nom; }
    public String getPrenom() { return this.prenom; }
    public char getSexe() { return this.sexe; }
    public String getAdresse() { return this.adresse; }
    public String getTelephone() { return this.telephone; }
    public String getEmail() { return this.email; }
    
    //MUTATEURS
    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setSexe(char sexe) { this.sexe = sexe; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public void setEmail(String email) { this.email = email; }
   
    //METHODES
    public String toString() {
        
        String sexe = (this.sexe == 'M')? "Masculin" : "Féminin";
        
        String fournisseursProduitInfos =
                  "\nId Fournisseur         : "+this.id
                + "\nNom Fournisseur        : "+this.nom
                + "\nPrenom Fournisseur     : "+this.prenom
                + "\nSexe Fournisseur       : "+sexe
                + "\nAdresse Fournisseur    : "+this.adresse
                + "\nTéléphone Fournisseur  : (+509) "+this.telephone
                + "\nE-mail Fournisseur     : "+this.email;
        return fournisseursProduitInfos;
    }
}
