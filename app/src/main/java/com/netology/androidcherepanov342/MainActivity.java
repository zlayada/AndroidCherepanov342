package com.netology.androidcherepanov342;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner mLanguageText;
    private Button mLanguageBtn;

    private String mLocalLanguage = ""; // Переменная для "флага" локализации языка

    private Spinner mIndentSpinner;
    private int mTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Utils.onActivityCreateApplySettings(this);
        setContentView(R.layout.activity_main);

        initViews();
    }

    // Инициализируем элементы
    public void initViews() {
        mLanguageText = findViewById(R.id.languageText);
        mLanguageBtn = findViewById(R.id.languageBtn);
        mIndentSpinner = findViewById(R.id.indentSpinner);

        initSpinnerLanguage();
        initColorSpinner();

        mLanguageBtn.setOnClickListener(this);

    }
    // Обрабатываем значения спиннера и записываем флаг для локализации
    private void initSpinnerLanguage() {
        ArrayAdapter<CharSequence> adapterLanguages = ArrayAdapter.createFromResource(this,
                R.array.languageText, android.R.layout.simple_spinner_item);

        adapterLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mLanguageText.setAdapter(adapterLanguages);
        mLanguageText.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String[] languages = getResources().getStringArray(R.array.languageText);

                if (languages[i].equals(getString(R.string.eng))) {
                    mLocalLanguage = "en";

                } if (languages[i].equals(getString(R.string.rus))) {
                    mLocalLanguage = "ru";

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    // Обрабатываем значение спиннера выбора темы
    private void initColorSpinner() {
        ArrayAdapter<CharSequence> adapterColors = ArrayAdapter.createFromResource(this,
                R.array.indentSpinner, android.R.layout.simple_spinner_item);

        adapterColors.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mIndentSpinner.setAdapter(adapterColors);

        mIndentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String[] indents = getResources().getStringArray(R.array.indentSpinner);

                if (indents[i].equals(getString(R.string.small))) {
                    mTheme = Utils.THEME_SMALL;
                }

                if (indents[i].equals(getString(R.string.average))) {
                    mTheme = Utils.THEME_AVERAGE;
                }

                if (indents[i].equals(getString(R.string.big))) {
                    mTheme = Utils.THEME_BIG;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    public void onClick(View view) {

        Utils.changeSettings(this, mTheme, mLocalLanguage);
    }
}