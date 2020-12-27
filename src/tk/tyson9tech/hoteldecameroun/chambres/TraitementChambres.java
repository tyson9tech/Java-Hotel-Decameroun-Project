/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.tyson9tech.hoteldecameroun.chambres;

import java.util.ArrayList;
import java.util.Scanner;
import tk.tyson9tech.fonctions.Fonctions;

/**
 *
 * @author tyson
 */
public class TraitementChambres implements InterfaceChambre{
    
    Scanner inputText = new Scanner(System.in);
    Scanner inputNumerique = new Scanner(System.in);
    
    static ArrayList<Chambre> chambres = new ArrayList<Chambre>();
    Chambre chambre = new Chambre();
    
    
    //ENREGISTRER CHAMBRE
    public void enregistrer() {
        
        //Les type de chambres qui sont disponible
        ArrayList typeChambres = new ArrayList(){
            {
                add("simple");
                add("double");
                add("triple");
            }
        };
        
        
        
        //Récupération du type de la chambre
        String type;
        do {
            System.out.println("\nEntrer le type de la chambre : | Ex : Simple, Double, Triple : ");
            type = inputText.nextLine();
        } while (type == null || type.isEmpty() || !typeChambres.contains(type.toLowerCase()));
        chambre.setType(type);
        
        
        //Récupération du nom de la chambre
        do {
            System.out.println("\nEntrer le nom de la chambre : ");
            chambre.setNom(inputText.nextLine());
        } while ((chambre.getNom() == null) || (chambre.getNom().isEmpty()));
        
        
        //Récupération du prix de la chambre
        do {
            System.out.println("\nEntrer le prix : ");
            chambre.setPrixLocation(inputNumerique.nextDouble());
        } while (chambre.getPrixLocation() <= 0);
        
        
        //Génération de l'identifiant de la chambre
        Chambre nouvelleChambre;
        
        do {
            chambre.setId(Fonctions.generateCode(chambre.getNom(), chambre.getType(), chambres.size()));
            nouvelleChambre = new Chambre(chambre.getId(),chambre.getType(), chambre.getNom(), chambre.getPrixLocation());
        } while (chambres.contains(nouvelleChambre));
        
        
        //Ajout de la chambre dans la collection des chambres 
        chambres.add(nouvelleChambre);
    }
    
    
    
    //AFFICHER CHAMBRE
    public void afficher() {
        
        if (chambres.isEmpty()) {
            System.out.println("\nDesolé, Il n'y a aucune chambre disponible pour l'instant.");
        }else{
            for (Chambre chambre : chambres) {
                System.out.println(chambre.toString());
            }
        }
    }
    
    
    
    //MODIFIER CHAMBRE
    public void modifier() {
        
        String code;
        
        do {            
            System.out.println("\nEntrer le code de la chambre à modifier le prix : ");
            code = inputText.nextLine();
        } while ((code == null) || code.isEmpty());
        
        boolean chambreTrouve = false;
        
        for (Chambre chambre : chambres) {
            
            if (chambre.getId().equalsIgnoreCase(code)) {
                
                double nouveauPrix;
                        
                do {                    
                    System.out.println("\nEntrer le nouveau prix : ");
                    nouveauPrix = inputNumerique.nextDouble();
                } while (nouveauPrix <= 0);
                
                chambreTrouve = true;
                chambre.setPrixLocation(nouveauPrix);
                
                if (!(chambre.getType().equalsIgnoreCase("Simple"))) {
                    System.out.println("\nLe prix de location des chambres a été modifié avec succès.");
                }else{
                    System.out.println("\nLe prix de location de la chambre a été modifié avec succès.");
                }
            }
        }
        
        if (!chambreTrouve) {
            System.out.println("\nLe code de la chambre entré est incorrect.");
        }
    }
    
    
    
    //SUPPRIMER CHAMBRE 
    public void supprimer() {
        
        String code;
        
        do {            
            System.out.println("\nEntrer le code de la chambre à supprimer : ");
            code = inputText.nextLine();
        } while ((code == null) || code.isEmpty());
        
        boolean chambreTrouve = false;
        boolean chambreReservee = false;
        
        for (int i = 0; i < chambres.size(); i++) {
            
            if (chambre.getId().equalsIgnoreCase(code)) {
               
                chambreTrouve = true;
                
                if (chambres.get(i).isChambreReservee()) {
                    chambreReservee = true;
                }else{
                    chambreTrouve = true;
                
                    String message = (chambres.get(i).getType().equalsIgnoreCase("Simple"))?
                            "\nLa chambre a été supprimé avec succès.":
                            "\nLes chambres a été supprimé avec succès." ;

                    chambres.remove(chambres.indexOf(chambres.get(i)));

                    System.out.println(message);
                }
            }
        }
        
        if (chambreReservee) {
            System.out.println("\nDesolé, cette chambre est déjà réservée à quelqu'un, vous ne pouvez pas la supprimer.");
        }
        
        if (!chambreTrouve) {
            System.out.println("\nLe code de la chambre rentre est incorrect.");
        }
    }
    
    //Envoie de la collection des chambres
    public static ArrayList<Chambre> lesChambres(){
        return TraitementChambres.chambres;
    }
}
