public class Troll extends Monstre {
    //constructor
    Troll(){
        super(40);
        s_iNbTrollCreer++;
        if((s_iNbTrollCreer+1)%4 == 0){
            PotionForce pov1 = new PotionForce();
            m_Objet=pov1;
        }

        m_sTypeArmePointFaible = "Lance";
        Batte arme1 = new Batte();
        m_Arme = arme1;
    }
}
