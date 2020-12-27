/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.tyson9tech.hoteldecameroun.reservations;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import tk.tyson9tech.hoteldecameroun.chambres.TraitementChambres;

/**
 *
 * @author tyson
 */
public class TraitementReservations implements InterfaceReservation{

    Scanner inputText = new Scanner(System.in);
    Scanner inputNumerique = new Scanner(System.in);
    ArrayList<Reservation> reservationsChambres = new ArrayList<Reservation>();
    Reservation reservationsChambre = new Reservation();
    int numReservation = 0;

    public TraitementReservations() {}
    
    //ENREGISTRER RESERVATION
    public void enregistrer() {
        
        //Vérifier s'il existe des chambres dans la collection des chambres
        if (TraitementChambres.lesChambres().isEmpty()) {
            System.out.println("\nDesole, Il n'y a aucune chambre disponible pour l'instant.");
        }else{
            
            //Vérifier si les chambres dans la collection sont disponible pour pouvoir faire la réservation
            boolean chambreDisponible = false;

            for(int i = 0; i <TraitementChambres.lesChambres().size(); i++){
                if (!TraitementChambres.lesChambres().get(i).isChambreReservee()) {
                    reservationsChambre.setNumChambreChoisi(TraitementChambres.lesChambres().get(i).getId());
                    chambreDisponible = true;
                }
            }


            if (!chambreDisponible) {
                System.out.println("\nDesolé, il n'y a plus de chambre disponible."); 
            }else{

                //Sexe 
                ArrayList sexes = new ArrayList(){
                    {
                        add('M');
                        add('F');
                    }
                };
                


                //Récuperation du nom du client
                do {            
                    System.out.println("\nEntrer le nom du client : ");
                    reservationsChambre.setNomClient(inputText.nextLine());
                } while ((reservationsChambre.getNomClient() == null) || (reservationsChambre.getNomClient().isEmpty()));

                //Récuperation du prenom du client
                do {            
                    System.out.println("\nEntrer le prenom du client : ");
                    reservationsChambre.setPrenomClient(inputText.nextLine());
                } while ((reservationsChambre.getPrenomClient() == null) || (reservationsChambre.getPrenomClient().isEmpty()));

                //Récuperation du sexe du client
                do {            
                    System.out.println("\nEntrer le sexe du client : ");
                    reservationsChambre.setSexe(inputText.nextLine().toUpperCase().charAt(0));
                } while ( !(sexes.contains(reservationsChambre.getSexe())));

                //Récuperation de l'adresse du client
                do {            
                    System.out.println("\nEntrer l'adresse du client : ");
                    reservationsChambre.setAdresse(inputText.nextLine());
                } while ((reservationsChambre.getAdresse()== null) || (reservationsChambre.getAdresse().isEmpty()));

                //Récuperation du numéro de téléphone du client
                do {            
                    System.out.println("\nEntrer le numéro de téléphone du client : ");
                    reservationsChambre.setTelephone(inputText.nextLine());
                } while ((reservationsChambre.getTelephone() == null) || (reservationsChambre.getTelephone().isEmpty()));

                //Récuperation de l'e-mail du client
                do {            
                    System.out.println("\nEntrer l'e-mail du client : ");
                    reservationsChambre.setEmail(inputText.nextLine());
                } while ((reservationsChambre.getEmail() == null) || (reservationsChambre.getEmail().isEmpty()));


                //Récuperation de la dâte de la rentrée du client
                do {            
                    System.out.println("\nEntrer la dâte de la rentrée du client : ");
                    reservationsChambre.setDateRentree(inputText.nextLine());
                } while ((reservationsChambre.getDateRentree() == null) || (reservationsChambre.getDateRentree().isEmpty()));

                //Récuperation de la durée du séjour du client
                do {            
                    System.out.println("\nEntrer la durée du séjour du client : ");
                    reservationsChambre.setDureeSejour(inputNumerique.nextInt());
                } while (reservationsChambre.getDureeSejour() <= 0);
                
                //Génération de l'indentifiant du client
                Reservation nouvelleReservation;
                
                do {            
                        reservationsChambre.setCode(
                                    reservationsChambre.getNomClient().substring(0, 1).toUpperCase()+
                                    reservationsChambre.getPrenomClient().substring(0, 1).toUpperCase()+"-"
                                    +(reservationsChambres.size() + (int) (Math.random() * 999) + 1000)
                        );
                        
                        nouvelleReservation = new Reservation(
                                reservationsChambre.getCode(),
                                reservationsChambre.getNomClient(),
                                reservationsChambre.getPrenomClient(),
                                reservationsChambre.getSexe(),
                                reservationsChambre.getAdresse(),
                                reservationsChambre.getTelephone(),
                                reservationsChambre.getEmail(),
                                reservationsChambre.getNumChambreChoisi(),
                                reservationsChambre.getDateRentree(),
                                reservationsChambre.getDureeSejour()
                            );
                        
                } while (reservationsChambres.contains(nouvelleReservation));
                
                //La réservation est faite dans la collection des chambres
                for(int i = 0; i <TraitementChambres.lesChambres().size(); i++){
                    if (TraitementChambres.lesChambres().get(i).getId().equals(reservationsChambre.getNumChambreChoisi())) {
                        TraitementChambres.lesChambres().get(i).setChambreReservee(true);
                    }
                }

                //Ajout d'une reservation à la collection
                reservationsChambres.add(nouvelleReservation);
            }
        }
    }
    
    
    //AFFICHER RESERVATION
    public void afficher() {
        if (reservationsChambres.isEmpty()) {
            System.out.println("\nDesolé! Il n'y aucune réservation faite pour l'instant.");
        }else{
            for (Reservation reservationsChambre : reservationsChambres) {
                System.out.println(reservationsChambre.toString());
            }
        }
    }
    
    
    //MODIFIER RESERVATION
    public void modifier() {
        
        String code;
        
        do {            
            System.out.println("\nEntrer le code de la reservation a modifier la durée du séjour : ");
            code = inputText.nextLine();
        } while ((code == null) || code.isEmpty());
        
        boolean reservationTrouvee = false;
        
        for (Reservation reservation : reservationsChambres) {
            
            if (reservation.getCode().equals(code) ) {
                
                int nouvelleDuree;
                        
                do {                    
                    System.out.println("\nEntrer la nouvelle durée du séjour : ");
                    nouvelleDuree = inputNumerique.nextInt();
                } while (nouvelleDuree <= 0);
                
                reservationTrouvee = true;
                
                reservation.setDureeSejour(nouvelleDuree);
                
                System.out.println("\nLa durée du séjour de la location des chambres à été modifie avec succes.");
            }
        }
    }
    
