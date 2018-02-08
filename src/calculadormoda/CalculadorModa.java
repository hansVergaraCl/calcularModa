/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadormoda;

/**
 *
 * @author admin
 */
public class CalculadorModa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int maximaVecesQueSeRepite = 0;
        int moda = 0;
        int M[] = {1,2,3,4,5,6,7,8,9};

        for(int i=0; i<M.length; i++){
            int vecesQueSeRepite = 0;
            for(int j=0; j<M.length; j++){
                if(M[i] == M[j])
                vecesQueSeRepite++;
            }
            if(vecesQueSeRepite > maximaVecesQueSeRepite){
                moda = M[i];
                maximaVecesQueSeRepite = vecesQueSeRepite;
                
                
                
                
            }
        }

        System.out.println("La moda es "+moda+" y se repitió "+maximaVecesQueSeRepite+" veces.");
        }
}
