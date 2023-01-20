import java.util.Scanner;

public class LogiqueJeu {

    public static boolean choixQuitterPiece = false;
    public static boolean sauterTourEnnemi = false;
    public static boolean isSauterTourJoueur = false;
    public static boolean recupererVie = false ;
    public static boolean volerPotion = false;
    public static boolean CpCrit = false;


    /** fonction pour le menu de selection des difficultés :
     *  -cette fonction propose un menu au joueur afin qu'il choisisse sa difficulte
     *  - la difficulte a une incidence sur le nombre de pièce qui sera créée dans le donjon
     *  - la fonction retourne en valeur un "int" qui sera le nombre de pièece a créer
     * **/
    public static int choixDifficulte(){
        Scanner scanInt = new Scanner(System.in);
        int choix;
        int difficulte = 0;
        System.out.println("*** BIENVENUE SUR DUNGEON AND DRAGON ***");
        do {
            System.out.println("Choisis ton niveau de difficulté : \n" +
                    "0 : Facile (5 pièces) \n" +
                    "1 : Moyen (12 pièces) \n" +
                    "2 : Difficile (20 pièces)");
            choix = scanInt.nextInt();
        }while(choix < 0 || choix > 2);
        switch (choix){
            case 0 :
                difficulte = 5;
                break;
            case 1 :
                difficulte = 12;
                break;
            case 2 :
                difficulte = 20;
                break;
        }
        return difficulte;
    }


    public static void introJeu(Donjon donjon){
        Scanner scanString = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        int choixpret;
        int cptPasPret = 0; /** compteur qui correspond au nombre de fois que le joueur dit qu'il n'est pas prêt **/
        System.out.println("\n*****\n" +
                "Oulala. Héros !! Où vas-tu comme ça?!\n" +
                "Je suis Kröktar, l'esprit du donjon.\n" +
                "Et toi héros ? Qui es-tu ? Peux-tu me donner ton nom ?? :");
        donjon.getHerosDonjon().setM_sNom(scanString.next()); //mise à jour du nom du héros
        System.out.println("*****");
        System.out.println("\n*****\n" +
                "Ok,"+donjon.getHerosDonjon().getM_sNom()+ ".\n" +
                "Sais-tu ce qu'il t'attends derrière ses portes ?\n" +
                "..... Un danger immense !\n" +
                "...Si je peux me permettre, je pense que toi et moi on peut s'entraider !\n" +
                "J'ai besoin d'atteindre la dernière pièce du donjon, afin de m'apaiser et de rejoindre mes semblables.\n" +
                "Je vais donc te suivre, et je t'aiderai du mieux que je peux !!!");
        do {
            if (cptPasPret == 1 ){
                System.out.println("\n*****\n" +
                        "C'est bon, tu t'es bien reposé ?\n" +
                        "Tiens, comme promis, voici tes potions");
                PotionForce popof = new PotionForce();
                PotionVie popov = new PotionVie();
                donjon.getHerosDonjon().ajouterPotionForce(popof);
                donjon.getHerosDonjon().ajouterPotionVie(popov);
            }
            System.out.println("Es-tu prêt a t'aventurer dans la première pièce ?");
            System.out.println("0: Oui\n" +
                    "1 : Non");
            choixpret = scanInt.nextInt();
            if (choixpret == 1 && cptPasPret < 1) {
                cptPasPret++;
                System.out.println("\n*****\n" +
                        "NON ??? Tu n'es pas prêt ? Mais qu'est ce que tu fous içi alors ?\n" +
                        "Tu t'es perdu ?\n" +
                        "Bon.... De toute façon tu ne peux pas sortir, la porte par laquelle tu es entré est vérouillée maintenant...\n" +
                        "Si ça peut te motiver, je te laisse te reposer un petit peu et...\n" +
                        "Quand tu reviendra me voir, je te donnerai une potion de vie et de force.");
                System.out.println("*****");
                do {
                    System.out.println("\nAppuies sur 1 quand tu te sera assez reposé");
                    choixpret = scanInt.nextInt();
                }while (choixpret != 1);
            } else if (choixpret == 1 && cptPasPret == 1) {
                cptPasPret++;
                System.out.println("\n*****\n" +
                        "Hep hep hep !.... Tu me prendrais pas un peu pour un idiot ?\n" +
                        "Je pense que tu t'es largement reposé.\n" +
                        "Et je ne vais pas te donner des centaines de potions...\n" +
                        "....De toute façon, je n'en ai plus sur moi !\n" +
                        "*****");
            }else if(choixpret == 1 && cptPasPret == 10){
                cptPasPret++;
                System.out.println("\n*****\n" +
                        "AaaaAaAaHhhhHHhhhhHHH !!!\n" +
                        "Bon !!!! J'ai compris, tiens je te redonne une potion de chaque....\n" +
                        "Mais maintenant, on y vas !!\n" +
                        "*****");
                PotionForce popof = new PotionForce();
                PotionVie popov = new PotionVie();
                donjon.getHerosDonjon().ajouterPotionForce(popof);
                donjon.getHerosDonjon().ajouterPotionVie(popov);
            }else if (choixpret == 1 && cptPasPret > 1){
                cptPasPret++;
                System.out.println("\n*****\n" +
                        "Bon je n'ai pas que ça à faire....\n" +
                        "Je m'impatiente....\n" +
                        "*****");
            }
        }while(choixpret != 0 );
    }


