package com.exemplo.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    private EditText edit_nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_nome = findViewById(R.id.edit_nome);
    }

    public void salvarDados(View view) {
        String nome = edit_nome.getText().toString();
        if(!nome.isEmpty()) {
            // name: Nome do arquivo de SharedPreferences a ser criado
            // mode 0: Apenas este app tem permissão para leitura e gravação neste arquivo
            SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("meu_nome", nome);
            editor.apply();

            Toast.makeText(this, "Arquivo de SharedPreferences gravado com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            edit_nome.setError("Informe seu nome");
        }
    }
}