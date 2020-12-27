/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.tyson9tech.hoteldecameroun.fournisseurs;

import java.util.ArrayList;
import java.util.Scanner;
import tk.tyson9tech.hoteldecameroun.fournisseurs.fournisseur.Fournisseur;
import tk.tyson9tech.hoteldecameroun.fournisseurs.fournisseur.FournisseurProduits;
import tk.tyson9tech.hoteldecameroun.fournisseurs.fournisseur.FournisseurServices;

/**
 *
 * @author tyson
 */
public class TraitementFournisseurs implements InterfaceFournisseur{

    Scanner inputText = new Scanner(System.in);
    Scanner inputNumerique = new Scanner(System.in);
    ArrayList<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
    Fournisseur fournisseur = new Fournisseur();
    
    //ENREGISTRER FOURNISSEUR
    public void enregistrer() {
        
        //Récupération du nom du fournisseur
        do {            
            System.out.println("\nEntrer le nom du fournisseur : ");
            fournisseur.setNom(inputText.nextLine());
        } while ((fournisseur.getNom() == null) || (fournisseur.getNom().isEmpty()));
        
        //Récupération du prenom du fournisseur
        do {            
            System.out.println("\nEntrer le prenom du fournisseur : ");
            fournisseur.setPrenom(inputText.nextLine());
        } while ((fournisseur.getPrenom() == null) || (fournisseur.getPrenom().isEmpty()));
        
        //Récupération du sexe du fournisseur
        do {            
            System.out.println("\nEntrer le sexe du fournisseur : ");
            fournisseur.setSexe(inputText.nextLine().toUpperCase().charAt(0));
            
            System.out.println("\n -> "+(fournisseur.getSexe() == 'M')+"\n");
        } while ((fournisseur.getSexe() == 'M') && (fournisseur.getSexe() == 'F'));
        
        //Récupération de l'adresse du fournisseur
        do {            
            System.out.println("\nEntrer l'adresse du fournisseur : ");
            fournisseur.setAdresse(inputText.nextLine());
        } while ((fournisseur.getAdresse() == null) || (fournisseur.getAdresse().isEmpty()));
        
        //Récupération du numéro de téléphone du fournisseur
        do {            
            System.out.println("\nEntrer le numéro de téléphone du fournisseur : ");
            fournisseur.setTelephone(inputText.nextLine());
        } while ((fournisseur.getTelephone() == null) || (fournisseur.getTelephone().isEmpty()));
        
        //Récupération de l'e-mail du fournisseur
        do {            
            System.out.println("\nEntrer l'e-mail du fournisseur : ");
            fournisseur.setEmail(inputText.nextLine());
        } while ((fournisseur.getEmail() == null) || (fournisseur.getEmail().isEmpty()));
        
        //Récupération de type du fournisseur
        char typeFournisseur;
        
        do {
            System.out.println("\nType Fournisseur : | Ex : taper |S| pour services, et |P| Produits : ");
            typeFournisseur = inputText.nextLine().toUpperCase().charAt(0);
        } while ((typeFournisseur != 'S') && (typeFournisseur != 'P'));
        
        if (typeFournisseur == 'P') {
            FournisseurProduits fournisseurProduit;
            
            //Récupération des produits du fournisseur
            do {            
                System.out.println("\nEntrer les produits fournis par le fournisseur : ");
                fournisseurProduit = (FournisseurProduits) fournisseur;
                
                fournisseurProduit.setProduits(inputText.nextLine());
            } while ((fournisseurProduit.getProduits() == null) || (fournisseurProduit.getProduits().isEmpty()));
            
            fournisseur = fournisseurProduit;
        }else{
            FournisseurServices fournisseurServices;
            
            //Récupération des services du fournisseur
            do {            
                System.out.println("\nEntrer les services fournis par le fournisseur  : ");
                fournisseurServices = (FournisseurServices) fournisseur;
                fournisseurServices.setServices(inputText.nextLine());
            } while ((fournisseurServices.getNom() == null) || (fournisseurServices.getAdresse().isEmpty()));
            
            fournisseur = fournisseurServices;
        }
        
        //Génération de l'identifiant du fournisseur
        fournisseur.setId((int) (Math.random() * 999999) + 100000); 
    }

    //MODIFIER FOURNISSEUR
    public void modifier() {
        
        if (fournisseurs.isEmpty()) {
            System.out.println("\nDesolé! Il n'y aucun fournisseur enregistrer pour l'instant.");
        }else{
            
            int code;
            boolean fournisseurTrouve = false;
            
            do {                
                System.out.println("\nEntrer le code du fournisseur à modifer les produits ou services : ");
                code = inputNumerique.nextInt();
            } while (code <= 0);
            
            String nouveauxSerOuProd;
            
            for (Fournisseur fournisseur : fournisseurs) {
                if (fournisseur.getId() == code) {
                    
                    fournisseurTrouve = true;
                    
                    if (fournisseur instanceof FournisseurProduits) {
                        do {                            
                            System.out.println("\nEntrer les nouveaux produits fournis par le fournisseur : ");
                            nouveauxSerOuProd = inputText.nextLine();
                        } while ((nouveauxSerOuProd == null) || (nouveauxSerOuProd.isEmpty()));
                        
                        ((FournisseurProduits) fournisseur).setProduits(nouveauxSerOuProd);
                        
                    }else if (fournisseur instanceof FournisseurServices) {
                        do {                            
                            System.out.println("\nEntrer les nouveaux services fournis par le fournisseur : ");
                            nouveauxSerOuProd = inputText.nextLine();
                        } while ((nouveauxSerOuProd == null) || (nouveauxSerOuProd.isEmpty()));
                        
                        ((FournisseurServices) fournisseur).setServices(nouveauxSerOuProd);
                    }
                }
            }
            
            if (!fournisseurTrouve) {
                System.out.println("\nDesolé! Le code du fournisseur entré est incorrect.");
            }
        }
    }

    //AFFICHER FOURNISSEUR
    public void afficher() {
        if (fournisseurs.isEmpty()) {
            System.out.println("\nDesolé! Il n'y aucun fournisseur enregistrer pour l'instant.");
        }else{
            for (Fournisseur fournisseur : fournisseurs) {
                System.out.println(fournisseur.toString());
            }
        }
    }

    //SUPPRIMER FOURNISSEUR
    public void supprimer() {
        if (fournisseurs.isEmpty()) {
            System.out.println("\nDesolé! Il n'y aucun fournisseur enregistrer pour l'instant.");
        }else{
            
            int code;
            boolean fournisseurTrouve = false;
            
            do {                
                System.out.println("\nEntrer le code du fournisseur à supprimer : ");
                code = inputNumerique.nextInt();
            } while (code <= 0);
            
            for (int i = 0; i < fournisseurs.size(); i++) {
                if (fournisseurs.get(i).getId() == code) {
                    fournisseurTrouve = true;
                    fournisseurs.remove(fournisseurs.get(i));
                    
                    System.out.println("\nLe fournisseur a été supprimé avec succès.");
                }
            }
            
            if (!fournisseurTrouve) {
                System.out.println("\nDesolé! Le code du fournisseur entré est incorrect.");
            }
        }
    }
}
