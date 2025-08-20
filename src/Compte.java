import java.util.*;

public class Compte {

    private String typeCompte = "0";
    private String numeroCompte = "0";
    private double solde = 0;
    private Scanner keyb = new Scanner(System.in);
    private double pValcreditee = 0;
    private String numeroConsulte;

    public static final int NBLigne = 10;
    private LigneComptable [] ligne;
    private int NBLigneReel;

    public String getTypeCompte() { return typeCompte; }
    public String getNumeroCompte() { return numeroCompte; }
    protected double getSolde() { return solde; }
    public double getpValcreditee() { return pValcreditee; }
    public String getNumeroConsulte() { return numeroConsulte; }
    public int getNBLigneReel() { return NBLigneReel; }
    public void setNBLigneReel(int NBLigneReel) { this.NBLigneReel = NBLigneReel; }
    public void setSolde(double solde) { this.solde = solde; }
    public void setNumeroCompte(String numeroCompte){ this.numeroCompte = numeroCompte; }

    public LigneComptable[] getLigne() { return ligne; }
    public void setLigne(LigneComptable[] ligne) { this.ligne = ligne; }

    public Compte() {
        ligne = new LigneComptable[NBLigne];
        NBLigneReel = -1;
        typeCompte = controlType();
        keyb.nextLine();
        System.out.println("Numéro du compte:");
        numeroCompte = keyb.nextLine();
        pValcreditee = controlValInit();
        solde = pValcreditee;
    }

    public Compte(String typeCompte, String numeroCompte, double pValcreditee) {
        ligne = new LigneComptable[NBLigne];
        NBLigneReel = -1;
        this.typeCompte = typeCompte;
        this.numeroCompte = numeroCompte;
        this.pValcreditee = pValcreditee;
        this.solde = pValcreditee;
    }

    public void afficherCpte() {
        System.out.println("Entrez le numéro du compte que vous souhaitez consulter:");
        //keyb.nextLine();
        numeroConsulte = keyb.nextLine();
        if (numeroConsulte.equals(numeroCompte)) {
            System.out.println("Le compte #:" + numeroCompte);
            System.out.println("Type:" + typeCompte);
            System.out.println("Valeur initiale: " + pValcreditee);
            System.out.println("Solde actuel : " + solde);


            if (NBLigneReel > 0) {
                System.out.println("\n--- Lignes comptables (" + NBLigneReel + ") ---");
                for (int i = 0; i < NBLigneReel; i++) {
                    if (ligne[i] != null) {
                        ligne[i].afficherLigneComptable(numeroCompte);
                        System.out.println("---------------------");
                    }
                }
            } else {
                System.out.println("Aucune ligne comptable associée.");
            }
        } else {
            System.out.println("Le numéro de compte est invalide.");
        }
    }

        private void decalerLesLignes() {
        for (int i = 1; i < NBLigne; i++) {
            ligne[i - 1] = ligne[i];
        }
        ligne[NBLigne - 1] = null;
    }

    public void creerLigne() {
        NBLigneReel++;
        LigneComptable nouvelle = new LigneComptable();
        if (NBLigneReel < NBLigne){
            ligne[NBLigneReel] = nouvelle;
        }else {
            decalerLesLignes();
            ligne[NBLigne - 1] = nouvelle;
            NBLigneReel = NBLigne;
        }
        if (nouvelle.getTypeOperation().equalsIgnoreCase("Débit") ||
                nouvelle.getTypeOperation().equalsIgnoreCase("Debit")) {
            solde -= nouvelle.getMontant();
        } else if (nouvelle.getTypeOperation().equalsIgnoreCase("Crédit") ||
                nouvelle.getTypeOperation().equalsIgnoreCase("Credit")) {
            solde += nouvelle.getMontant();
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



