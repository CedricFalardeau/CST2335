package com.example.cedri.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends Activity {
    protected static final String ACTIVITY_NAME = "StartActivity";
 protected void onResume(){
     Log.i(ACTIVITY_NAME, "In onResume()");
     super.onResume(); }
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

     Log.i(ACTIVITY_NAME, "In onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button button = (Button) this.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);
                startActivityForResult(intent,50);




            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode== 50){
            Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult");
        }
        if ( resultCode== Activity.RESULT_OK){
            String messagePassed = data.getStringExtra("Response");

            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this , messagePassed, duration);
            toast.show();

        }
    }
}
