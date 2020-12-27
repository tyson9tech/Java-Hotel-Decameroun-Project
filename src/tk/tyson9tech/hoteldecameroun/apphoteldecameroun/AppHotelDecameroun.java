/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.tyson9tech.hoteldecameroun.apphoteldecameroun;

import java.util.Scanner;
import tk.tyson9tech.hoteldecameroun.chambres.TraitementChambres;
import tk.tyson9tech.hoteldecameroun.fournisseurs.TraitementFournisseurs;
import tk.tyson9tech.hoteldecameroun.reservations.TraitementReservations;
import tk.tyson9tech.hoteldecameroun.ventes.TraitementVentes;

/**
 *
 * @author tyson
 */
public class AppHotelDecameroun {
    
    public static void main(String[] args) {
        
        Scanner inputText = new Scanner(System.in);
        Scanner inputNumerique = new Scanner(System.in);
        
        TraitementChambres traitementChambres = new TraitementChambres();
        TraitementReservations traitementReservationsChambres = new TraitementReservations();
        TraitementFournisseurs traitementFournisseurs = new TraitementFournisseurs();
        TraitementVentes traitementVentes = new TraitementVentes();
        
        
        int choixMenuPricipal;
        char choixSousMenu;
        
        do {
            System.out.println("\n------------------Menu Principal------------------".toUpperCase());
            System.out.println("1 - Gestion des chambres.");
            System.out.println("2 - Gestion de réservation des chambres.");
            System.out.println("3 - Gestion des fournisseurs de produits.");
            System.out.println("4 - Gestion de la vente des plats et boissons.");
            System.out.println("5 - Quiter");

            System.out.print("\nChoix : ");
            choixMenuPricipal = inputNumerique.nextInt();

            switch(choixMenuPricipal){
                
                
                //GESTION DES CHAMBRES
                case 1 :
                        do {
                            System.out.println("\n------------------Gestion des chambres------------------".toUpperCase());
                            System.out.println("a) Enregistrer un chambre.");
                            System.out.println("b) Afficher toutes les chambres.");
                            System.out.println("c) Modifier le prix de location d’une chambre.");
                            System.out.println("d) Supprimer une chambre.");
                            System.out.println("e) Retour.");

                            System.out.print("\nChoix : ");
                            choixSousMenu = inputText.nextLine().charAt(0);

                            switch(choixSousMenu){

                                case 'a' : traitementChambres.enregistrer(); break;

                                case 'b' : traitementChambres.afficher(); break;

                                case 'c' : traitementChambres.modifier(); break;

                                case 'd' : traitementChambres.supprimer(); break;

                                case 'e' : break;

                                default : System.out.println("\nMauvais choix!\n"); break;
                            }
                        } while (choixSousMenu != 'e');
                    break;
                    
                    
                //GESTION DE RESERVATIONS DE CHAMBRES
                case 2 :
                        do {
                            System.out.println("\n------------------Gestion de réservation des chambres------------------".toUpperCase());
                            System.out.println("a) Enregistrer une réservation.");
                            System.out.println("b) Afficher la liste des réservations.");
                            System.out.println("c) Modifier la durée d’une réservation.");
                            System.out.println("d) Rechercher une réservation dans la collection.");
                            System.out.println("e) Afficher le montant total des réservations effectuées.");
                            System.out.println("f) Retour.");
                            
                            System.out.print("\nChoix : ");
                            choixSousMenu = inputText.nextLine().charAt(0);

                                switch(choixSousMenu){

                                    case 'a' : traitementReservationsChambres.enregistrer(); break;

                                    case 'b' : traitementReservationsChambres.afficher(); break;

                                    case 'c' : traitementReservationsChambres.modifier(); break;

                                    case 'd' : traitementReservationsChambres.rechercher(); break;

                                    case 'e' : traitementReservationsChambres.afficherPrix(); break;
                                    
                                    case 'f' :break;

                                    default : System.out.println("\nMauvais choix!\n"); break;
                                }
                        } while (choixSousMenu != 'f');
                    break;
                    
                    
                //GESTION DES FOURNISSEURS DE PRODUITS
                case 3 :
                        do {
                            System.out.println("\n------------------Gestion des fournisseurs de produits------------------".toUpperCase());
                            System.out.println("a) Enregistrer fournisseur.");
                            System.out.println("b) Modifier produits ou services d’un fournisseur.");
                            System.out.println("c) Afficher la lister des fournisseurs.");
                            System.out.println("d) Supprimer un fournisseur.");
                            System.out.println("e) Retour.");
                            
                            System.out.print("\nChoix : ");
                            choixSousMenu = inputText.nextLine().charAt(0);

                                switch(choixSousMenu){

                                    case 'a' : traitementFournisseurs.enregistrer(); break;

                                    case 'b' : traitementFournisseurs.modifier(); break;

                                    case 'c' : traitementFournisseurs.afficher();break;

                                    case 'd' : traitementFournisseurs.supprimer(); break;

                                    case 'e' : break;

                                    default : System.out.println("\nMauvais choix!\n"); break;
                                }
                        } while (choixSousMenu != 'e');
                    break;
                    
                    
                //GESTION DES PLATS ET BOISSONS
                case 4 :
                        do {
                            System.out.println("\n------------------Gestion de la vente des plats et boissons------------------".toUpperCase());
                            System.out.println("a) Enregistrer les plats vendus et boissons.");
                            System.out.println("b) Afficher la liste des plats vendus.");
                            System.out.println("c) Supprimer un plat.");
                            System.out.println("d) Afficher le montant total des plats vendus.");
                            System.out.println("e) Retour.");
                            
                            System.out.print("\nChoix : ");
                            choixSousMenu = inputText.nextLine().charAt(0);

                                switch(choixSousMenu){

                                    case 'a' : traitementVentes.enregistrer(); break;

                                    case 'b' : traitementVentes.afficherPlatVendus(); break;

                                    case 'c' : traitementVentes.supprimer(); break;

                                    case 'd' : traitementVentes.afficherPrix(); break;

                                    case 'e' : break;

                                    default : System.out.println("\nMauvais choix!\n"); break;
                                }
                        } while (choixSousMenu != 'e');
                break;
                
                
                case 5 : System.out.println("\nAu revoir!\n"); System.exit(0); break;
                
                
                default : System.out.println("\nMauvais choix!\n"); break;
            }
        } while (choixMenuPricipal != 5);
    }
}
