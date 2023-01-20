public class Zombie extends Monstre{
    //Constructor

    Zombie(){
        super(30);
        s_iNbZombieCreer++;
        if(s_iNbZombieCreer==1 || (s_iNbZombieCreer-1)%5 == 0){
            PotionForce pov1 = new PotionForce();
            m_Objet=pov1;
        }

        m_sTypeArmePointFaible = "FlecheFeu";
        Morsure arme1 = new Morsure();
        m_Arme = arme1;
    }
}
