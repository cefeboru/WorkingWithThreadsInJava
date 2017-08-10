/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4hilos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Cesar Bonilla
 */
public class Actividad4Hilos {

    /**
     * @param args the command line arguments
     */
    private static List<Thread> threadsList = new ArrayList<Thread>();
    private final static int splitEvery = 250000;
    private final static int listSize = 1000000;
    
    public static void main(String[] args) {
        System.out.printf("Filling Array with %d random elements\n", listSize);
        fillListWithRandoms(listSize);
        int numThreads = getNumberOfThreads();
        System.out.printf("We will need %d threads to handle %d elements each one\n", numThreads, splitEvery);
        System.out.println("Now Creating threads...");
        
        for(int i=0; i < numThreads; i++){
            SumSet taskSum = new SumSet(i*splitEvery, splitEvery);
            Thread worker = new Thread(taskSum);
            worker.start();
            threadsList.add(worker);
        }
        
        int threadsRunning = 0;
        do {
            threadsRunning = 0;
            for(Thread thread: threadsList){
                if(thread.isAlive()){
                    threadsRunning++;
                }
            }
        } while (threadsRunning > 0);
        
        int finalSum = 0;
        for(Integer threadSetSum: Data.SumsList){
            finalSum += threadSetSum;
        }
        
        System.out.printf("The final sum of all elements is: %d\n", finalSum);
    }
    
    public static void fillListWithRandoms(int size){
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            Data.listaNumeros.add(r.nextInt(1000));
        }
    }
    
    public static int getNumberOfThreads(){
        return Data.listaNumeros.size() / splitEvery;
    }
    
}
