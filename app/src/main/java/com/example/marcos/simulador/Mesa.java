package com.example.marcos.simulador;
import java.util.Arrays;
/**
 * Created by Marcos on 17/12/2016.
 */

public class Mesa {
    private Carta mesa[]= new Carta[5];

    public Mesa(){
        for(int i =0; i<mesa.length;i++) {
            mesa[i].setValor(0);
        }
    }
    public Mesa(Carta a,Carta b, Carta c, Carta d, Carta e){
        mesa[0]=a;
        mesa[1]=b;
        mesa[2]=c;
        mesa[3]=d;
        mesa[4]=e;
    }
    public int verMano(Carta a, Carta b){
        int contA =0;
        int contB=0;
        int color=0;
        int escalera=0;
        //p y s valor primera y segunda carta del jugador
        int p = a.getValor();
        int s = b.getValor();
        //c1 y c2 color de la carta 1 y 2 del jugador
        String c1 =a.getPalo();
        String c2 =b.getPalo();
        if(p==0 || s==0)return 0;
        Boolean pareja = p==s;

        int orden[]={-1, p,s,mesa[0].getValor(),mesa[1].getValor(),mesa[2].getValor(),mesa[3].getValor(),mesa[4].getValor()};
        //arrays.sort ordena el array, lo hago para saber si son numeros consecutivos
        Arrays.sort(orden);
        if(orden[7]==14){
            orden[0]=1;
            //Arrays.sort(orden);
        }
        for(int i =1; i<orden.length-1;i++){
            if((orden[i]+1)==orden[i+1])escalera++;
        }


       if(pareja){
           contA++;contB++;
       }

        if(c1.equals(c2))color++;
        for(int i =0;i<mesa.length;i++) {

            if (p == mesa[i].getValor()) contA++;
            if (s == mesa[i].getValor()) contB++;
            if(c1.equals(mesa[i].getPalo()) || c2.equals(mesa[i].getPalo()) )color++;

        }
        //for(int i =0; i<orden.length;i++){
           // System.out.println(i + " == " + orden[i]);
        //}
        boolean real=true;
        //System.out.println(orden);

        if(color>=4) {
            if(orden[7]==14){
                for(int i = orden.length-1; i>0 && orden[i-1]>9 ;i--) {
                    System.out.println(i +" " + orden[i]+ " " +orden[i-1] );
                    if(orden[i]==orden[i-1] || orden[i]==(orden[i-1]+1)) System.out.println(i + " == " + orden[i]);
                    else real=false;

                }
            }
            else return 1;
        }
        if(color>=4 && escalera>=4) return 2;
        //si contA o B tiene un 1 significa que tiene 2 cartas iguales y asi sucesivamente
        if(contA==3 || contB==3)return 3;
        if((contA==1 && contB==2) || (contA==2&&contB==1))return 4;

        if(color>=4) return 5;

        //lo que hago a continuacion es para saber si hay escalera
        /*int orden[]={-1, p,s,mesa[0].getValor(),mesa[1].getValor(),mesa[2].getValor(),mesa[3].getValor(),mesa[4].getValor()};
        //arrays.sort ordena el array, lo hago para saber si son numeros consecutivos
        Arrays.sort(orden);
        if(orden[7]==14){
            orden[0]=1;
            //Arrays.sort(orden);
        }
        /*for(int i =0; i<orden.length-1;i++){
            if((orden[i]+1)==orden[i+1])escalera++;
        }*/
        if(escalera>=4) return 6;
        if(contA==2 || contB==2) return 7;
        if(contA==1 && contB==1)return 8;
        if(contA==1 && contB==0)return 9;








/*
Esta es la lista de int que tiene que devolver segun el caso;
1 	Escalera real o flor imperial
2 	Escalera de color
3 	Póquer
4 	Full
5   Color
6 	Escalera
7 	Trío
8 	Doble pareja
9 	Pareja
10 	Carta alta
 */
        return 10;
    }

}

