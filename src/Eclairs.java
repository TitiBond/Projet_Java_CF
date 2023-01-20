public class Eclairs extends ArmeMonstre{
    //CONSTRUCTOR//
    Eclairs(){
        m_iPointAttaque = 5;
    }


    //METHODE//

    @Override
    public void infligerDegats(Personnage personnageCible) {
        super.infligerDegats(personnageCible);
        System.out.println("Il vous a infliger "+m_iPointAttaque+ " dégats.");
        int randomNb = 1 + (int)(Math.random() * 5);
        if (randomNb == 1 ){
            System.out.println("COUP BONUS : Il t'a paralysé. Tu ne pourras pas attaquer au prochain tour.");
            LogiqueJeu.isSauterTourJoueur = true;
        }

    }
}