    //RECHERCHER RESERVATION
    public void rechercher() {
        String code;
        
        do {            
            System.out.println("\nEntrer le code de la reservation à rechercher : ");
            code = inputText.nextLine();
        } while ((code == null) || code.isEmpty());
        
        boolean reservationTrouvee = false;
        
        for (Reservation reservation : reservationsChambres) {
            
            if (reservation.getCode().equals(code)) {
                reservationTrouvee = true;
                System.out.println(reservation.toString());
            }
        }
    }
    
    
    //AFFICHER PRIX RESERVATION
    public void afficherPrix() {
        if (reservationsChambres.isEmpty()) {
            System.out.println("\nDesolé! Il n'y a aucune chambre louée pour l'instant.");
        }else{
            
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            double montantTotalReservations = 0;
            
            for (int i = 0; i < TraitementChambres.lesChambres().size(); i++) {
                for (int j = 0; j < reservationsChambres.size(); j++) {
                    if (TraitementChambres.lesChambres().get(i).getId().equals(reservationsChambres.get(j).getNumChambreChoisi())){
                        montantTotalReservations += (
                                TraitementChambres.lesChambres().get(i).getPrixLocation() * reservationsChambres.get(j).getDureeSejour()
                        );
                    }
                }
            }
            
            System.out.println("\nLe montant total des réservations effectuées est : "+decimalFormat.format(montantTotalReservations)+" HTG.");
        }
    }
}
