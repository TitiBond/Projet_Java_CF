public class FioleEau extends ArmeHeros{
    public static int m_iDegatsBase = 6;
    //Constructor//
    FioleEau(){
        super();
        m_iPointAttaque = 6;
    }


    //METHODE//

    @Override
    public void infligerDegats(Personnage personnageCible) {
        //Debut modif Myles FioleEau
        int randomNb = 1 + (int) (Math.random() * 10);
        if(randomNb == 1 ){
            m_iPointAttaque = 25;
            LogiqueJeu.CpCrit = true;
        }
        super.infligerDegats(personnageCible);
        m_iPointAttaque = m_iDegatsBase;
        modifierAttaqueBonus(2);
        if(!personnageCible.estEnVie()){
            this.setM_iAttaqueBonus(0);
        }

        if(!personnageCible.estEnVie()){
            m_iPointAttaque = m_iDegatsBase;
        }
    }
}
