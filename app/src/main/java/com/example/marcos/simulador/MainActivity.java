package com.example.marcos.simulador;

import android.provider.Settings;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner0,spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8,
            spinner9,spinner10,spinner11,spinner12,spinner13,spinner14,spinner15,spinner16,spinner17;
    private Button buttonCalcular;
    private TextView textViewR;
    private String pantalla="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //jugador1
        spinner0 = (Spinner) findViewById(R.id.spinner0);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner9 =(Spinner) findViewById(R.id.spinner9);
        spinner10 =(Spinner) findViewById(R.id.spinner10);
        //jugador2
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner11 = (Spinner) findViewById(R.id.spinner11);
        spinner12 = (Spinner) findViewById(R.id.spinner12);
        //mesa
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);
        spinner7 = (Spinner) findViewById(R.id.spinner7);
        spinner8 = (Spinner) findViewById(R.id.spinner8);
        spinner13 = (Spinner) findViewById(R.id.spinner13);
        spinner14 = (Spinner) findViewById(R.id.spinner14);
        spinner15 = (Spinner) findViewById(R.id.spinner15);
        spinner16 = (Spinner) findViewById(R.id.spinner16);
        spinner17 = (Spinner) findViewById(R.id.spinner17);

        buttonCalcular = (Button) findViewById(R.id.buttonCalcular);
        textViewR = (TextView) findViewById(R.id.textViewResult);
    }
    public void onClick(View view){
        Carta jugador1A= new Carta();
        Carta jugador1B = new Carta();
        Carta jugador2A = new Carta();
        Carta jugador2B = new Carta();
        Carta mesaA= new Carta();
        Carta mesaB = new Carta();
        Carta mesaC = new Carta();
        Carta mesaD = new Carta();
        Carta mesaE = new Carta();


        //la intencion es dar el valor de los sppiner a las cartas.
        jugador1A.setValor(obtenerValor(spinner0));
        jugador1A.setPalo((String)spinner9.getSelectedItem());

        //String a=jugador1A.getPalo();
        // System.out.println(a);

        jugador1B.setValor(obtenerValor(spinner1));
        jugador1B.setPalo((String)spinner10.getSelectedItem());

        jugador2A.setValor(obtenerValor(spinner2));
        jugador2A.setPalo((String)spinner11.getSelectedItem());

        jugador2B.setValor(obtenerValor(spinner3));
        jugador2B.setPalo((String)spinner12.getSelectedItem());

        mesaA.setValor(obtenerValor(spinner4));
        mesaA.setPalo((String)spinner13.getSelectedItem());

        mesaB.setValor(obtenerValor(spinner5));
        mesaB.setPalo((String)spinner14.getSelectedItem());

        mesaC.setValor(obtenerValor(spinner6));
        mesaC.setPalo((String)spinner15.getSelectedItem());

        mesaD.setValor(obtenerValor(spinner7));
        mesaD.setPalo((String)spinner16.getSelectedItem());

        mesaE.setValor(obtenerValor(spinner8));
        mesaE.setPalo((String)spinner17.getSelectedItem());

        Mesa mesa= new Mesa(mesaA,mesaB,mesaC,mesaD,mesaE);

        /*pantalla=ganador(jugador1A,jugador1B,jugador2A,jugador2B,mesa);*/
        int puntA= mesa.verMano(jugador1A,jugador1B);
        int puntB =mesa.verMano(jugador2A,jugador2B);
        System.out.println("puntA " + puntA + " puntB "+ puntB);
        String a = "";
        String b = "";
        if (puntA == 10) a = "high card";
        if (puntA == 9) a = "pair";
        if (puntA == 8) a = "double pair";
        if (puntA == 7) a = "three of a kind";
        if (puntA == 6) a = "straight";
        if (puntA == 5) a = "flush";
        if (puntA == 4) a = "full house";
        if (puntA == 3) a = "poker";
        if (puntA == 2) a = "straight flush";
        if (puntA == 1) a = "royal flush";
        if (puntB == 10) b = "high card";
        if (puntB == 9) b = "pair";
        if (puntB == 8) b = "double pair";
        if (puntB == 7) b = "three of a kind";
        if (puntB == 6) b = "straight";
        if (puntB == 5) b = "flush";
        if (puntB == 4) b = "full house";
        if (puntB == 3) b = "poker";
        if (puntB == 2) b = "straight flush";
        if (puntB == 1) b = "royal flush";
        if(puntA>puntB) {
            pantalla = "Player 2 wins with a " + b + " against a " + a;
        }

        else if(puntA<puntB) pantalla="Player 1 wins with a " + a + " against a " + b;
            //para determinar quien gana cuando tienen carta alta los 2 jugadores
        else if(puntA==puntB){

            if(Math.max(jugador1A.getValor(),jugador1B.getValor())>Math.max(jugador2A.getValor(),jugador2B.getValor())) pantalla="Player 1 wins with a higher " + a;
            else if(Math.min(jugador1A.getValor(),jugador1B.getValor())>Math.min(jugador2A.getValor(),jugador2B.getValor())) pantalla="Player 1 wins with a higher " + a;
            else if(Math.max(jugador1A.getValor(),jugador1B.getValor())<Math.max(jugador2A.getValor(),jugador2B.getValor())) pantalla="Player 2 wins with a higher " + b;
            else if(Math.min(jugador1A.getValor(),jugador1B.getValor())<Math.min(jugador2A.getValor(),jugador2B.getValor())) pantalla="Player 2 wins with a higher" + b;
            else pantalla="It's a draw! Both players have " + a + ".";
        }
        /*else {
            if(jugador1A.getValor()==jugador1B.getValor() && jugador2A.getValor()==jugador2B.getValor()){
                if(jugador1A.getValor()<jugador2A.getValor()) pantalla ="Player 2 wins";
                else if(jugador1A.getValor()>jugador2A.getValor()) pantalla ="Player 1 wins";
                else pantalla="It's a draw!";
            }
            //HAY QUE CAMBIAR ALGO PORQUE NO FUCIONA BIEN. YO LO HARIA CON MATH.MAX Y MATH.MIN
            else if(Math.max(jugador1A.getValor(),jugador1B.getValor())>Math.max(jugador2A.getValor(),jugador2B.getValor())) pantalla ="Player 1 wins";
            //else if(jugador1B.getValor()<jugador2A.getValor() && jugador1B.getValor()<jugador2B.getValor()) pantalla ="Gana el jugador 2";
            else if(Math.min(jugador1A.getValor(),jugador1B.getValor())>Math.min(jugador2A.getValor(),jugador2B.getValor())) pantalla ="Player 1 wins";
            else pantalla="Player 2 wins.";
            //pantalla = "Empate";
        }*/
        textViewR.setText(pantalla);
    }
    private int obtenerValor(Spinner s){
        int valor;
        String v = (String) s.getSelectedItem();
        if(v.equals("As")) valor = 14;
        else if(v.equals("K")) valor = 13;
        else if(v.equals("Q")) valor = 12;
        else if(v.equals("J")) valor = 11;
        else valor= Integer.parseInt(v);

        return valor;

    }




}