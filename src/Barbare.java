public class Barbare extends Monstre{

    //CONSTRUCTOR//
    Barbare(){

        super(35);
        s_iNbBarbareCreer++;
        // un barbare sur deux a une potion vie et l'autre une potion de force

        if(s_iNbBarbareCreer%2==0){
            PotionVie pov1 = new PotionVie();
            m_InventaireObjet.add(pov1);
            m_Objet=pov1;
        }
        else {
            PotionForce pof1= new PotionForce();
            m_InventaireObjet.add(pof1);
            m_Objet=pof1;
        }



        m_sTypeArmePointFaible = "Epee";
        Hache arme1 = new Hache();
        m_Arme = arme1;
    }

}
