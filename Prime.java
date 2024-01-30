/* Sample java program to check given number is prime or not */
//Importing packages
import java.lang.System;
import java.util.Scanner;
// Creating Class
class Sample_Program {
    // main method
    public static void main(String args[]) {  
        int i,count=0,n;
        // creating scanner object
        Scanner sc=new Scanner(System.in);
        // get input number from user
        System.out.print("Enter Any Number : ");
        n=sc.nextInt(); 
        // logic to check prime or not
        for(i=1;i<=n;i++) {    
            if(n%i==0) {       
                    count++;   
            }    
        }    
        if(count==2)    
            System.out.println(n+" is prime"); 
        else
            System.out.println(n+" is not prime"); 
 
    }  
}
