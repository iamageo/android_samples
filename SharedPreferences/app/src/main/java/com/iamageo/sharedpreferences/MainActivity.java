package com.iamageo.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //variables
    private EditText mEditText;
    private Button mBtnSave;
    private TextView mSavedTextView;

    public static final String SHARES_PREFS = "sharedPrefs";
    public static final String TEXT = "text";

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide action bar
        getSupportActionBar().hide();

        //call components
        initComponents();

        //onclick button save
        mBtnSave.setOnClickListener(v -> {
            saveData();
        });

        //load saved data for textview
        loadData();
        updateViews();

    }

    //init components using findviewbyid
    public void initComponents() {
        mEditText = findViewById(R.id.textSave);
        mBtnSave = findViewById(R.id.btn_save);
        mSavedTextView = findViewById(R.id.textSaved);
    }

    //saved data using shared preferences and key text
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARES_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, mEditText.getText().toString());
        editor.apply();

        loadData();
        updateViews();
    }

    //load data saved with key specified
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARES_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
    }

    //update textviews with new values
    public void updateViews() {
        mSavedTextView.setText(text);
    }


}