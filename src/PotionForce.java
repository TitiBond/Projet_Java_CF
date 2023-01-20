public class PotionForce extends Objet{

    //Constructor//

    PotionForce(){
        super(10);
    }



    //METHODE//

    @Override
    public void appliquerEffet (Heros heros){

        heros.ameliorierForce(m_iValeurEffet);
        System.out.println("**Vous avez utilisé une potion de force.**");
    }

}
