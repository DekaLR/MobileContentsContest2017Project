package mobile.contents.contest;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import mobile.contents.contest.FragmentActivitys.MainCelActivity;
import mobile.contents.contest.FragmentActivitys.MainConvertActivity;
import mobile.contents.contest.FragmentActivitys.MainFragmentActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment fragment_main_temp = new MainFragmentActivity();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.mainfragment, fragment_main_temp);
        transaction.addToBackStack(null);
        transaction.commit();

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Toast.makeText(this, "Back 버튼을 한번 더 누르시면 종료됩니다", Toast.LENGTH_SHORT).show();

            moveTaskToBack(true);
            finish();
            //android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        Fragment fragment = null;
        String title = getString(R.string.app_name);

        if (id == R.id.nav_maincelactivity) {
            fragment = new MainCelActivity();
            title = "MainCelActivity";
            //ActionBar(ToolBar)에 타이틀 텍스트 적용
            if(getSupportActionBar() != null) {
                getSupportActionBar().setTitle(title);
                getSupportActionBar().setBackgroundDrawable( new ColorDrawable(Color.parseColor("#4885ed")));
            }
        } else if (id == R.id.nav_2) {
            fragment = new MainConvertActivity();
            title = "MainConvertActivity";
            //ActionBar(ToolBar)에 타이틀 텍스트 적용
            if(getSupportActionBar() != null) {
                getSupportActionBar().setTitle(title);
                getSupportActionBar().setBackgroundDrawable( new ColorDrawable(Color.parseColor("#ec407a")));
            }
        } else if (id == R.id.nav_3) {

            //ActionBar(ToolBar)에 타이틀 텍스트 적용
            if(getSupportActionBar() != null) {
                getSupportActionBar().setTitle(title);
                getSupportActionBar().setBackgroundDrawable( new ColorDrawable(Color.parseColor("#673ab7")));
            }
        } else if (id == R.id.nav_4) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        if(fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainfragment, fragment);
            ft.addToBackStack(null); //text code
            ft.commit();
        }

        //ActionBar(ToolBar)에 타이틀 텍스트 적용
        /*if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setBackgroundDrawable( new ColorDrawable(Color.parseColor("#4885ed")));
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
