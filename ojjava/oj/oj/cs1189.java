package oj;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by 程森 on 2017/5/29.
 */
public class cs1189 {
    static Scanner cin = new Scanner(System.in);
    static PrintWriter cout = new PrintWriter(System.out);

    public static void main(String[] args) {

        TreeMap<String,Integer> map=new TreeMap<String,Integer>();
        boolean f=false;
        while(cin.hasNext()){
            String s=cin.nextLine();
            if(s.equals("%%%")) {f=true;continue;}
            if(!f){
                String[] t=s.split(" ");
                map.put(t[0], Integer.parseInt(t[2]));
            }else{
                String[] d=s.split(" ");
                if(s.contains("*")){
                    String[] t=new String[d.length];
                    int k,j=0;
                    for(int i=0;i<d.length;i++){
                        if(!d[i].equals("*")){
                            t[j++]=d[i];
                        }
                        else {
                            k=map.get(t[j-1])*map.get(d[i+1]);
                            t[j-1]=String.valueOf(k);
                            map.put(t[j-1], k);
                            i++;
                        }
                    }
                    sum(map,t,j);
                }
                else sum(map,d,d.length);
            }
        }

        cin.close();
        cout.close();
    }
    private static void sum(TreeMap<String,Integer> map,String[] d,int length){
        int sum=0;
        sum=map.get(d[0]);
        for(int i=1;i<length;i++){
            if(d[i].equals("+")){
                sum+=map.get(d[i+1]); i++;
            }
            else if(d[i].equals("-")){
                sum-=map.get(d[i+1]); i++;
            }
        }
        System.out.println(sum);
    }
}