    /**
     * Fonction qui permet de proposer les différents choix d'action au joueur:
     *
     * **/
    public static void menuJoueur(Donjon donjon, int index){
        int choix;
        Piece piece = donjon.getPiece(index);
        Heros joueur = donjon.getHerosDonjon();
        Monstre ennemi = donjon.getPiece(index).getM_MonstreACombattre();
        do {
            System.out.println("\n**MENU D'ACTION**\n" +
                    "0 : Attaquer\n" +
                    "1 : Changer d'arme\n" +
                    "2 : Fouiller le monstre\n" +
                    "3 : Fouiller la pièce\n" +
                    "4 : Utiliser une potion\n" +
                    "5 : Entrer dans la pièce suivante");
            Scanner scanInt = new Scanner(System.in);
            System.out.println("\n Que souhaites-tu faire ?");
            choix = scanInt.nextInt();
            switch (choix){
                case 0 :
                    if (ennemi.estEnVie()){
                        if(ennemi.armeEstEfficace(joueur.getM_ArmeEnCours())){
                            joueur.attack(ennemi);
                        }else{
                            System.out.println("Il semblerait que le monstre n'ait rien senti.\n" +
                                    "Tu devrais peut être essayer : " +ennemi.getM_sTypeArmePointFaible());
                        }
                    }else{
                        System.out.println("\n*****\n" +
                                "Je pense que ça ne sert a rien d'attaque ce monstre.\n*****");
                    }
                    break;
                case 1 :
                    joueur.selectionnerArmeArsenal();
                    break;
                case 2 :
                    joueur.chercherPotionMonstre(ennemi);
                    break;
                case 3 :
                    joueur.chercherPotionPiece(piece);
                    break;
                case 4 :
                    joueur.utiliserPotion();
                    break;
                case 5 :
                    if(ennemi.getM_iPointDeVie() <= 0){
                        System.out.println("Bon allez, c'est parti, passons à la salle suivante !");
                        choixQuitterPiece = true;
                        break;
                    }else {
                        System.out.println("\n*****\n" +
                                "Je ne sais pas si tu as vu, mais il y a un monstre entre la porte et toi ? Il faut d'abord que tu tue cet ennemi !\n" +
                                "*****");
                        choix = 4;
                    }
                    break;
                default :
                    System.out.println("Mauvais choix");
                    break;
            }
        }while(choix > 0 && choix <  5);

    }

}
