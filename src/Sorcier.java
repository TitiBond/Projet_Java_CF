public class Sorcier extends Monstre{
    //CONSTRUCTOR//
    Sorcier(){

        super(35);
        /**un sorcier sur 3 a un potion  de vie les deux autres rien!**/

        s_iNbSorcierCreer++;
        if(s_iNbSorcierCreer%3==0){
            PotionVie pov1 = new PotionVie();
            m_Objet=pov1;
        }
        m_sTypeArmePointFaible = "FioleEau";
        Eclairs arme1 = new Eclairs();
        m_Arme = arme1;
    }
}
