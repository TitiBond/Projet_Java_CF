import java.util.ArrayList;

public class Donjon {

    private ArrayList<Piece> m_ListePieces = new ArrayList<Piece>();
    private Heros herosDonjon;

    //CONSTRUCTOR//

    Donjon(int nbPieceACreer){
        for(int i = 0;i < nbPieceACreer;i++){
            Piece room = new Piece();
            m_ListePieces.add(room);
        }
        Heros heros = new Heros();
        herosDonjon = heros;
        AccueilHero(herosDonjon);
    }


    //GET//

    /**
     * Permet de récupéré la liste de pièce
     * @return
     */
    public ArrayList<Piece> getM_ListePieces(){
        return m_ListePieces;
    }

    /**
     * Méthode qui chercher dans
     * @param indexPiece
     * @return
     */
    public Piece getPiece(int indexPiece){
        return m_ListePieces.get(indexPiece);
    }
    public Heros getHerosDonjon(){
        return herosDonjon;
    }


    //METHODE//
    public void AccueilHero(Heros heros){
        System.out.println("\n*****\n" +
                "Vous ouvrez la porte du donjon et arrivez dans une grande pièce !!\n" +
                "Cette pièce est un grand hall.\n" +
                "Vous entendez du bruit derrière vous ...\n" +
                "Vous avez l'impression de voir une silhouette...\n" +
                "*****");

    }
}
