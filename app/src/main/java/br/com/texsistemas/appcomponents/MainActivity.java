package br.com.texsistemas.appcomponents;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editTextName;
    private TextInputEditText editTextEmail;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editName);
        editTextEmail = findViewById(R.id.editEmail);
        textResult = findViewById(R.id.textResult);

    }

    public void send(View view) {

        String name = editTextName.getText() != null ? editTextName.getText().toString() : null;
        String email = editTextEmail.getText() != null ? editTextEmail.getText().toString() : null;

        textResult.setText(String.format("Nome: %s - Email: %s", name, email));

    }

    public void clearFields(View view) {
        editTextName.setText(null);
        editTextEmail.setText(null);
        textResult.setText(null);
    }

}