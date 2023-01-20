import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean gameIsRunning = true;
        boolean finDeJeu = false;
        while(gameIsRunning){
            Donjon donjon1 = new Donjon(LogiqueJeu.choixDifficulte()); //creation du donjon,de ses pieces, ennemis, etc..
            LogiqueJeu.introJeu(donjon1); //Lancement de l'introdution du jeu
            Heros joueur = donjon1.getHerosDonjon();

            /**
             *  Création d'une boucle FOR pour chacune des pièces créées.
             *  -a chaque itération correspond l'entrée du héro dans une nouvelle pièce
             * **/
            for (int i = 0; i < donjon1.getM_ListePieces().size(); i++){
                LogiqueJeu.choixQuitterPiece = false;
                Monstre ennemi = donjon1.getPiece(i).getM_MonstreACombattre();

                System.out.println("\n*****");
                donjon1.getPiece(i).EntrerPiece(donjon1.getHerosDonjon());
                joueur.decouvrirEnnemi(donjon1.getPiece(i).getM_MonstreACombattre());
                System.out.println("*****\n");


                //Boucle du tour par tour (attaque du monstre et choix du joueur)
                do {
                    if (!LogiqueJeu.sauterTourEnnemi){ /**verification si le tour de l'ennemi doit sauter : bonus paralysie **/
                        ennemi.attack(joueur);
                        if (LogiqueJeu.recupererVie){ /** vérification si le troll doit récupérer 10 pv : bonus troll  **/
                            ennemi.recupererVie();
                        }
                        if (!joueur.estEnVie()){
                            finDeJeu = true;
                            break;
                        }
                    }else {
                        LogiqueJeu.sauterTourEnnemi = false;
                    }
                    if (!LogiqueJeu.isSauterTourJoueur){ /** vérification si le joueur doit sauter son tour ; bonus paralysie **/
                        LogiqueJeu.menuJoueur(donjon1, i);
                    }else {
                        LogiqueJeu.isSauterTourJoueur = false;
                    }

                }while((LogiqueJeu.choixQuitterPiece == false) && (finDeJeu == false));
                if (finDeJeu){
                    break;
                }
                joueur.setM_iForce(0);
            }

            if (joueur.estEnVie()){
                System.out.println("\n*****\n" +
                        "Tiens !!!! Regarde en face !\n" +
                        "UN TRESOR !!\n" +
                        "Toi comme moi allons être gagnant.\n" +
                        "Moi je vais retrouver les miens.\n" +
                        "Et toi tu va être riche\n" +
                        "*****\n" +
                        "\n\n" +
                        "FIN DU JEU, MERCI D'AVOIR PARTICIPE");
            } else {
                System.out.println("FIN DE JEU !");
            }

            gameIsRunning = false;


        }
    }
}



