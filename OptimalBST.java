package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Noah Tyler
 */

public class OptimalBST{
    
    private double[][] costRoot;
    private int[] keys;
    private double[] prob;
    private int numOfKeys;
    
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0 || !new File(args[0]).exists())
        {
            System.out.println("ERROR: Invalid Filename!");
            System.exit(0);
        }
        new OptimalBST(new File(args[0]));
    }
    
    public OptimalBST(File inputFile) throws FileNotFoundException{
        Scanner sc = new Scanner(inputFile);
        numOfKeys = sc.nextInt();
        keys = new int[numOfKeys+1];
        prob = new double[numOfKeys+1];
        costRoot = new double[numOfKeys+2][numOfKeys+1];
        for(int i = 0; i < keys.length; i++)
            keys[i] = sc.nextInt();
        for(int i = 0; i < prob.length; i++)
            prob[i] = sc.nextDouble();
        sc.close();
        createCostRoot();
        printCostRoot();
    }
    
    private void createCostRoot(){
        for(int i = 1; i <= numOfKeys; i++){
            costRoot[i][i] = prob[i];
            costRoot[i+1][i-1] = keys[i]; 
        }
        for(int d = 1; d <= numOfKeys; d++)
            for(int i = 1; i <= numOfKeys - d; i++){
                int j = i + d;
                int minK = 0;
                double tempMin = Integer.MAX_VALUE;
                double sum = 0;
                for(int k = i; k <= j; k++){
                    double c = costRoot[i][k-1] + costRoot[k+1][j];
                    sum += costRoot[k][k];
                    if(tempMin > c){
                        tempMin = c;
                        minK = k;
                    }
                }
                costRoot[i][j] = tempMin + sum;
                costRoot[j+1][i-1] = keys[minK];
            }
    }
    
    private void printCostRoot(){
        for(int i = 1; i <= numOfKeys + 1; i++){
            for(int j = 0; j <= numOfKeys; j++)
                System.out.print(costRoot[i][j] + " ");
            System.out.print("\n");
        }
    }
 
}