public class Fleche extends ArmeHeros{
    public static int m_iDegatsBase = 7;
    //Constructor

    Fleche(){
        super();
        m_iPointAttaque = 7;
    }

    @Override
    public void infligerDegats(Personnage personnageCible) {
        super.infligerDegats(personnageCible);

        if(!personnageCible.estEnVie()){
            m_iPointAttaque = m_iDegatsBase;
        }
    }
}
