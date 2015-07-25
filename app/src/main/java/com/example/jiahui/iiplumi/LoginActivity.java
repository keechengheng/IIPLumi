package com.example.jiahui.iiplumi;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.text.style.UnderlineSpan;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textview = (TextView)findViewById(R.id.SignUpbutton);
        SpannableString content = new SpannableString(getText(R.string.under_SignUp));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textview.setText(content);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    public void onLoginButtonClick(View v) {
        //if (v.getId() == R.id.loginbutton) {
        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(i);

        overridePendingTransition(R.animator.anim_1_fadein, R.animator.anim_2_fadeout);
    }

    public void onSignUpButtonClick(View v) {
        Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(i);
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

        return super.onOptionsItemSelected(item);

    }
}
