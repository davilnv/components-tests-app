package br.com.texsistemas.appcomponents;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editTextName;
    private TextInputEditText editTextEmail;
    private TextView textResult;
    private CheckBox checkRed, checkBlack, checkWhite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editName);
        editTextEmail = findViewById(R.id.editEmail);
        textResult = findViewById(R.id.textResult);

        checkRed = findViewById(R.id.checkRed);
        checkBlack = findViewById(R.id.checkBlack);
        checkWhite = findViewById(R.id.checkWhite);

    }

    public void checkBox() {

        boolean resultRed = checkRed.isChecked();
        boolean resultBlack = checkBlack.isChecked();
        boolean resultWhite = checkWhite.isChecked();

        String result = "";

        if (resultRed) {
            result += checkRed.getText().toString();
        }

        if (resultBlack) {
            result += checkBlack.getText().toString();
        }

        if (resultWhite) {
            result += checkBlack.getText().toString();
        }


        textResult.setText(String.format("Cores selecionadas: %s", result));

    }

    public void send(View view) {

        checkBox();

        /*
        String name = editTextName.getText() != null ? editTextName.getText().toString() : null;
        String email = editTextEmail.getText() != null ? editTextEmail.getText().toString() : null;

        textResult.setText(String.format("Nome: %s - Email: %s", name, email));
         */

    }

    public void clearFields(View view) {
        editTextName.setText(null);
        editTextEmail.setText(null);
        textResult.setText(null);
    }

}