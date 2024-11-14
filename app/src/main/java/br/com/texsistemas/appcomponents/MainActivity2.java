package br.com.texsistemas.appcomponents;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private ListView listLocation;
    private String[] items = {"Recife", "João Pessoa", "Belo Horizonte"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listLocation = findViewById(R.id.listLocation);

        // Criar uma adaptador para a lista
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1
        );

    }

}