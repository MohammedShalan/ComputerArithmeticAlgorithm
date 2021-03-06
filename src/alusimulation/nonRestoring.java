/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alusimulation;

/**
 *
 * @author noura
 */
public class nonRestoring {
    /** Function to shift shift array **/
    public void leftShift(int A[])
    {        
        for(int i =0 ;i <= 6 ; i++){
            A[i] = A[i+1] ;

        } 
        A[A.length-1] = 0 ;
    }
    
    /** Function to add two binary arrays **/
    public void add(int[] A, int[] B)
    {
        int carry = 0;
        int i = 3 ; 
        while(i != -1 ){
            int temp = A[i] + B[i] + carry;
            A[i] = temp % 2;
            carry = temp / 2;
            i-- ;
        }
               
    }
    
        public int[] binary(int n)
    {
        int[] bin = new int[4];
        int ctr = 3;
        int num = n;
        /** for negative numbers 2 complment **/
        if (n < 0)
            num = 16 + n;
        while (num != 0)
        {
            bin[ctr--] = num % 2;
            num /= 2;
        }
        return bin;
    }
    
    /** Function to print array **/
    public void display(int[] P, char ch)
    {   
        System.out.print("\n"+ ch +" : ");
        for (int i = 0; i < P.length; i++)
        {  
            
            if (i == 4)
                System.out.print(" ");
            if (i == 8)
                System.out.print(" ");
            System.out.print(P[i]);
            
        } 
    }
    
    /** Function to get Decimal equivalent of P **/
    public int getDecimal(int[] B)
    {
        int p = 0;
        int t = 1;
        for (int i = 7; i >= 0; i--, t *= 2)
            p += (B[i] * t);
        if (p > 64)
            p = -(256 - p);
        return p;        
    }
    
    public int division(int n1, int n2)
    {
        int[] m = binary(n1);
        int[] m1 = binary(n2);
        int[] r = binary(-n2);        
        int[] A = new int[8];
        int[] S = new int[8];
        int[] P = new int[8];        
        for (int i = 0; i < 4; i++)
        {
            A[i] = m[i];      // Dividend
            S[i] = m1[i];    //Divisor
            
            P[i + 4] = A[i];
        }
        display(A, 'A');
        display(S, 'S');
        display(P, 'P'); 
        display(r, 'R');
        System.out.println();
        for (int i = 0; i < 4; i++) {
            
            if (P[0] == 0) {
                // A is positive > 0 
                leftShift(P);
                add(P, r); // A = A - M 

            } else {
                leftShift(P);
                add(P, S);  // A = A + M
            }
            if (P[0] == 0) {
                // A is positive > 0 
                P[P.length - 1] = 1;  // Set Q0 = 1 ;
            } else {
                P[P.length - 1] = 0;  // Set Q0 = 1 ;
            }
            if(i == 3) {
                if (P[0] != 0) {
                    add(P, S);  // A = A+M
                }
            }
            display(P, 'P');
        }
        return getDecimal(P);
    } 
}
