package io.inlearn.bottomnavigation;




import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private ProfileFragment profileFragment;
    private NotificationFragment notificationFragment;
    private SettingFragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame =  findViewById(R.id.main_layout);
        mMainNav = findViewById(R.id.main_nav);

        profileFragment = new ProfileFragment();
        notificationFragment = new NotificationFragment();
        settingFragment = new SettingFragment();


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_profile :
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(profileFragment);
                        return true;

                    case R.id.nav_notification:
                        setFragment(notificationFragment);
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        return true;

                    case R.id.nav_setting:
                        setFragment(settingFragment);
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        return true;


                        default:
                            return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_layout,fragment);
        fragmentTransaction.commit();
    }
}
