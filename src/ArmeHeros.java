public class ArmeHeros extends Arme{

    private int m_iAttaqueBonus;

    //CONSTRUCTOR//

    ArmeHeros(){
        super();
        m_iAttaqueBonus = 0;
    }

    //GET//

    /**
     * Methode qui permet de recupérer la valeur du bonus d'attaque
     * @return
     */
    public int getM_iAttaqueBonus() {
        return m_iAttaqueBonus;
    }


    //SET//

    /**
     * Methode qui permet de changer la valeur du bonus d'attaque
     * @param bonus
     */
    public void setM_iAttaqueBonus(int bonus) {

        m_iAttaqueBonus = bonus;
    }

    //METHODE//

    /**
     * Méthode qui permet d'infliger des degats à une cible
     * @param personnageCible
     */
    public void infligerDegats(Personnage personnageCible){

        personnageCible.degatsRecu(m_iPointAttaque+m_iAttaqueBonus);
    }

    /**
     * Méthode qui permet de modifier la valeur du bonus de degats
     * @param valeur
     */
    public void modifierAttaqueBonus(int valeur){
        m_iAttaqueBonus += valeur;
    }
}
