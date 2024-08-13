package br.com.texsistemas.appcomponents;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editTextName;
    private TextInputEditText editTextEmail;
    private TextView textResult, textViewPassResult;
    private CheckBox checkRed, checkBlack, checkWhite;
    private RadioGroup radioGroup;
    private RadioButton radioM, radioF;
    private ToggleButton toggleButtonPass;
    private SwitchCompat switchButtonPass;
    private ProgressBar progressBarHorizontal, progressBaCircular;
    private int progress = 0;

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

        toggleButtonPass = findViewById(R.id.toggleButtonPass);
        switchButtonPass = findViewById(R.id.switchButtonPass);
        textViewPassResult = findViewById(R.id.textViewPassResult);

        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        progressBaCircular = findViewById(R.id.progressBaCircular);
        progressBaCircular.setVisibility(View.GONE);

        // Antes era utilizado o new com a interface, da seguinte forma :
        /*
        * switchButtonPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                switchButton();
            }
        });
        * */
        // Atualmente é possível utilizar lambda dependendo da versão do java utilizado.
        switchButtonPass.setOnCheckedChangeListener((compoundButton, b) -> switchButton());

        radioButton();
    }

    public void send(View view) {

        switchButton();

    }

    public void loadProgressBar(View view) {
        progress += 1;
        progressBarHorizontal.setProgress(progress);

        progressBaCircular.setVisibility(View.VISIBLE);

        if (progress == 10)
            progressBaCircular.setVisibility(View.GONE);
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

    public void switchButton() {
        if (switchButtonPass.isChecked()) {
            textViewPassResult.setText("Toggle ligado!");
        } else {
            textViewPassResult.setText("Está desligado");
        }
    }

    public void showToast(View view) {
        //Toast.makeText(getApplicationContext(), "Teste de exibição de TOAST!", Toast.LENGTH_LONG).show();

        // Criando um Toast personalizado

        ImageView image = new ImageView(getApplicationContext());
        image.setImageResource(android.R.drawable.star_big_off);

        TextView textView = new TextView(getApplicationContext());
        textView.setText("Olá, teste TOAST!");

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(image); // Aqui pode ser view de diferentes formas, se quiser exibir algo personalizado.
        toast.show();

    }

    public void showAlertDialog(View view) {

        // Recebe um context , mas o contexto da Acitity
        // Utiliza a classe Builder para instanciar o alert
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Título do diálogo");
        dialog.setMessage("Mensagem do diálogo!");

        // Configurar o cancelamento - Obriga o uso da ação positiva ou negativa
        dialog.setCancelable(false);

        // Configurar um icone
        dialog.setIcon(android.R.drawable.ic_btn_speak_now);

        // Métodos de resposta, positiva e negativa
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Confirmado a ação!", Toast.LENGTH_LONG).show();
            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Negado a ação!", Toast.LENGTH_LONG).show();
            }
        });

        // Cria e exibe o dialog
        dialog.create();
        dialog.show();

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