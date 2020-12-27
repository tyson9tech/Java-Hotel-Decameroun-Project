/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.tyson9tech.hoteldecameroun.ventes;

import java.text.DecimalFormat;

/**
 *
 * @author tyson
 */
public class Vente {
    
    //ATTRIBUTS
    private int codeVente;
    private String platChoisi;
    private int quantitePlat;
    private double prixUnitairePlat;
    private String boissonChoisi;
    private int quantiteBoisson;
    private double prixUnitaireBoisson;
    
    //CONSTRUCTEURS
    public Vente() {}
    public Vente(int codeVente, String platChoisi, int quantitePlat, double prixUnitairePlat,
            String boissonChoisi, int quantiteBoisson, double prixUnitaireBoisson) {
        this.codeVente = codeVente;
        this.platChoisi = platChoisi;
        this.quantitePlat = quantitePlat;
        this.prixUnitairePlat = prixUnitairePlat;
        this.boissonChoisi = boissonChoisi;
        this.quantiteBoisson = quantiteBoisson;
        this.prixUnitaireBoisson = prixUnitaireBoisson;
    }
    
    //ACCESSEURS
    public int getCodeVente() { return codeVente; }
    public String getPlatChoisi() { return platChoisi; }
    public int getQuantitePlat() { return quantitePlat; }
    public double getPrixUnitairePlat() { return prixUnitairePlat; }
    public String getBoissonChoisi() { return boissonChoisi; }
    public int getQuantiteBoisson() { return quantiteBoisson; }
    public double getPrixUnitaireBoisson() { return prixUnitaireBoisson; }    
    
    //MUTATEURS
    public void setCodeVente(int codeVente) { this.codeVente = codeVente; }
    public void setPlatChoisi(String platChoisi) { this.platChoisi = platChoisi; }
    public void setQuantitePlat(int quantitePlat) { this.quantitePlat = quantitePlat; }
    public void setPrixUnitairePlat(double prixUnitairePlat) { this.prixUnitairePlat = prixUnitairePlat; }
    public void setBoissonChoisi(String boissonChoisi) { this.boissonChoisi = boissonChoisi; }
    public void setQuantiteBoisson(int quantiteBoisson) { this.quantiteBoisson = quantiteBoisson; }
    public void setPrixUnitaireBoisson(double prixUnitaireBoisson) { this.prixUnitaireBoisson = prixUnitaireBoisson; }    
    
    //METHODES
    public String toString() {
        
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
                
        String venteInfos = ("\nCode Vente              : "+this.codeVente
                            + "\nPlat Choisi            : "+this.platChoisi
                            + "\nQuantité Plat          : "+this.quantitePlat
                            + "\nPrix Unitaire Plat     : "+decimalFormat.format(this.prixUnitairePlat)
                            + "\nBoisson Choisi         : "+this.boissonChoisi
                            + "\nQuantité Boisson       : "+this.quantiteBoisson
                            + "\nPrix Unitaire Boisson  : "+decimalFormat.format(this.prixUnitaireBoisson)
                            );
        return venteInfos;
    }
}
