import java.util.ArrayList;

public abstract class Personnage {

    protected int m_iPointDeVie;
    protected Arme m_Arme;
    protected ArrayList<Objet> m_InventaireObjet = new ArrayList<Objet>();
    protected Objet m_Objet;

    //CONSTRUCTOR//
    Personnage(int pv){
        m_iPointDeVie = pv;
    }


    //GET//
    public int getM_iPointDeVie(){

        return m_iPointDeVie;
    }

    public abstract ArrayList<Objet> getM_InventaireObjet();

    //METHODE//

    /**
     *  Methode qui mets à jour les points de vie en fonction des degats reçus en argument
     * **/
    public void degatsRecu(int degats){

        m_iPointDeVie -= degats;
    }
    public void attack(Personnage personnageCible){}

    public boolean estEnVie(){
        if (getM_iPointDeVie() > 0){
            return true;
        }else{
            return false;
        }
    }

}
