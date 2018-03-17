/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Numbers;
import java.util.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Mithu
 */
@WebService(serviceName = "Numbers")
public class Numbers {

    @WebMethod(operationName = "prime")
    //Range Prime Numbers
    public String primeRange(@WebParam(name = "low")int low,@WebParam(name = "high")int high)
    {
        StringBuilder sb=new StringBuilder();
        while (low <= high) 
        {
            if(checkPrimeNumber(low))
                sb.append(low+"\n");
            ++low;
        }
        //System.out.println(sb);
        return sb.toString();
    }
    //Checking PrimeNumber
    private boolean checkPrimeNumber(int num) 
    {
        boolean flag = true;
        for(int i = 2; i <= num/2; ++i) {

            if(num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    
     @WebMethod(operationName = "perfectSquare")
    //Perfect Square
    public String perfectSquaresRange(@WebParam(name = "low")int low,@WebParam(name = "high")int high)
    {
        StringBuilder sb=new StringBuilder();
        int count=0;
        for(int x=low;x<=high;x++)
        {
            double d=Math.sqrt(x);
            int d1=(int)Math.sqrt(x);
            if(d-d1>0)
                continue;
            else
            {
                sb.append(x);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    
     @WebMethod(operationName = "composite")
    //Composite Range
    public String compositeRange(@WebParam(name = "low")int low,@WebParam(name = "high")int high)
    {
        StringBuilder sb=new StringBuilder();
        while (low <= high) 
        {
            if(!checkPrimeNumber(low))
                sb.append(low+"\n");
            ++low;
        }
        return sb.toString();
    }
    
    
    private static ArrayList<Integer> fibonacci(int n)
    {
        ArrayList<Integer> ar=new ArrayList<>();
        int a=0,b=1;
        ar.add(a);
        ar.add(b);
        int c=a+b;
        while(c<=n)
        {
            c=a+b;
            a=b;
            b=c;
            ar.add(a);
        }
        
        return ar;
    }
    
    @WebMethod(operationName = "fibonacciRange")
    //Fibonacci numbers
    public String fibonacciRange(@WebParam(name = "low")int low,@WebParam(name = "high")int high)
    {
        ArrayList<Integer> ar=fibonacci(high);
        System.out.println(ar);
        StringBuilder sb=new StringBuilder();
        int x=low;
        while(!ar.contains(x))
            x++;
        int index=ar.indexOf(x);
        while(index<ar.size())
        {
            sb.append(ar.get(index)+"\n");
            index++;
        }
        //System.out.println(sb);
        return sb.toString();
    }
    
    @WebMethod(operationName = "perfectCubeRange")
    //Perfect Cubes
    public String perfectCubeRange(@WebParam(name = "low")int low,@WebParam(name = "high")int high)
    {
        StringBuilder sb=new StringBuilder();
        for(int x=low;x<=high;x++)
        {
            double d=Math.cbrt(x);
            int d1=(int)Math.cbrt(x);
            if(d-d1>0)
                continue;
            else
            {
                sb.append(x);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}
