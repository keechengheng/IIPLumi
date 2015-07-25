package com.example.jiahui.iiplumi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.Timer;
import java.util.TimerTask;


public class HomeActivity extends AppCompatActivity {

    //Defining Variables

    // Toolbar & Navigation Drawer
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Context context;

    // Image Slide Show
    private ImageSwitcher imageSwitcher;
    private int[] gallery = {R.drawable.home_head1, R.drawable.home_head2, R.drawable.home_head3,
            R.drawable.home_head4, R.drawable.home_head5, R.drawable.home_head6,
            R.drawable.home_head7, R.drawable.home_head8};
    private int position = 0;
    private Timer timer = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);                   // Setting toolbar as the ActionBar with setSupportActionBar() call
        //toolbar.getBackground().setAlpha(0);          // Set transparent toolbar

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {

                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.home:
                        Toast.makeText(getApplicationContext(), "Home Selected", Toast.LENGTH_SHORT).show();
                        /*ContentFragment fragment = new ContentFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame, fragment);
                        fragmentTransaction.commit();*/
                        Intent i = new Intent(HomeActivity.this, HomeActivity.class);
                        startActivity(i);
                        overridePendingTransition(R.animator.anim_15_appear, R.animator.anim_2_fadeout);
                        return true;

                    // For rest of the options we just show a toast on click
                    case R.id.settings:
                        //Toast.makeText(getApplicationContext(), "Settings Selected", Toast.LENGTH_SHORT).show();
                        Intent ii = new Intent(HomeActivity.this, SettingsActivity.class);
                        startActivity(ii);
                        overridePendingTransition(R.animator.anim_15_appear, R.animator.anim_2_fadeout);
                        return true;
                    case R.id.options:
                        //Toast.makeText(getApplicationContext(), "Options Selected", Toast.LENGTH_SHORT).show();
                        Intent iii = new Intent(HomeActivity.this, OptionsActivity.class);
                        startActivity(iii);
                        overridePendingTransition(R.animator.anim_15_appear, R.animator.anim_2_fadeout);
                        return true;
                    case R.id.logout:
                        //Toast.makeText(getApplicationContext(), "Logout Selected", Toast.LENGTH_SHORT).show();

                        // Alert Dialog for Logout
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(navigationView.getContext());
                        alertDialogBuilder.setTitle("Logout!");
                        alertDialogBuilder.setIcon(R.drawable.alert_warningicon);
                        alertDialogBuilder.setMessage("Are you sure you want to logout?");
                        alertDialogBuilder.setCancelable(false);
                        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // if this button is clicked, go back to login page
                                Intent iv = new Intent(HomeActivity.this, LoginActivity.class);
                                startActivity(iv);
                                overridePendingTransition(R.animator.anim_15_appear, R.animator.anim_2_fadeout);
                                finish();
                            }
                        });
                        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // if this button is clicked, just close
                                dialog.dismiss();
                            }
                        });
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();

                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


        // Image Slide Show codes
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                return new ImageView(HomeActivity.this);
            }
        });

        // Set animations http://danielme.com/2013/08/18/diseno-android-transiciones-entre-activities/
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.abc_fade_in);
        Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.abc_fade_out);
        imageSwitcher.setInAnimation(fadeIn);
        imageSwitcher.setOutAnimation(fadeOut);

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                // avoid exception: "Only the original thread that created a view hierarchy can touch its views"
                runOnUiThread(new Runnable() {
                    public void run() {
                        imageSwitcher.setImageResource(gallery[position]);
                        position++;
                        if (position == 8) {
                            position = 0;
                        }
                    }
                });
            }

        }, 0, 2500);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onProfileButtonClick(View v) {
        Intent i = new Intent(HomeActivity.this, ProfileActivity.class);
        startActivity(i);
    }

    public void onJobButtonClick(View v) {
        Intent i = new Intent(HomeActivity.this, JobActivity.class);
        startActivity(i);
    }

    public void onPaymentButtonClick(View v) {
        Intent i = new Intent(HomeActivity.this, PaymentActivity.class);
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

        if (id == R.id.action_search) {
            // to be done....

        }

        return super.onOptionsItemSelected(item);
    }
}
