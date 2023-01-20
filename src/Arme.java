abstract class Arme {

    protected int m_iPointAttaque;

    //CONSTRUCTOR//

    Arme(){

    }

    //METHODE//

    /**
     * Methode qui permet d'attaquer un cible
     * @param personnageCible
     */
    abstract public void infligerDegats(Personnage personnageCible);

}
