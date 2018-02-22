package com.example.luca.tabsfragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    public boolean onSupportNavigateUp() {

        finish();
      //  onBackPressed();
        return true;
    }

    /*private int[] tabIcons = {
                    R.drawable.ic_tab_favourite,
                    R.drawable.ic_tab_call,
                    R.drawable.ic_tab_contacts
            };*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String actualUser = intent.getStringExtra("User");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager,actualUser);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        //hide tab for User log
        //((ViewGroup) tabLayout.getChildAt(0)).getChildAt(0).setVisibility(View.GONE);
        //setupTabIcons();

    }

    private void setupViewPager(ViewPager viewPager,String user) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        if(user.equalsIgnoreCase("User1")){
            adapter.addFragment(new TwoFragment(), "TWO");
            adapter.addFragment(new ThreeFragment(), "THREE");
        }else{
            adapter.addFragment(new OneFragment(), "ONE");
            adapter.addFragment(new TwoFragment(), "TWO");
        }


        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }



        /*private void setupTabIcons() {
            tabLayout.getTabAt(0).setIcon(tabIcons[0]);
            tabLayout.getTabAt(1).setIcon(tabIcons[1]);
            tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        }*/
    }
}
