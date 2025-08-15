import java.util.*;

public class Projet {
    public static void main(String[] args){


        Compte c = null;
        int continuer = 1;
        Scanner keyb = new Scanner(System.in);

        while (continuer == 1) {

            switch (menuPrincipal()) {
                case 1:
                    System.out.println("Création d'un compte");
                    System.out.println("1 - Saisie au clavier");
                    System.out.println("2 - Données prédéfinies");
                    System.out.print("Votre choix : ");
                    int choix = keyb.nextInt();

                    if (choix == 1) {
                        System.out.println("Quel type de compte souhaitez vous créer ? (1 (Simple) ou 2(Epargne))");
                        int type = keyb.nextInt();
                        if(type == 1){
                            c = new Compte();

                        } else if (type == 2) {
                            System.out.println("Taux de placement :");
                            double taux = keyb.nextDouble();
                            c = new cpteEpargne("N001",800000);

                        }

                    }else {

                         c = new Compte("Epargne","N001", 75000);
                    }
                    break;
                case 2:
                   c.afficherCpte();
                    break;
                case 3:
                    c.creerLigne();
                    break;
                case 4:
                    sortie();
                case 5:
                    aLaide();
                    break;
                default:
                    System.out.println("Option invalide.");
                    break;
            }
            System.out.println("Voulez vous continuer?(0/1)");
            continuer = keyb.nextInt();
        }

    }

    public static void aLaide() {
        System.out.println("Voici la description des options du menu :");
        System.out.println("1. Créer un compte         → Permet d’enregistrer un nouveau compte bancaire avec ses informations.");
        System.out.println("2. Afficher un compte      → Affiche les détails d’un compte existant à partir de son numéro.");
        System.out.println("3. Créer une ligne comptable → Ajoute une opération liée à un compte.");
        System.out.println("4. Sortir                  → Quitte le programme.");
        System.out.println("5. De l’aide               → Affiche cette page d’explication.");
    }

    public static void sortie() {
        System.out.println("Au revoir!!!");
        System.exit(0);
    }

    public static int menuPrincipal() {
        int choix ;
        System.out.println("---MENU PRINCIPAL---");
        System.out.println("1.Créer un compte");
        System.out.println("2.Afficher un compte");
        System.out.println("3.Créer une ligne comptable");
        System.out.println("4.Sortir");
        System.out.println("5.De l'aide");
        System.out.println("Votre choix:");
        Scanner clavier = new Scanner(System.in);
        choix = clavier.nextInt();
        return choix;
    }

}
