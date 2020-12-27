/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.tyson9tech.hoteldecameroun.reservations;

/**
 *
 * @author tyson
 */
public class Reservation {
    
    //ATTRIBUTS
    private String code;
    private String nomClient;
    private String prenomClient;
    private char sexe;
    private String adresse;
    private String telephone;
    private String email;
    private String numChambreChoisi;
    private String dateRentree;
    private int dureeSejour;

    //CONSTRUCTEURS
    public Reservation() {}
    public Reservation(
            String code, String nomClient, String prenomClient,
            char sexe, String adresse, String telephone,
            String email, String numChambreChoisi,
            String dateRentree, int dureeSejour
    ) {
        this.code = code;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.sexe = sexe;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.numChambreChoisi = numChambreChoisi;
        this.dateRentree = dateRentree;
        this.dureeSejour = dureeSejour;
    }

    //ACCESSEURS
    public String getCode() { return this.code; }
    public String getNomClient() { return this.nomClient; }
    public String getPrenomClient() { return this.prenomClient; }
    public char getSexe() { return this.sexe; }
    public String getAdresse() { return this.adresse; }
    public String getTelephone() { return this.telephone; }
    public String getEmail() { return this.email; }
    public String getNumChambreChoisi() { return this.numChambreChoisi; }
    public String getDateRentree() { return this.dateRentree; }
    public int getDureeSejour() { return this.dureeSejour; }
    
    //MUTATEURS
    public void setCode(String code) { this.code = code; }
    public void setNomClient(String nomClient) { this.nomClient = nomClient; }
    public void setPrenomClient(String prenomClient) { this.prenomClient = prenomClient; }
    public void setSexe(char sexe) { this.sexe = sexe; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public void setEmail(String email) { this.email = email; }
    public void setNumChambreChoisi(String numChambreChoisi) { this.numChambreChoisi = numChambreChoisi; }
    public void setDateRentree(String dateRentree) { this.dateRentree = dateRentree; }
    public void setDureeSejour(int dureeSejour) { this.dureeSejour = dureeSejour; }
   
    //METHODES
    public String toString(){
        
        String sexe = (this.sexe == 'M')? "Masculin" : "Féminin";
                
        String reservationChambreInfos = ""
                + "\nCode Reservation   : "+this.code
                + "\nNom Client         : "+this.nomClient
                + "\nPrenom Client      : "+this.prenomClient
                + "\nSexe Client        : "+sexe
                + "\nAdresse Client     : "+this.adresse
                + "\nTéléphone Client   : (+509) "+this.telephone
                + "\nE-mail Client      : "+this.email
                + "\nNuméro Chambre     : "+this.numChambreChoisi
                + "\nDate Rentrée       : "+this.dateRentree
                + "\nDurée Séjour       : "+this.dureeSejour;
        return reservationChambreInfos;
    }
}
