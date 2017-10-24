
package port;

import java.util.Random;
import java.util.Scanner;


public class Ship extends Port implements Runnable{
    
    public int maxContS = 5;
    public int nowContS;
    public int numberS;  
    public static int dei;
    
    Random r = new Random(); 
    
    
    public Ship(int numberS) {
        this.numberS = numberS;      
        nowContS  = 1 + r.nextInt(maxContS - 1); 
        System.out.println(
        "ship" + numberS + " na borty " + nowContS + "/" + maxContS + " Contenerov");          
    }
   
    
    @Override
    public void run() {     
    //System.out.println(numberS);   
    switch (numberS){
        case 1:
            dei = dei1;
            break;
        case 2:
            dei = dei2;
            break;
        case 3:
            dei = dei3;
            break;
    }
    switch (dei) {
        case 1:
            SnP();
            break;
        case 2:
            PnS();
            break;
        case 3:
            Thread.yield();
            break;
        default:
            break;
        }
        getState();
        Thread.interrupted();
                
    }
    
    public synchronized void SnP(){
        System.out.println("ship" + numberS + " ship >> port");
        if(nowContS > (maxContP - nowContP)){
          nowContP = nowContP + (maxContP - nowContP);
          nowContS = nowContS - (maxContP - nowContP);  
        }else{
        nowContP = nowContP + nowContS;
        nowContS = nowContS - nowContS;
        }
       // System.out.println("Contenerov v porty: " + nowContP + "/" + maxContP + "\n"
       // + "na borty " + "ship" + numberS + " " + nowContS + "/" + maxContS + " Contenerov");      
    }
    public synchronized void PnS(){
        System.out.println("ship" + numberS + " port >> ship");
        if(nowContP < (maxContS - nowContS)){
        nowContS = nowContS + nowContP;   
        nowContP = nowContP - nowContP;       
        }else{       
        nowContP = nowContP - (maxContS - nowContS);
        nowContS = nowContS + (maxContS - nowContS);
        }
        //System.out.println("Contenerov v porty: " + nowContP + "/" + maxContP);
       // System.out.println("na borty " + "ship" + numberS + " " + nowContS + "/" + maxContS + " Contenerov");    
    }
    public synchronized void getState(){
    System.out.println("na borty " + "ship" + numberS + " " + nowContS + "/" + maxContS + " Contenerov");
    //System.out.println("Contenerov v porty: " + nowContP + "/" + maxContP);
    }
    public synchronized void waitt(){
        
    }
}
