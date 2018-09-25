package com.example.cedri.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
    protected static final String ACTIVITY_NAME = "LoginActivity";


    protected void onResume(){
        Log.i(ACTIVITY_NAME, "In onResume()");
        super.onResume();

    }
    protected void onStart(){
        Log.i(ACTIVITY_NAME, "In onStart()");
        super.onStart();
    }
    protected void onPause(){
        Log.i(ACTIVITY_NAME, "In onPause()");
        super.onPause();
    }
    protected void onStop() {
        Log.i(ACTIVITY_NAME, "In onStop()");
        super.onStop();
    }
    protected void onDestroy(){
        Log.i(ACTIVITY_NAME, "In onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       final SharedPreferences sharedPref = getSharedPreferences("AndroidLabsPref", MODE_PRIVATE);
        Button loginButton = (Button) this.findViewById(R.id.loginButton);

        String Email = sharedPref.getString(getString(R.string.login_name), "email@domain.com");
       final EditText editText = (EditText) findViewById(R.id.loginName);
        editText.setText(Email);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = editText.getText().toString();
                SharedPreferences.Editor edit = sharedPref.edit();
                edit.putString(getString(R.string.login_name), input);
                edit.commit();

                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);


                // click pressed
                // save text from login edit text to shared pref
                // start activity
            }
        });


        Log.i(ACTIVITY_NAME, "In onCreate()");

    }
}
