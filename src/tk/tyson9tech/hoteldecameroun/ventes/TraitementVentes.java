/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.tyson9tech.hoteldecameroun.ventes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tyson
 */
public class TraitementVentes implements InterfaceVente{

    Scanner inputNumerique = new Scanner(System.in);
    Scanner inputText = new Scanner(System.in);
    
    ArrayList<Vente> ventes = new ArrayList<Vente>();
    Vente vente = new Vente();
    
    
    //ENREGISTRER PLATS ET BOISSONS VENDUS
    public void enregistrer() {
        
        //Récupération du nom du plat choisi
        do {            
            System.out.println("\nEntrer le nom du plat choisi : ");
            vente.setPlatChoisi(inputText.nextLine());
        } while (vente.getPlatChoisi() == null || vente.getPlatChoisi().isEmpty());
        
        //Récupération de la quantité de plats choisis
        do {            
            System.out.println("\nEntrer la quantité de plats choisis : ");
            vente.setQuantitePlat(inputNumerique.nextInt());
        } while (vente.getQuantitePlat() <= 0);
        
        //Récupération du prix unitaire du plat choisi
        do {            
            System.out.println("\nEntrer le prix unitaire du plat choisi : ");
            vente.setPrixUnitairePlat(inputNumerique.nextDouble());
        } while (vente.getPrixUnitairePlat() <= 0);
        
        
        //Récupération du nom du boisson choisi
        do {            
            System.out.println("\nEntrer le nom du boisson choisi : ");
            vente.setBoissonChoisi(inputText.nextLine());
        } while (vente.getBoissonChoisi() == null || vente.getBoissonChoisi().isEmpty());
        
        //Récupération de la quantité de boissons choisis
        do {            
            System.out.println("\nEntrer la quantité de boissons choisis : ");
            vente.setQuantiteBoisson(inputNumerique.nextInt());
        } while (vente.getQuantiteBoisson() <= 0);
        
        //Récupération du prix unitaire du boisson choisi
        do {            
            System.out.println("\nEntrer le prix unitaire du boisson choisi : ");
            vente.setPrixUnitaireBoisson(inputNumerique.nextDouble());
        } while (vente.getPrixUnitaireBoisson() <= 0);
        
        
        //Génération de l'indetifiant de la vente
        vente.setCodeVente((int) (Math.random() * 999999) + 100000);
        
        
        //Ajout de la vente à la collection
        ventes.add(new Vente(vente.getCodeVente(),
                             vente.getPlatChoisi(),
                             vente.getQuantitePlat(),
                             vente.getPrixUnitairePlat(),
                             vente.getBoissonChoisi(),
                             vente.getQuantiteBoisson(),
                             vente.getPrixUnitaireBoisson()
        ));
    }

    //AFFICHER PLATS VENDUS
    public void afficherPlatVendus() {
        if (ventes.isEmpty()) {
            System.out.println("\nIl n'y a aucun vente enregistrer pour l'instant.");
        }else{
            for (Vente vente : ventes) {
                System.out.println(vente.toString());
            }
        }
    }

    //SUPPRIMER PLATS VENDUS
    public void supprimer() {
        
        if (ventes.isEmpty()) {
            System.out.println("\nIl n'y a aucun vente enregistrer pour l'instant.");
        }else{
            int codeVente;
        
            do {            
                System.out.println("\nEntrer le code du plat à supprimer : ");
                codeVente = inputNumerique.nextInt();
            } while (codeVente <= 0);

            boolean chambreTrouve = false;

            for (int i = 0; i < ventes.size(); i++) {
                if (ventes.get(i).getCodeVente() == codeVente) {
                    chambreTrouve = true;
                    ventes.remove(ventes.get(i));
                    System.out.println("\nLe plat a été supprimé avec succès.");
                }
            }

            if (!chambreTrouve) {
                System.out.println("\nLe code du plat entré est incorrect.");
            }
        }
    }

    //AFFICHER MONTANT TOTATL PLATS VENDUS
    public void afficherPrix() {
        if (ventes.isEmpty()) {
            System.out.println("\nIl n'y a aucun vente enregistrer pour l'instant.");
        }else{
            double prixPlatsVendus = 0;
            double prixBoissonsVendus = 0;
            
            for (Vente vente : ventes) {
                prixPlatsVendus += vente.getPrixUnitairePlat() * vente.getQuantitePlat();
                prixBoissonsVendus += vente.getPrixUnitaireBoisson() * vente.getQuantiteBoisson();
            }
            
            double prixTotalPlats = prixPlatsVendus + prixBoissonsVendus;
            
            System.out.println("\nLe montant total des plats vendus est : "+prixTotalPlats);
        }
    }
}
