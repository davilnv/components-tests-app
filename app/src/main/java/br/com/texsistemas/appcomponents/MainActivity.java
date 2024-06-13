package br.com.texsistemas.appcomponents;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editTextName;
    private TextInputEditText editTextEmail;
    private TextView textResult;
    private CheckBox checkRed, checkBlack, checkWhite;
    private RadioGroup radioGroup;
    private RadioButton radioM, radioF;

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

        radioGroup = findViewById(R.id.radioGroup);
        radioM = findViewById(R.id.radioM);
        radioF = findViewById(R.id.radioF);

        radioButton();
    }

    public void send(View view) {

        radioButton();

    }

    public void radioButton() {

        radioGroup.setOnCheckedChangeListener((radioGroup, i)
                -> textResult.setText(i == R.id.radioM ? radioM.getText().toString() : radioF.getText().toString()));

        /*
        if (radioM.isChecked()) {
            textResult.setText(radioM.getText().toString());
        } else {
            textResult.setText(radioF.getText().toString());
        }

         */

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

    public void editText() {
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