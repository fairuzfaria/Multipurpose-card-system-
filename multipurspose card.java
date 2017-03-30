/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.algorithm;

/**
 *
 * @author Proyti
 */
import java.util.Scanner;
public class GeneticAlgorithm {
    public static void main(String[] args) {
        { 
        System.out.println("Iteration no 1");
        System.out.println(" ");
        Scanner sc = new Scanner(System.in);            
        int count = 2;
	people p = new people();
        p.Generate();
        System.out.println("How many iterations do you want?");
        int iter = sc.nextInt();
		for(int i=0;i<iter;i++)
                {                   
                    System.out.println("Iteration no"+" "+count);
                    p.Generate2();
                    count++;
                }
                p.Print();
	}	
    }   
}
