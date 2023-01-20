public class Hache extends ArmeMonstre{

    private int m_iCompteurCritique;
    private static final int s_iNbCoupAvantCritique = 4;
    //CONSTRUCTOR//
    Hache(){
        super();
        m_iPointAttaque = 5;
        m_iCompteurCritique = 0;
    }



    //METHODE//

    @Override
    public void infligerDegats(Personnage personnageCible) {
        m_iCompteurCritique++;

        if (m_iCompteurCritique % s_iNbCoupAvantCritique == 0){
            personnageCible.degatsRecu(m_iPointAttaque*2);
            System.out.println("Il vous inflige " + m_iPointAttaque+ " degats.");
            System.out.println("COUP CRITIQUE : Il vous a fait une double attaque, et vous inflige encore " +m_iPointAttaque+ " degats.");
        }else {
            personnageCible.degatsRecu(m_iPointAttaque);
            System.out.println("Il vous inflige " + m_iPointAttaque+ " degats.");
        }
    }
}
