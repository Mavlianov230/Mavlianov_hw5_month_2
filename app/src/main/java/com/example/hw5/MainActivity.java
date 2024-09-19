package com.example.hw5;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
private TextView textView;
private Double first, second;
private Boolean isOperationClick;
private String operation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.text_view);
        isOperationClick = false;
        operation = "0";

    }

    public void onNumberClick(View view){
        String text = ((MaterialButton)view).getText().toString();
        if (text.equals("AC")){
            textView.setText("0");
            first = (double) 0;
            second = (double) 0;
        } else if (textView.getText().toString().equals("0") || isOperationClick){
            textView.setText(text);
        }else {
            textView.append(text);
        }
        isOperationClick = false;
    }
  public void onOperationClick(View view){
        String text = ((MaterialButton)view).getText().toString();

      if (!text.equals("=")) {
          first = Double.valueOf(textView.getText().toString());
          operation = text;
          isOperationClick = true;

      }else {
          second = Double.valueOf(textView.getText().toString());
          Double result = (double) 0;

          switch (operation) {
              case "+":
                  result = first + second;
                  break;

              case "-":
                  result = first - second;
                  break;

              case "x":
                  result = first * second;
                  break;

              case "/":
                  if (second != 0) {
                      result = first / second;

                  }else {
                      textView.setText("Error");
                      return;
                  }
                  break;
          }

          textView.setText(result.toString());
          isOperationClick = true;
      }

  }

}
