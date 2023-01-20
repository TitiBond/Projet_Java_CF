public class Morsure extends ArmeMonstre{
    Morsure(){
        m_iPointAttaque = 4;
    }

    //METHODE//

    @Override
    public void infligerDegats(Personnage personnageCible) {

        int randomNb = 1 + (int) (Math.random() * 15);
        int m_iPdVRestant = personnageCible.m_iPointDeVie;
        if (randomNb==1){
            personnageCible.degatsRecu(m_iPdVRestant/2);
            System.out.println("Il vous inflige " + m_iPdVRestant/2 + " degats.");
            System.out.println("COUP CRITIQUE : Le Zombie est pris d'une fringale et vous dévore à moitié!");
        } else{
            personnageCible.degatsRecu(m_iPointAttaque);
            System.out.println("Il vous inflige " + m_iPointAttaque + " degats.");
        }
    }
}
