public class PotionVie extends Objet{

    //Constructor//

    PotionVie(){
        super(10);
    }



    //METHODE//
    @Override
    public void appliquerEffet (Heros heros){

        heros.ameliorierVie(m_iValeurEffet);
        System.out.println("**Vous avez utilisé une potion de vie.**");
    }

}
