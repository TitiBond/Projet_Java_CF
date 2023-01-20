import java.util.ArrayList;
import java.util.Scanner;

public class Heros extends Personnage{
    public static int m_iForceBase = 0;
    private String m_sNom;

    private int m_iForce;
    private int m_iPvMax;
    private ArmeHeros m_ArmeEnCours;
    private int m_iNbPotionVie;
    private int m_iNbPotionForce;
    private ArrayList<ArmeHeros> m_Arsenal = new ArrayList<ArmeHeros>();

    //CONSTRUCTOR//
    Heros(){
        super(250);
        m_iForce = 0;
        m_iPvMax = m_iPointDeVie;
        m_iNbPotionForce = 0;
        m_iNbPotionVie = 0;
        Fleche fleche = new Fleche();
        FioleEau fioleEau = new FioleEau();
        Epee epee = new Epee();
        Lance lance = new Lance();
        FlecheFeu flecheFeu = new FlecheFeu();
        m_Arsenal.add(fleche);
        m_Arsenal.add(fioleEau);
        m_Arsenal.add(epee);
        m_Arsenal.add(lance);
        m_Arsenal.add(flecheFeu);
        m_ArmeEnCours = epee;

    }

    //GET//
    public ArmeHeros getM_ArmeEnCours(){
        return m_ArmeEnCours;
    }
    public ArrayList<ArmeHeros> getM_Arsenal(){
        return m_Arsenal;
    }
    public ArrayList<Objet> getM_InventaireObjet(){
        return m_InventaireObjet;
    }
    public String getM_sNom(){
        return m_sNom;
    }

    public int getNbPotionsVie(){
        int nb = 0;
        if(m_InventaireObjet.size() > 0){
            for (int i = 0; i < m_InventaireObjet.size(); i++){
                if (m_InventaireObjet.get(i).getClass() == PotionVie.class){
                    nb++;
                }
            }
        }
        return nb;
    }

    public int getNbPotionsForce(){
        int nb = 0;
        if(m_InventaireObjet.size() > 0){
            for (int i = 0; i < m_InventaireObjet.size(); i++){
                if (m_InventaireObjet.get(i).getClass() == PotionForce.class){
                    nb++;
                }
            }
        }
        return nb;
    }

    //SET//
    public void setM_sNom(String nom){
        m_sNom = nom ;
    }
    public void setM_iForce(int valeur){
        m_iForce = valeur;
    }

    //METHODE//
    public void decouvrirEnnemi(Monstre monstre){
        if(monstre instanceof Troll){
            System.out.println("Il semblerait que derrière la porte se trouve un TROLL.");
        }else if (monstre instanceof Sorcier){
            System.out.println("Il semblerait que derrière la porte se trouve un SORCIER.");
        } else if (monstre instanceof Voleur) {
            System.out.println("Il semblerait que derrière la porte se trouve un VOLEUR.");
        }else if(monstre instanceof Zombie){
            System.out.println("Il semblerait que derrière la porte se trouve un ZOMBIE.");
        }else{
            System.out.println("Il semblerait que derrière la porte se trouve un BARBARE.");
        }
    }


    /**
     *  Methode pour attaquer qui prend en argument "la cible a attaquer"
     * **/
    @Override
    public void attack(Personnage personnageCible) {
        m_ArmeEnCours.infligerDegats(personnageCible);
        System.out.println("\n*****\n" +
                "Tu as attaqué le " + personnageCible.getClass().getName()+ " avec ton arme : " +m_ArmeEnCours.getClass().getName());
        if (LogiqueJeu.CpCrit == true){
            if(m_ArmeEnCours.getClass().getName().equals("FioleEau")){
                System.out.println("COUP CRITIQUE : La fiole était remplie d'eau bénite par Jean-paul II!!!!\n" +
                        "Le sorcier à été sublimé!!!");
            }else if(m_ArmeEnCours.getClass().getName().equals("Epee")){
                System.out.println("COUP CRITIQUE : Ton épée vient de se souvenir qu'elle est fille de la classe " +
                        "ArmeLegendaire et a coupé le cimérien en rondelle!!!!");
            }
            LogiqueJeu.CpCrit = false;
        }else if(m_ArmeEnCours.getClass().getName().equals("FioleEau")){
            System.out.println("Tu lui inflige " +(m_ArmeEnCours.m_iPointAttaque + m_ArmeEnCours.getM_iAttaqueBonus() - 2)+ " de dégats.");
        }else{
            System.out.println("Tu lui inflige " +(m_ArmeEnCours.m_iPointAttaque + m_ArmeEnCours.getM_iAttaqueBonus())+ " de dégats.");
        }
        if (m_ArmeEnCours.getM_iAttaqueBonus() != 0){
            System.out.println("COUP BONUS: dégats augmentés de 2: ");
        } else if (LogiqueJeu.sauterTourEnnemi){
            System.out.println("COUP BONUS : tu viens de le paralyser. Je pense qu'il ne pourra pas attaquer au prochain tour.");
        }
        if (!personnageCible.estEnVie()){
            System.out.println("Tu as tué le "+personnageCible.getClass().getName()+ ". Il est mort...");
        }else {
            System.out.println("Le " +personnageCible.getClass().getName()+ " a maintenant "+personnageCible.getM_iPointDeVie() + " point de vie");
        }

    }


