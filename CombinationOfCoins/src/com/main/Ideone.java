package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ideone {
	static int size,k,l=0,ind=1;
	static List<Integer> a,b;
	 static void copy(List<Integer> src , List<Integer> des)
	    {
	        int l=src.size();
	        for(int i=0;i<l;i++)
	        des.add(src.get(i));
	     }
	    static void comb(int st,int sum,List<Integer> res)
	    {
	        List<Integer> tmp = new ArrayList<>();
	        copy(res,tmp);
	        if(sum==k)
	        {
	            System.out.println(ind+" . "+tmp);
	            ind++;
	             l=1;
	            return;
	        }
	        if(sum > k){
	         l=1;return;
	        }
	        if(st==size){
	            l=2; return;
	        }
	        
	          int val=a.get(st);
	          int lim=b.get(st);
	          for(int i=1;i<=lim;i++)
	          {
	              l=0;
	            sum+=val;
	            tmp.add(val);
	            for(int j=1;j<=size-st;j++){
	            comb(st+j,sum,tmp);
	            if(l==1){
	            l=0;return;
	            }
	            if(l==2)
	            break;
	           }
	         }
	    }
	    public static void main(String[] args) {
	    char c;
	    int r;
	    List<Integer> t1 = new ArrayList<>(),t2=new ArrayList<>();
	    List<Integer> res = new ArrayList<>();
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the exchange amount");
	    k=sc.nextInt();
	    do{
	        System.out.println("Enter the value of denomination");
	        t1.add(sc.nextInt());
	        System.out.println("Enter the total number of this denomination");
	        t2.add(sc.nextInt());
	        System.out.println("Do you want to continue ? y|n");
	        c=sc.next().charAt(0);
	    }while(c=='y');
	    size=t1.size();
	    TreeMap<Integer,Integer> m = new TreeMap<>();
	    for(int i=0;i<size;i++){
	    m.put(t1.get(i),t2.get(i));
	    }
	    System.out.println("Coins available :");
	     for(Map.Entry<Integer,Integer> entry : m.entrySet()) 
	     System.out.println(entry.getKey()+" - "+entry.getValue()); 
	     System.out.println("Possible combs for exchange of :"+k);
	    a= new ArrayList<>(m.keySet());
	    b= new ArrayList<>(m.values());
	    for(int i=0;i<size;i++)
	    comb(i,0,res);
	  
	 }
}
