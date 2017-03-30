/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.algorithm;

/**
 *
 * @author Anika
 */
import java.util.Random;
import java.util.*;

public class people{
    
    int num;
    
    String [] newChild = new String[6];
    String [] child = new String[6];
    
    int [] population = new int[6];
    int [] PopulationValue = new int[6];
    
    int [] Temp = new int[6]; 
    int [] TempValue = new int[6];
          
       public void Generate()
       {
            for(int i=0;i<population.length;i++)
           {  
            population[i]=Random();
            PopulationValue[i]=Fitness(i);
            }
          sort();
       }
        
        public void Generate2()
        {
            int newVal = Temp.length-1;
            for(int i=0;i<2;i++)
		 {
                    population[i]=Temp[newVal];
                    PopulationValue[i]=Fitness(i);   //coz only first two changed so need new fitness value    
                    newVal--;                                          //rest of them are unchanged
                 }
            System.out.println("After Removing the lowest Value: ");
             for (int i=0;i<population.length;i++)
             {
                 System.out.println(population[i]);
             }
            sort();
        }
    
    public void sort()
    {
       for(int i=0;i<population.length-1;i++)
		{
                    for(int j=i+1;j<population.length;j++)
			{
                        if(PopulationValue[i]>PopulationValue[j])
                            {
                                int temp = PopulationValue[j];
                                PopulationValue[j] = PopulationValue[i];
                                PopulationValue[i] = temp;

                                int temp2 = population[j];
                                population[j] = population[i];
                                population[i] = temp2;
                            }
                        }
		} 
       System.out.println("#####SORTED POPULATION#####");
       for(int i=0;i<population.length;i++)
       {
           
           System.out.println((i+1)+". "+population[i]);
       }
       System.out.println(" ");
       System.out.println("#####SORTED POPULATION VALUES#####");
        for(int i=0;i<population.length;i++)
       {
           
           System.out.println((i+1)+". "+PopulationValue[i]);
       }
       Crossover();
    }
    
    public void Crossover()
    {
        
        int x1 = population[5];
        int x2 = population[4];
        int x3 = population[3];
        int x4 = population[2];
       
        String X1 = toBinary(x1);
	String X2 = toBinary(x2);
	String X3 = toBinary(x3);
	String X4 = toBinary(x4);
        
         System.out.println(" ");
          System.out.println("The binary numbers: ");
          System.out.println(X1);
          System.out.println(X2);
          System.out.println(X3);
          System.out.println(X4);
          
        int cross = Random2();
         
        System.out.println("Position for Crossover"+" "+cross);
       
        //<-------for X1 and X2------->
        
        String cross1;
        String cross2;
        
        cross1 = X1.substring(0, cross);
        cross2 = X2.substring(cross,4);
        String Child1 = cross1+cross2;
        
        cross1 = X1.substring(cross, 4);
        cross2 = X2.substring(0, cross);
        String Child2 = cross2+cross1;
        
        child[0] = Child1;
        child[1] = Child2;
        
        //<------End of X1 and X2------>
         
        //<-------for X1 and X3------->
        
        cross1 = X1.substring(0, cross);
        cross2 = X3.substring(cross, 4);
        Child1 = cross1+cross2;
        
        cross1 = X1.substring(cross,4);
        cross2 = X3.substring(0, cross);
        Child2 = cross2+cross1;
        
        child[2] = Child1;
        child[3] = Child2;
          
        //<------End of X1 and X3------>
          
        //<-------for X2 and X4------->
        
        cross1 = X2.substring(0, cross);
        cross2 = X4.substring(cross, 4);
        Child1 = cross1+cross2;
        
        cross1 = X2.substring(cross, 4);
        cross2 = X4.substring(0, cross);
        Child2 = cross2+cross1;
        
        child[4] = Child1;
        child[5] = Child2;
          
        //<------End of X2 and X4------>  
         
         
          System.out.println(" ");
          System.out.println("The new Binary numbers after Swapping: ");
          for(int i=0;i<child.length;i++)
          {
            System.out.println(child[i]);
          }
          
          
        //<------Start of Mutation------>    
          System.out.println(" ");
          num = Random2();
          System.out.println("Inverting in = "+" "+ num + " Position");
          
          for(int i=0;i<child.length;i++)
          {
            String mutation = child[i];
            newChild[i]=  mutation(mutation); 
          }
          System.out.println(" ");
        //<------End of Mutation------>    
        
        
        
          System.out.println("New Childs after Mutation: ");
         
          for(int i=0;i<child.length;i++)
          {
              Temp[i] = Integer.parseInt(newChild[i],2);
              System.out.println(Temp[i]);
          }
       
         for(int i=0;i<Temp.length;i++)
         {
             TempValue[i]=Fitness2(i);  
         }
         
         System.out.println(" ");
         System.out.println("Value of New Childs: ");
         
         for(int i=0;i<Temp.length;i++)
         {
             System.out.println(TempValue[i]);
         }
          
         for(int i=0;i<population.length-1;i++)
		{
		
			for(int j=i+1;j<population.length;j++)
			{
				if(TempValue[i]>TempValue[j])
				{
					int temp=TempValue[j];
					TempValue[j]=TempValue[i];
                                        TempValue[i]=temp;
					
					int temp2=Temp[j];
					Temp[j]=Temp[i];
					Temp[i]=temp2;
					
					
				}
				
			}
		} 
          
          System.out.println(" ");
          System.out.println("After the Sorting of new Values: ");
          
          for(int i=0;i<Temp.length;i++)
          {
            System.out.println(Temp[i]);  
          }
    
 
    }    
    
    public static int Random()
    {
    Random rand=new Random();
    int min=1;
    int max=16;
    int randomNum = rand.nextInt((max - min)+ 1);
    return randomNum;  
    }
    
    public static int Random2()
    {
    Random rand2 = new Random();
    int min=1;
    int max=3;
    int randomNum = rand2.nextInt((max - min)+ 1);
    return randomNum;  
    }
    
    
    public int Fitness(int i)
    {
      int fitness = (population[i]*15) - (population[i]*population[i]);
      return fitness;
    }
     public int Fitness2(int i)
    {
      int fitness2= (Temp[i]*15) - (Temp[i]*Temp[i]);
      return fitness2;
    }


    public String toBinary(int c)
    {
		String s = Integer.toBinaryString(c);
		if(s.length()==1)
		{
			s="000"+s;
		}
		if(s.length()==2)
		{
			s="00"+s;
		}
		if(s.length()==3)
		{
			s="0"+s;
                }             
	return s;	
    }
     
    public String mutation(String s)
	{
                char mew[]=s.toCharArray();
		if(mew[num]=='0')
		{
                    mew[num]='1';
		}
		else
		{
                    mew[num]='0';
		}
                String newmew = new String(mew);
                
                System.out.println(newmew);
		return newmew;
	}
    
    public void Print()
    {
        System.out.println("Final result: ");
        for(int i=0;i<population.length;i++)
        {
          System.out.println(population[i]);
        }
        
    }
}

