package com.example.cad_prod;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextTextProdutoName;
    EditText editTextTextProdutoPreco;

    CheckBox checkBox1;
    Button button;

    private String textSimNao;
    private String nomeProduto;
    private String precoProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editTextTextProdutoName = (EditText) findViewById(R.id.editTextTextProdutoName);
        editTextTextProdutoPreco = (EditText) findViewById(R.id.editTextTextProdutoPreco);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        textSimNao = "";

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarMSG();

            }


        });
    }


    public void enviarMSG(){
        AlertDialog.Builder msg = new AlertDialog.Builder(this);

        nomeProduto = editTextTextProdutoName.getText().toString();
        precoProduto = editTextTextProdutoPreco.getText().toString();

        if (nomeProduto.matches("")){
            nomeProduto = "Sem Informação";
        }
        if (precoProduto.matches("")){
            precoProduto = "Sem Informação";
        }

        boolean test = checkBox1.isChecked();

        if (test)
            textSimNao = "Sim";
        else
            textSimNao = "Não";

        msg.setMessage("Dados Informados: " + "\n" + " " + "\n" + "Nome do Produto: " + nomeProduto + "\n" + "Preço do Produto: " + precoProduto + "\n" + "Produto Importado:" + textSimNao);

        msg.show();
    }
}