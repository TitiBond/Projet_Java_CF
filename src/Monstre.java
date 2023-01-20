import java.util.ArrayList;

public class Monstre extends Personnage {
    public static int s_iNbBarbareCreer = 0 ;
    public static int s_iNbSorcierCreer = 0;
    public static int s_iNbVoleurCreer = 0;
    public static int s_iNbTrollCreer = 0;
    public static int s_iNbZombieCreer = 0;
    public String m_sTypeArmePointFaible;


    //CONSTRUCTOR//
    Monstre(int pv){

        super(pv);
    }


    //GET//
    public String getM_sTypeArmePointFaible(){
        return m_sTypeArmePointFaible;
    }

    public Objet getM_Objet(){
        return m_Objet;
    }

    @Override
    public ArrayList<Objet> getM_InventaireObjet() {
        return m_InventaireObjet;
    }

    //SET//

    public void setM_Objet(Objet objet) {
        m_Objet = objet;
    }


    //METHODE//

    /**
     *  Methode pour attaquer qui prend en argument "la cible a attaquer" :
     *   - l'arme du monstre inflige des degats à la cible en appelant la methode d'arme "infligerDegats()"
     *
     * **/
    @Override
    public void attack(Personnage personnageCible) {
        if(this.estEnVie()){
            System.out.println("\n*****\n" +
                    "Le " + this.getClass().getName()  + " vous attaque avec son arme : "+m_Arme.getClass().getName()+" !");
            m_Arme.infligerDegats(personnageCible);
            System.out.println("Vous avez maintenant " +personnageCible.getM_iPointDeVie()+ " point de vie\n" +
                    "*****");
        }
    }

    public boolean armeEstEfficace(Arme arme){
        if(arme.getClass().getName().equals(getM_sTypeArmePointFaible())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void degatsRecu(int degats) {
        super.degatsRecu(degats);

    }


    public void recupererVie(){
        if (LogiqueJeu.recupererVie){
            LogiqueJeu.recupererVie = false;
            m_iPointDeVie += 10;
        }
    }
}
