
package port;

import static java.lang.Thread.State.TERMINATED;
import java.util.Random;
import java.util.Scanner;

public class Port {
    public static int maxContP = 25;   
    public static int prichal = 3;
    public static int nowContP;
    public static int dei1, dei2, dei3;
    
    public static Thread ship1 = new Thread(new Ship(1));   
    public static Thread ship2 = new Thread(new Ship(2));      
    public static Thread ship3 = new Thread(new Ship(3));  
    
    public static void main(String[] args) {
        
    Random r = new Random();  
    nowContP  = r.nextInt(maxContP);
    System.out.println("Contenerov v porty: " + nowContP + "/" + maxContP);
    // 
    
    vibD();
    
    ship1.start();
    ship2.start();
    ship3.start();
    
    gs();
    
    }
    
    public static int sca(){ 
    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    return a; 
    }
    
    public static void vibD(){
    System.out.println("vibirite deistvie:\n1.ship>>port\n2.port>>ship\n3.wait");
    dei1 = sca();
    dei2 = sca();
    dei3 = sca();
    }
    
    public static void gs(){
    Thread.State s1 = ship1.getState();
    Thread.State s2 = ship2.getState();
    Thread.State s3 = ship3.getState();
    Thread.State state = TERMINATED;
    
    for(boolean i = false;i == false;){
        
    if(state == s1 & s1 == s2 & s2 == s3){
         System.out.println("Contenerov v porty: " + nowContP + "/" + maxContP);
         i = true;
            }    
    else{
    s1 = ship1.getState();
    s2 = ship2.getState();
    s3 = ship3.getState();
    /*System.out.println(s1 );   
    System.out.println(s2 );  
    System.out.println(s3);*/  
            }
        }   
    }
    
}
