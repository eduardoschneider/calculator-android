package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private Number valorA = null;
    private Number valorB = 0;
    private char operacaoAtual = 'a';
    private Number resultado;
    private boolean ultimoDigito = false;//true numero false sinal
    private TextView txtValor;
    private TextView txtValor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtValor = findViewById(R.id.txtValor);
        this.txtValor2 = findViewById(R.id.txtValor2);
    }

    public int primeiroPasso(View v){
        Button b = (Button)v;

        if (this.valorA == null ||  !this.ultimoDigito) {
            this.operacaoAtual = b.getText().charAt(0);
            this.ultimoDigito = true;
        }

        if (!this.txtValor.getText().toString().isEmpty()) {
            if (this.valorA == null) {
                this.valorA = Double.parseDouble(this.txtValor.getText().toString());
                this.txtValor.setText("");
                this.txtValor2.setText(this.valorA.doubleValue() + " " + this.operacaoAtual);
            }
            else
            {
                this.valorB = Double.parseDouble(this.txtValor.getText().toString());
                this.resultado = calcula(this.valorA, this.valorB);
                this.txtValor.setText(Double.toString(resultado.doubleValue()));
                this.valorA = null;
                this.ultimoDigito = false;
                this.valorB = 0;
                this.operacaoAtual = 'a';
            }

        } else {
            if (this.valorA == null) {
                this.valorA = 0;
                this.txtValor.setText("");
                this.txtValor2.setText(this.valorA.doubleValue() + " " + this.operacaoAtual);
            }
            else {
                this.operacaoAtual = b.getText().charAt(0);
                this.txtValor2.setText(this.valorA.doubleValue() + " " + this.operacaoAtual);
            }
        }
        return 0;
    }

    public int addToScreen(View v){
        Button b = (Button) v;
        this.txtValor.append(b.getText().toString());

        return 0;
    }

    public void clear(View v){
        this.txtValor.setText("");
    }

    private Number calcula(Number valorA, Number valorB){
        switch (this.operacaoAtual){
            case '+':{
                this.valorA = valorA.doubleValue() + valorB.doubleValue();
                return(valorA.doubleValue() + valorB.doubleValue());
            }
            case '-':{
                this.valorA = valorA.doubleValue() - valorB.doubleValue();
                return(valorA.doubleValue() - valorB.doubleValue());
            }
            case '/':{
                this.valorA = valorA.doubleValue() / valorB.doubleValue();
                return(valorA.doubleValue() / valorB.doubleValue());
            }
            case 'x':{
                this.valorA = valorA.doubleValue() * valorB.doubleValue();
                return(valorA.doubleValue() * valorB.doubleValue());
            }

        }
        return 0;
    }

    public int pressIgual(View v){
        if (this.txtValor.getText().toString().isEmpty()){
            this.valorB = 0;
        } else {
            this.valorB = Double.parseDouble(this.txtValor.getText().toString());
        }
        this.txtValor2.setText(Double.toString(calcula(this.valorA, this.valorB).doubleValue()));
        this.txtValor.setText("");
        this.ultimoDigito = false;
        return 0;
    }

}
