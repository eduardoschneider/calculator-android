package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private Number valorA = null;
    private Number valorB = 0;
    private char operacaoAtual = '+';
    private Number resultado;
    private TextView txtValor;
    private TextView txtValor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtValor = findViewById(R.id.txtValor);
        this.txtValor.setText("0");
        this.txtValor2 = findViewById(R.id.txtValor2);
    }

    public void primeiroPasso(View v){
        Button b = (Button)v;

        if (!(Integer.parseInt(this.txtValor.getText().toString()) == 0)) {
            if (this.valorA == null) {
                this.operacaoAtual = b.getText().charAt(0);
                this.valorA = Double.parseDouble(this.txtValor.getText().toString());
                this.txtValor.setText("0");
                this.txtValor2.setText(this.valorA.doubleValue() + " " + this.operacaoAtual);
            }
            else
            {
                this.valorB = Double.parseDouble(this.txtValor.getText().toString());
                this.resultado = calcula(this.valorA, this.valorB);
                this.operacaoAtual = b.getText().charAt(0);
                this.txtValor2.setText(resultado.doubleValue() + " " + this.operacaoAtual);
                this.txtValor.setText("0");
                this.valorA = this.resultado;
                this.valorB = 0;
            }

        } else {
            if (this.valorA == null) {
                this.operacaoAtual = b.getText().charAt(0);
                this.valorA = 0;
                this.txtValor.setText("0");
                this.txtValor2.setText(this.valorA.doubleValue() + " " + this.operacaoAtual);
            }
            else {
                this.operacaoAtual = b.getText().charAt(0);
                this.txtValor2.setText(this.valorA.doubleValue() + " " + this.operacaoAtual);
            }
        }
    }

    public void addToScreen(View v){
        Button b = (Button) v;
        int content = Integer.parseInt(this.txtValor.getText().toString());
        if(content != 0) {
            this.txtValor.append(b.getText().toString());
        } else {
            this.txtValor.setText(b.getText().toString());
        }
    }

    public void clear(View v){
        this.valorA = null;
        this.valorB = 0;
        this.operacaoAtual = '+';
        this.txtValor.setText("0");
        this.txtValor2.setText("");
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

    public void pressIgual(View v){
        if (this.valorA == null){
            this.valorA = 0;
        }
        if (this.txtValor.getText().toString().isEmpty()){
            this.valorB = 0;
        } else {
            this.valorB = Double.parseDouble(this.txtValor.getText().toString());
        }
        this.txtValor2.setText(Double.toString(calcula(this.valorA, this.valorB).doubleValue()));
        this.txtValor2.append(" " + this.operacaoAtual);
        this.txtValor.setText("0");
    }

}
