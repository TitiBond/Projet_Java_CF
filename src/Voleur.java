public class Voleur extends Monstre{
    //Constructor
    Voleur(){
        super(35);
        s_iNbVoleurCreer ++;
        if(s_iNbVoleurCreer==1 || (s_iNbVoleurCreer-1)%6 == 0){
            PotionVie pov1 = new PotionVie();
            m_Objet=pov1;
        }

        m_sTypeArmePointFaible = "Fleche";
        Dague arme1 = new Dague();
        m_Arme = arme1;


    }
}