    /**
     * métohde pour changer l'arme en cours :
     * -tant que l'utilisateur ne fait pas un choix proposé, on lui repropose les différentes armes
     * -si un choix correct est fait alors l'arme en cours est changé, et on affiche un message au joueur de sa nouvelle arme équipée
     * **/
    public void selectionnerArmeArsenal(){
        Scanner scanInt = new Scanner(System.in);
        boolean fonctionRunning = true;
        int choix;
        while(fonctionRunning){
            System.out.println("Quelle arme souhaites-tu utiliser : \n" +
                    "0 : Flèche\n" +
                    "1 : Fiole d'eau\n" +
                    "2 : Epée\n" +
                    "3 : Lance\n" +
                    "4 : Flèche de feu");
            System.out.println("Entre ton choix : ");
            choix = scanInt.nextInt();

            switch (choix){
                case 0 :
                    m_ArmeEnCours = m_Arsenal.get(0);
                    System.out.println("Tu viens d'équiper les Flèches.");
                    fonctionRunning = false;
                    break;
                case 1 :
                    m_ArmeEnCours = m_Arsenal.get(1);
                    System.out.println("Tu viens d'équiper les fiole d'eau.");
                    fonctionRunning = false;
                    break;
                case 2 :
                    m_ArmeEnCours = m_Arsenal.get(2);
                    System.out.println("Tu viens d'équiper ton épée.");
                    fonctionRunning = false;
                    break;
                case 3 :
                    m_ArmeEnCours = m_Arsenal.get(3);
                    System.out.println("Tu viens d'équiper ta lance.");
                    fonctionRunning = false;
                    break;
                case 4 :
                    m_ArmeEnCours = m_Arsenal.get(4);
                    System.out.println("Tu viens d'équiper les flèches de feu.");
                    fonctionRunning = false;
                    break;
                default :
                    System.out.println("Tu n'as pas fait le bon choix. Recommence !");
                    break;
            }
        }
    }

    public void ajouterPotionVie(Objet objet){
        m_InventaireObjet.add(objet);
        System.out.println("**Une potion de vie a été ajouté à votre inventaire.**");
    }
    public void ajouterPotionForce(Objet objet){
        m_InventaireObjet.add(objet);
        System.out.println("**Une potion de force a été ajouté à votre inventaire.**");
    }


    /**
     * Methode pour chercher une potion dans  une pièce :
     *  -elle prend en argument une pièce
     *  -elle cherche dans le tableau des objets de la piece
     *  -si le tableau est vide, elle affiche qu'aucun potion n'a été trouvé
     *  -sinon elle regarde si le ou les objets trouvés sont de type PotionVie ou PotionForce
     *  -si une ou plusieurs potions sont trouvées , elle les ajoute à l'inventaire du joueur et les supprime de la pièce
     * **/
    public void chercherPotionPiece(Piece piece){
        if(piece.getM_MonstreACombattre().estEnVie() == false){
            if (piece.getM_Objets().size() == 1){
                if (piece.getM_Objets().get(0).getClass() == PotionForce.class){
                    System.out.println("Il y a une potion de force. Vous la ramassez.");
                    m_InventaireObjet.add(piece.getM_Objets().get(0));
                    piece.getM_Objets().remove(0);
                }else {
                    System.out.println("Il y a une potion de vie. Vous la ramassez.");
                    m_InventaireObjet.add(piece.getM_Objets().get(0));
                    piece.getM_Objets().remove(0);
                }
            }else if(piece.getM_Objets().size() == 2){
                System.out.println("Il y a une potion de force et une potion de vie. Vous la ramassez.");
                m_InventaireObjet.add(piece.getM_Objets().get(0));
                m_InventaireObjet.add(piece.getM_Objets().get(1));
                piece.getM_Objets().remove(0);
                piece.getM_Objets().remove(1);
            }else{
                System.out.println("Il n'y a pas de potion dans la pièce");
            }
        }else{
            System.out.println("\n******\n" +
                    "Tue le d'abord !\n" +
                    "*****");
        }

    }


