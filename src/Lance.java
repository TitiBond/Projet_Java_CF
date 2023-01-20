public class Lance extends ArmeHeros{
    public static int m_iDegatsBase = 6;
    //Constructor

    Lance(){
        super();
        m_iPointAttaque = 6;
    }

    @Override
    public void infligerDegats(Personnage personnageCible) {
        super.infligerDegats(personnageCible);

        if(!personnageCible.estEnVie()){
            m_iPointAttaque = m_iDegatsBase;
        }
    }
}
