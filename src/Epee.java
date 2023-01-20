public class Epee extends ArmeHeros{
    public static int m_iDegatsBase = 6;
    //Constructor//
    Epee(){
        super();
        m_iPointAttaque = 6;
    }


    //METHODE//

    @Override
    public void infligerDegats(Personnage personnageCible) {
        //début modif Myles Epee
        int randomNbCri = 1 + (int) (Math.random() * 10);
        if (randomNbCri == 1) {
            m_iPointAttaque = 25;
            LogiqueJeu.CpCrit = true;
        }
        super.infligerDegats(personnageCible);
        m_iPointAttaque = m_iDegatsBase;
        int randomNb = 1 + (int) (Math.random() * 5); //Génération d'un nombre aléatoire entre 1 et 5//
        if (randomNb == 1) {
            LogiqueJeu.sauterTourEnnemi = true;
        }

        if(!personnageCible.estEnVie()){
            m_iPointAttaque = m_iDegatsBase;
        }
    }



}
