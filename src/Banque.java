/*import java.util.* ;

public class Banque {

    public static void main(String[] args) {
        String numeroCompte = "0";
        String typeCompte = "0";
        char theme = 'l';
        char moyenPaiement = 'c';
        long date;
        double pValcreditee = 0;
        double tauxPlacement = 0;
        int continuer = 1;
        Scanner keyb = new Scanner(System.in);

        while (continuer == 1) {

            switch (menuPrincipal()) {
                case 1:
                    System.out.println("Type de compte(Types possibles : courant (C), joint(J), épargne(E):");
                    typeCompte = keyb.nextLine();
                    if (typeCompte.equalsIgnoreCase("E"))  {
                        typeCompte = "Epargne";
                        System.out.println("Entrez le taux de placement:");
                        tauxPlacement = keyb.nextDouble();
                    }
                    else if(typeCompte.equalsIgnoreCase("C"))  {
                        typeCompte = "Courant";
                    }
                    else if(typeCompte.equalsIgnoreCase("J"))  {
                        typeCompte = "Joint";
                    }

                    System.out.println("Numéro du compte:");
                    numeroCompte = keyb.nextLine();
                    System.out.println("Entrez la première valeur créditée:");
                    pValcreditee = keyb.nextDouble();
                    break;
                case 2:
                    System.out.println("Entrez le numéro du compte que vous souhaitez consulter:");
                    String numeroConsulte = keyb.nextLine();
                    if (numeroConsulte.equals(numeroCompte)){
                        System.out.println("Le compte de numéro: " + numeroCompte + " a pour :");
                        System.out.println("Type:" + typeCompte);
                        System.out.println("Valeur initiale: " + pValcreditee);


                        if (typeCompte.equals("Epargne")) {

                            System.out.println("Taux d'épargne: " + tauxPlacement);
                        }
                    } else {
                        System.out.println("Le numéro de compte est invalide.");
                    }
                    break;
                case 3:
                    System.out.println("Option non programmée!!");
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


    public static int menuPrincipal() {

        int choix = 0;
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

    public static void sortie() {
        System.out.println("Au revoir!!!");
        System.exit(0);
    }

    public static void aLaide() {
        System.out.println("Voici la description des options du menu :");
        System.out.println("1. Créer un compte         → Permet d’enregistrer un nouveau compte bancaire avec ses informations.");
        System.out.println("2. Afficher un compte      → Affiche les détails d’un compte existant à partir de son numéro.");
        System.out.println("3. Créer une ligne comptable → Ajoute une opération liée à un compte.");
        System.out.println("4. Sortir                  → Quitte le programme.");
        System.out.println("5. De l’aide               → Affiche cette page d’explication.");
        
    }

}*/

