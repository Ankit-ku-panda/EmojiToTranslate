package com.example.EmojiToTranslate;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private TextView result;
    private Button translate, clear;

    private EmojiTranslator translator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI connect
        input = findViewById(R.id.emojiInput);
        result = findViewById(R.id.resultText);
        translate = findViewById(R.id.translateBtn);
        clear = findViewById(R.id.clearBtn);

        translator = new EmojiTranslator();

        // TRANSLATE BUTTON
        translate.setOnClickListener(v -> {

            // small press animation
            v.animate().scaleX(0.92f).scaleY(0.92f).setDuration(90).withEndAction(() ->
                    v.animate().scaleX(1f).scaleY(1f).setDuration(90)
            );

            String text = input.getText().toString().trim();

            // empty check
            if (TextUtils.isEmpty(text)) {
                result.setText("⚠ Please enter emojis first");
                return;
            }

            // hide keyboard
            hideKeyboard();

            // translate
            String output = translator.translate(text);

            result.setText("Meaning:\n" + output);
        });

        // CLEAR BUTTON
        clear.setOnClickListener(v -> {
            input.setText("");
            result.setText("Your translation will appear here");
            input.requestFocus();
        });
    }

    // Hide mobile keyboard after clicking translate
    private void hideKeyboard() {
        InputMethodManager imm =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        View view = this.getCurrentFocus();
        if (view != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}