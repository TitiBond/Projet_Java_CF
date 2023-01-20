public abstract class Objet {

    protected int m_iValeurEffet;

    //Constructor//

    Objet(int valeur){
        m_iValeurEffet = valeur;
    }


    public abstract void appliquerEffet(Heros heros);


}
