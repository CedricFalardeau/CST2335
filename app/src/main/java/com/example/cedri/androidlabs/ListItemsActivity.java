package com.example.cedri.androidlabs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemsActivity extends Activity {
    protected static final String ACTIVITY_NAME = "ListItemsActivity";
    static final int REQUEST_IMAGE_CAPTURE = 1;


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

        Log.i(ACTIVITY_NAME, "In onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        ImageButton imageButton = (ImageButton) this.findViewById(R.id.imageButton);
        final Switch mySwitch = (Switch) this.findViewById(R.id.mySwitch);
        final CheckBox myCheckbox = (CheckBox) this.findViewById(R.id.myCheckbox);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            dispatchTakePictureIntent();




            }
        });

        mySwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean switchState = mySwitch.isChecked();
                setOnCheckedChanged(switchState);




            }
        });

        myCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean CheckboxState = myCheckbox.isChecked();
                onCheckedChanged(CheckboxState);




            }
        });
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageButton imageButton = (ImageButton) this.findViewById(R.id.imageButton);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageButton.setImageBitmap(imageBitmap);
        }
    }



    void setOnCheckedChanged(boolean isChecked){

        if (isChecked == true){
            CharSequence text = "Switch is On";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this , text, duration);
            toast.show();

        }
        else{
            CharSequence text = "Switch is Off" ;
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this , text, duration);
            toast.show();
        }


    }
    void onCheckedChanged(boolean isChecked){
        if (isChecked == true){
            AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
// 2. Chain together various setter methods to set the dialog characteristics
            builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml

                    .setTitle(R.string.dialog_title)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent resultIntent = new Intent( );
                            resultIntent.putExtra("Response", "Here is my response");
                            setResult(Activity.RESULT_OK, resultIntent);
                            finish();
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    })
                    .show();
        }
        else{

        }
}


        }



