package sg.edu.rp.c346.id20032316.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Obtain the SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //Retrieve saved data from the SharedPreferences
        String msg = prefs.getString("greeting", "No greeting name");
        Toast.makeText(MainActivity.this, msg,Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        //Obtain the SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //Create a SharedPreference Editor by calling edit()
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Set a key-value pair in the editor
        prefEdit.putString("greetings", "Hello");
        //Call commit() to save the change made
        prefEdit.commit();
    }
}