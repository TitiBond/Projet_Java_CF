import java.util.ArrayList;

public class Dague extends ArmeMonstre{
    //CONSTURCTOR//
    Dague(){
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
        int randomNb = 1 + (int)(Math.random() * 10);
        if (randomNb == 1){
            if (personnageCible.m_InventaireObjet.size() <= 0){
                System.out.println("COUP BONUS : Il a tenté de te détruire une potion, mais tu n'en avais pas.");
            }else{
                volerPotion(personnageCible);
                System.out.println("COUP BONUS : Il te détruit une potion.");
            }

        }
    }

    /**
     * Méthode qui permet de détruire le premier objet dans l'inventaire d'objet de :
     * @param heros
     */
    public void volerPotion(Personnage heros){
        ArrayList<Objet> tab = heros.getM_InventaireObjet();
        if (tab.size() > 0) {
            tab.remove(0);
        }
    }


}
