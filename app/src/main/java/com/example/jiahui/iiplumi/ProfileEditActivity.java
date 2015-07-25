package com.example.jiahui.iiplumi;

import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;


public class ProfileEditActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Spinner genderSpinner, bankaccSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void addListenerOnSpinnerItemSelection() {
        genderSpinner = (Spinner) findViewById(R.id.genderSpinner);
        genderSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        bankaccSpinner = (Spinner) findViewById(R.id.bankaccSpinner);
        bankaccSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            //overridePendingTransition(R.animator.anim_11_slideinleft, R.animator.anim_14_slideoutright);
            //overridePendingTransition(R.animator.anim_10_rightin, R.animator.anim_9_rightout);
        }

        return super.onOptionsItemSelected(item);
    }
}