    /**
     * Methode pour chercher une potion sur un monstre:
     *  -elle prend en argument un Monstre
     *  -elle verifie le type d'objet du monstre
     *  -si l'objet est de type Potionvie alors elle affiche qu'une potion a été trouvé puis l'ajoute a l'inventaire du joueur. Et de celui du monstre
     *  -si l'objet est de type PotionForce alors elle affiche qu'une potion a été trouvé puis l'ajoute a l'inventaire du joueur. Et de celui du monstre
     *  -sinon elle affiche qu'aucune potion a été trouvé.
     * **/
    public void chercherPotionMonstre(Monstre monstre){
        if (monstre.estEnVie() == false){
            if(monstre.getM_Objet() == null){
                System.out.println("Il n'y a aucune potion sur ce cadavre.");
            }else if(monstre.getM_Objet().getClass() == PotionForce.class){
                System.out.println("Il y a une potion de force. Vous la ramassez.");
                m_InventaireObjet.add(monstre.getM_Objet());
                monstre.setM_Objet(null);
            }else if(monstre.getM_Objet().getClass() == PotionVie.class){
                System.out.println("Il y a une potion de vie. Vous la ramassez.");
                m_InventaireObjet.add(monstre.getM_Objet());
                monstre.setM_Objet(null);
            }
        }else{
            System.out.println("\n*****\n" +
                    "Tue le d'abord\n" +
                    "*****");
        }
    }


    /**
     * Méthode pour utiliser une potion de vie ou de force :
     *  -
     * **/
    public void utiliserPotion() {
        int choix;
        if (getNbPotionsForce() == 0 && getNbPotionsVie() == 0){
            System.out.println("Vous n'avez pas de potions en stocks");
        } else {
            afficherNbPotions();
            do {
                Scanner scanpopo = new Scanner(System.in);
                System.out.println("\n*****\n" +
                        "Quelle potion veux-tu utiliser ?\n" +
                        "0. Aucune potion\n" +
                        "1. Potion de Force\n" +
                        "2. Potion de Vie\n" +
                        "*****");

                choix = scanpopo.nextInt();
                if (choix == 0) {
                    System.out.println("Ok pas de potion !");
                } else if (choix == 1) {
                    if(getNbPotionsForce() > 0) {
                        for (int i = 0; i < m_InventaireObjet.size(); i++) {
                            if (m_InventaireObjet.get(i).getClass() == PotionForce.class) {
                                m_InventaireObjet.get(i).appliquerEffet(this);
                                m_InventaireObjet.remove(i);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Tu n'as pas de potion de force");
                    }
                } else if (choix == 2) {
                    if(getNbPotionsVie() > 0) {
                        for (int i = 0; i < m_InventaireObjet.size(); i++) {
                            if (m_InventaireObjet.get(i).getClass() == PotionVie.class) {
                                m_InventaireObjet.get(i).appliquerEffet(this);
                                m_InventaireObjet.remove(i);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Tu n'as pas de potion de vie");
                    }
                } else {
                    System.out.println("Choisi autre chose bourricot !");
                }
            }while(choix != 0);
        }
    }


    public void afficherNbPotions(){
        if (getNbPotionsForce() == 0 && getNbPotionsVie() == 0){
            System.out.println("\n****\n" +
                    "Vous n'avez aucune potion dans votre inventaire");
        }else{
            System.out.println("Vous avez " +getNbPotionsVie()+ " potions de vie et " +getNbPotionsForce()+ " potions de force dans votre inventaire.");
        }
    }


    public void ameliorierVie(int a){
        if (m_iPointDeVie + a <= m_iPvMax){
            m_iPointDeVie = m_iPointDeVie + a;
            System.out.println("Tu as regagné "+a+ " point de vie.\n" +
                    "Tu es maintenant à " +m_iPointDeVie+ " point de santé.");
        }
        else {
            System.out.println("Tu as gagné "+(m_iPvMax-m_iPointDeVie)+ " point de vie.");
            m_iPointDeVie = m_iPvMax;

        }
    }
    public void ameliorierForce(int a){
        m_iForce = m_iForce + a;
        m_ArmeEnCours.m_iPointAttaque += m_iForce;
        System.out.println("Tu as augmenté ta force de "+a+".");
    }


}
