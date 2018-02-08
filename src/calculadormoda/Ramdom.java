/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadormoda;

import java.util.Random;

/**
 *
 * @author admin
 */
public class Ramdom {
    
        public static void main(String arg[ ]) {
            
            int randomNum = 0;
            
            Random rn = new Random();
            
            int n = 0;
            int ii = 0;
            for(int i =0; i <= 14; i++ ){
                n = 25;
                ii = rn.nextInt() % n*-1;
                randomNum =  1 + ii;
                System.out.println(randomNum);
            }
         }
    
}
