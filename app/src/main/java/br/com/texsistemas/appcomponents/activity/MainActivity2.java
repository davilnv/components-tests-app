package br.com.texsistemas.appcomponents.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.texsistemas.appcomponents.R;

public class MainActivity2 extends AppCompatActivity {

    private ListView listLocation;
    private String[] items = {
            "Recife", "João Pessoa", "Belo Horizonte",
            "São Paulo", "Rio de Janeiro", "Porto Alegre",
            "Curitiba", "Salvador", "Brasília", "Fortaleza",
            "Manaus", "Belém", "Natal", "Florianópolis",
            "Goiânia", "Vitória", "Campinas", "Santos",
            "Londrina", "Cuiabá", "Campo Grande", "Maceió",
            "Lisboa", "Madrid", "Barcelona", "Paris",
            "Londres", "Nova York", "Tóquio", "Sydney",
            "Toronto", "Vancouver", "Buenos Aires", "Cidade do México",
            "Berlim", "Amsterdã", "Dubai", "Xangai", "Hong Kong"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listLocation = findViewById(R.id.listLocation);

        // Criar uma adaptador para a lista
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                items
        );

        // Adicionar o adapater na lista
        listLocation.setAdapter(adapter);

        // Adicionar um clique na lista
        listLocation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedValue = listLocation.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), selectedValue, Toast.LENGTH_LONG).show();
            }
        });

    }

}