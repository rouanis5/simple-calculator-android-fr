package com.example.exo1_tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button[] buttons = {
            findViewById(R.id.plusBtn),
            findViewById(R.id.minusBtn),
            findViewById(R.id.multiplyBtn),
            findViewById(R.id.devisionBtn)
        };
        for (Button button: buttons) {
            button.setOnClickListener(this);
        }
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v){
        TextView resultView = findViewById(R.id.resultView);
        EditText n1View = findViewById(R.id.operand1),
                n2View = findViewById(R.id.operand2);

        if (n1View.getText().toString().matches("") || n2View.getText().toString().matches("")){
            Toast.makeText(MainActivity.this, "remplissez les operands", Toast.LENGTH_LONG).show();
            return;
        }
        Double n1 = Double.parseDouble(n1View.getText().toString()),
                n2 = Double.parseDouble(n2View.getText().toString()),
                res = null;
        switch (v.getId()){
            case R.id.plusBtn:
                res = n1 + n2;
                break;
            case R.id.minusBtn:
                res = n1 - n2;
                break;
            case R.id.multiplyBtn:
                res = n1 * n2;
                break;
            case R.id.devisionBtn:
                if (n2 == 0) {
                    Toast.makeText(MainActivity.this, "le 2eme operand doit être different de 0", Toast.LENGTH_LONG).show();
                    break;
                }
                res = n1 / n2;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
        if (res == null) return;
        Toast.makeText(MainActivity.this, "res = " + res.toString(), Toast.LENGTH_LONG).show();
        resultView.setText(res.toString());
    }
}