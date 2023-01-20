import java.util.ArrayList;

public class Piece {

    public static int s_iNbPieceCreer = 0;
    private int m_iNumeroPiece;
    private Monstre m_MonstreACombattre;
    private ArrayList<Objet> m_Objets = new ArrayList<Objet>();


    //CONSTRUCTOR//
    Piece(){
        s_iNbPieceCreer++; //Incrémenté à chaque création de pièce//
        m_iNumeroPiece = s_iNbPieceCreer;
        /** Check si la pièce créee est un multiple de 3,4 ou les deux afin de generer les potions de  vie ou de force  **/
        if ((s_iNbPieceCreer%12) == 0){
            PotionVie popoV = new PotionVie();
            PotionForce popoF = new PotionForce();
            m_Objets.add(popoV);
            m_Objets.add(popoF);
        }else if ((s_iNbPieceCreer%4) == 0){
            PotionForce popo1 = new PotionForce();
            m_Objets.add(popo1);
        }else if((s_iNbPieceCreer%3) == 0){
            PotionVie popo2 = new PotionVie();
            m_Objets.add(popo2);
        }


        /**
         * création du type de monstre par pièce :
         *  -si la piece est un multiple de 12 alors on créer un barbare
         *  -si la piece est un multiple de 4 alors on créer un voleur
         *  -si la piece est un multiple de 3 alors on créer un troll
         *  -si la piece est un nombre entier supérieur a 3 alors on créer un sorcier
         *  -sinon on créer un zombie
         * **/

        if(s_iNbPieceCreer%12==0){
            Barbare en1 = new Barbare();
            m_MonstreACombattre=en1;

        } else if (s_iNbPieceCreer%4==0) {
            Voleur en1=new Voleur();
            m_MonstreACombattre=en1;

        } else if (s_iNbPieceCreer%3==0) {
            Troll en1= new Troll();
            m_MonstreACombattre=en1;

        } else if (s_iNbPieceCreer>3 && Fonction.isPrimeNb(s_iNbPieceCreer)) {
            Sorcier en1=new Sorcier();
            m_MonstreACombattre=en1;
        }
        else {
            Zombie en1 = new Zombie();
            m_MonstreACombattre=en1;
        }

    }

    //GET//
    public ArrayList<Objet> getM_Objets(){
        return m_Objets;
    }

    public Monstre getM_MonstreACombattre(){
        return m_MonstreACombattre;
    }


    //METHODE//
    public void EntrerPiece(Heros heros){

        System.out.println(heros.getM_sNom()+ ", tu entres dans la piece n°" +m_iNumeroPiece);
    }
}
