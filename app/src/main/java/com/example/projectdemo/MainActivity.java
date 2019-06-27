package com.example.projectdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private List<Fragment> fragments;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("首 页").setIcon(R.drawable.menu_home));
        tabLayout.addTab(tabLayout.newTab().setText("视 频").setIcon(R.drawable.menu_video));
        tabLayout.addTab(tabLayout.newTab().setText("推 荐").setIcon(R.drawable.menu_recommend));
        tabLayout.addTab(tabLayout.newTab().setText("我").setIcon(R.drawable.menu_me));

        fragments=new ArrayList<Fragment>();
        fragments.add(new HomeFragment());
        fragments.add(new VideoFragment());
        fragments.add(new RecommendFragment());
        fragments.add(new MeFragment());

        MyAdapter myAdapter=new MyAdapter(getSupportFragmentManager());
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(myAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for (int i=0;i<tabLayout.getTabCount();i++){
                    if (tab==tabLayout.getTabAt(i))
                        viewPager.setCurrentItem(i);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }
    class  MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    }
