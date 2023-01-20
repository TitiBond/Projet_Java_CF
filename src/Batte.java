public class Batte extends ArmeMonstre{
    //CONSTRUCTOR//
    Batte(){

        m_iPointAttaque = 5;
    }


    //METHODE//

    /**
     * Methode qui permet d'infliger des degats à :
     * @param personnageCible
     */
    @Override
    public void infligerDegats(Personnage personnageCible) {
        super.infligerDegats(personnageCible);
        System.out.println("Il vous a infliger "+m_iPointAttaque+ " dégats.");
        int randomNb = 1 + (int)(Math.random() * 5);
        if (randomNb == 1){
            LogiqueJeu.recupererVie = true;
            System.out.println("COUP BONUS : Il boit une potion de soin et récupère 10 points de vie.");
        }
    }
}
