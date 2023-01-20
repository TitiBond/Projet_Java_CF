public class FlecheFeu extends ArmeHeros{
    public static int m_iDegatsBase = 7;
    //Constructor

    FlecheFeu(){
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
