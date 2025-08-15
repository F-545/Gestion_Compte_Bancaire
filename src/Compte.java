import java.util.*;

public class Compte {

    private String typeCompte = "0";
    private String numeroCompte = "0";
    private double solde = 0;
    private Scanner keyb = new Scanner(System.in);
    private double pValcreditee = 0;
    private String numeroConsulte;
    private LigneComptable ligne;

    public String getTypeCompte() {
        return typeCompte;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    protected double getSolde() {
        return solde;
    }

    public Scanner getKeyb() {
        return keyb;
    }


    public double getpValcreditee() {
        return pValcreditee;
    }

    public String getNumeroConsulte() {
        return numeroConsulte;
    }

    public LigneComptable getLigne() {
        return ligne;
    }

    public void setLigne(LigneComptable element) {
        ligne = element;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setNumeroCompte(String numeroCompte){
        this.numeroCompte = numeroCompte;
    }


    public Compte() {
        typeCompte = controlType();
        keyb.nextLine();
        System.out.println("Numéro du compte:");
        numeroCompte = keyb.nextLine();
        pValcreditee = controlValInit();
    }

    public Compte(String typeCompte, String numeroCompte, double pValcreditee) {
        this.typeCompte = typeCompte;
        this.numeroCompte = numeroCompte;
        this.pValcreditee = pValcreditee;
    }

    public void afficherCpte() {
        System.out.println("Entrez le numéro du compte que vous souhaitez consulter:");
        keyb.nextLine();
        numeroConsulte = keyb.nextLine();
        if (numeroConsulte.equals(numeroCompte)) {
            System.out.println("Le compte de numéro: " + numeroCompte + " a pour :");
            System.out.println("Type:" + typeCompte);
            System.out.println("Valeur initiale: " + pValcreditee);

            if (ligne != null) {
                ligne.afficherLigneComptable(numeroConsulte);
            } else {
                System.out.println("Aucune ligne comptable associée.");
            }
        } else {
            System.out.println("Le numéro de compte est invalide.");
        }
    }

    public void creerLigne() {
        ligne = new LigneComptable();
        ligne.creerLigneComptable();

        if (ligne.getTypeOperation().equalsIgnoreCase("Débit")) {
            solde = pValcreditee - ligne.getMontant();
        } else if (ligne.getTypeOperation().equalsIgnoreCase("Crédit")) {
            solde = pValcreditee + ligne.getMontant();
        }
    }

    private String controlType() {
        char tmpc;
        String tmps = "";

        do {
            System.out.println("Type du compte ( Types possibles : C (Courant), J(Joint), E(Epargne)) :");
            tmpc = keyb.next().charAt(0);
        } while (tmpc != 'C' && tmpc != 'J' );
        switch (tmpc) {
            case 'C':
                tmps = "Courant";
                break;
            case 'J':
                tmps = "Joint";
                break;

        }
        return tmps;
    }

    private double controlValInit() {
        double valInit;
        do {
            System.out.println("Entrez la première valeur créditée:");
            valInit = keyb.nextDouble();
        } while (valInit < 0);
        return valInit;
    }
}



