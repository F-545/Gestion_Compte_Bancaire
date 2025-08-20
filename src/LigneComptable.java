import java.util.Scanner;

public class LigneComptable {
    private String date = "0";
    private double montant = 0;
    private String modePaiement = "0";
    private String libelle = "0";
    private String numCompte = "0";
    private String typeOperation = "0";
    private Scanner keyboard = new Scanner(System.in);


    public String getDate(){
        return date;
    }
    public double getMontant(){
        return montant;
    }
    public String getMoyenPaiement(){
        return modePaiement;
    }
    public String getLibelle(){
        return libelle;
    }
    public String getNumCompte(){
        return numCompte;
    }
    public String getTypeOperation(){
        return typeOperation;
    }

    public LigneComptable(){

        System.out.println("Numéro du compte concerné:");
        numCompte = keyboard.nextLine();

        System.out.println("Date de l'opération:");
        date = keyboard.nextLine();

        libelle = controlMotif();

        System.out.println("Montant de l'opération:");
        while (!keyboard.hasNextDouble()) {
            System.out.println("Montant invalide. Reprends :");
            keyboard.nextLine();
        }
        montant = keyboard.nextDouble();
        keyboard.nextLine();

        modePaiement = controlMode();

        System.out.println("Type d'opération ( Débit ou Crédit.)");
        typeOperation = keyboard.nextLine();


    }

    public void afficherLigneComptable(String numcompteConsultee){
            System.out.println("Compte:"+numcompteConsultee);
            System.out.println("Date de l'opération: "+date);
            System.out.println("Libellé de l'opération: "+libelle);
            System.out.println("Montant de l'opération :"+montant);
            System.out.println("Mode de paiement: "+modePaiement);
            System.out.println("Type de l'opération: "+typeOperation);

        }

    private String controlMotif(){
            char tmpc;
            String tmps ="";

            do {
                System.out.println("Libellé de l'opération ( S (Salaire), L(Loyer), A(Alimentation), D(Divers) :");
                tmpc = keyboard.next().charAt(0);
            } while (tmpc != 'S' && tmpc != 'L' && tmpc != 'A' && tmpc != 'D');
            switch (tmpc){
                case 'S' : tmps = "Salaire";
                    break;
                case 'L' : tmps = "Loyer";
                    break;
                case 'A' : tmps = "Alimentation";
                    break;
                case 'D' : tmps = "Divers";
            }
            return tmps;
    }

    private String controlMode(){
            String tmps ="";

            do {
                System.out.println("Mode de paiement ( CB (Carte Bancaire), VB (Virement Bancaire), C (Chèque)) :");
                tmps = keyboard.nextLine();
            } while (!tmps.equals("CB") && !tmps.equals("VB") && !tmps.equals("C"));
            return tmps;
        }
    }





