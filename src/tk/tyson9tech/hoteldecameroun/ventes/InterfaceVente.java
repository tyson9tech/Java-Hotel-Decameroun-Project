/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.tyson9tech.hoteldecameroun.ventes;

/**
 *
 * @author tyson
 */
public interface InterfaceVente {
    
    //ENREGISTRER PLATS ET BOISSONS VENDUS
    public void enregistrer();
    
    //AFFICHER PLATS VENDUS
    public void afficherPlatVendus();
    
    //SUPPRIMER PLATS VENDUS
    public void supprimer();
    
    //AFFICHER MONTANT TOTATL PLATS VENDUS
    public void afficherPrix();
}
