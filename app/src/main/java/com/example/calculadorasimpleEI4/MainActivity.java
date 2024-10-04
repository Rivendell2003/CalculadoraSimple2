package com.example.calculadorasimpleEI4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textViewResultado = findViewById(R.id.textViewResultado);

        Button buttonSumar = findViewById(R.id.buttonSumar);
        Button buttonRestar = findViewById(R.id.buttonRestar);
        Button buttonMultiplicar = findViewById(R.id.buttonMultiplicar);
        Button buttonDividir = findViewById(R.id.buttonDividir);
        Button buttonSalir = findViewById(R.id.buttonSalir);

        buttonSumar.setOnClickListener(v -> realizarOperacion("+"));
        buttonRestar.setOnClickListener(v -> realizarOperacion("-"));
        buttonMultiplicar.setOnClickListener(v -> realizarOperacion("*"));
        buttonDividir.setOnClickListener(v -> realizarOperacion("/"));
        buttonSalir.setOnClickListener(v -> finish());
    }

    private void realizarOperacion(String operacion) {
        String num1Str = editTextNumber1.getText().toString();
        String num2Str = editTextNumber2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Por favor, llena los dos campos antes de seguir.", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1, num2;
        try {
            num1 = Double.parseDouble(num1Str);
            num2 = Double.parseDouble(num2Str);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, ingrese números válidos!.", Toast.LENGTH_SHORT).show();
            return;
        }

        double resultado = 0;

        switch (operacion) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    Toast.makeText(this, "Me es imposible  dividir entre ceros.", Toast.LENGTH_SHORT).show();
                    return;
                }
                resultado = num1 / num2;
                break;
        }

        // coloca el resultado a dos decimales si es necesario
        DecimalFormat formato = new DecimalFormat("0");
        textViewResultado.setText("El Resultado es : " + formato.format(resultado));

        // se borran los campos de entrada después de realizar la operación
        editTextNumber1.setText("");
        editTextNumber2.setText("");
    }
}
