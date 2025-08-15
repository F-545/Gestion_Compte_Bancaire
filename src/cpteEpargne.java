import java.util.Scanner;

public class cpteEpargne extends Compte {

    private double tauxPlacement;

    private Scanner keyb = new Scanner(System.in);

    public cpteEpargne(String numeroCompte, double pValcreditee) {
        super("Epargne", numeroCompte, pValcreditee);
        this.tauxPlacement = controlTaux();
    }

    public void calculInteret() {

        double interet = getSolde() * tauxPlacement / 100;
        setSolde(getSolde() + interet);
    }

    public double getTauxPlacement() {
        return tauxPlacement;
    }

    public void setTauxPlacement(double tauxPlacement) {
        this.tauxPlacement = tauxPlacement;
    }

    private double controlTaux() {
        do {
            System.out.println("Taux de placement :");
            tauxPlacement = keyb.nextDouble();
        } while (tauxPlacement < 0);
        return tauxPlacement;
    }

    public void afficherCpte() {
        super.afficherCpte();
        System.out.println("Taux d'épargne:" + tauxPlacement);
    }
}

