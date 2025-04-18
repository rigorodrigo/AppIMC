
package br.upf.ccc.appimc.utilities;

import java.util.Scanner;

/**
 *
 * @author Rodrigo
 */
public class Teclado {
    
        public static String lerString(String mensagem){
       System.out.print(mensagem);  
       return new Scanner(System.in).next();
    }
    
    public static Integer lerInteger(String mensagem){
       System.out.print(mensagem);  
       return new Scanner(System.in).nextInt();
    }
    
    public static Float lerFloat(String mensagem){
       System.out.print(mensagem);  
       return new Scanner(System.in).nextFloat();
    } 
    
    public static Double lerDouble (String mensagem){
        System.out.print(mensagem);
        return new Scanner (System.in).nextDouble();
    }
    
    public static char lerChar (String mensagem){
        System.out.print(mensagem);
        return new Scanner (System.in).next().charAt(0);
    }
}
