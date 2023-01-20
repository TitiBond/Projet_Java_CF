public class ArmeMonstre extends Arme{

    private int m_iCompteurCritique;

    //CONSTRUCTOR//
    ArmeMonstre(){

    }


    //METHODE//


    /**
     * Méthode qui permet d'infliger des degats à une cible
     * @param personnageCible
     */
    @Override
    public void infligerDegats(Personnage personnageCible) {

        personnageCible.degatsRecu(m_iPointAttaque);
    }
}
