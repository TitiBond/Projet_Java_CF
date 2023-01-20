public class Fonction {

    /**Fonction pour verifier si nb est nombre premier **/
    public static boolean isPrimeNb(int nb){
        if (nb<=1){
            return false;
        }
        for (int  i=2; i<nb-1;i++){
            if(nb%i == 0){
                return false;
            }
        }
        return true;
    }
}
