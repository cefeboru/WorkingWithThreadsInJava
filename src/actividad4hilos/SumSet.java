/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4hilos;

/**
 *
 * @author Cesar Bonilla
 */
public class SumSet implements Runnable{
    private final int startIndex;
    private final int segmentSize;
    
    SumSet(int startIndex,int segmentSize){
        this.startIndex = startIndex;
        this.segmentSize = segmentSize;
    }
    
    @Override
    public void run() {
        int sum = 0;
        for (int i = startIndex; i < startIndex + segmentSize - 1; i++) {
            sum += Data.listaNumeros.get(i);
        }
        Data.SumsList.add(sum);
        System.out.println(sum);
    }
    
}
