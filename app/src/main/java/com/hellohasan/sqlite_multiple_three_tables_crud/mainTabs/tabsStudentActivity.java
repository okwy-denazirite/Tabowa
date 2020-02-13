package com.hellohasan.sqlite_multiple_three_tables_crud.mainTabs;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
//import androidx.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.hellohasan.sqlite_multiple_three_tables_crud.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class tabsStudentActivity extends AppCompatActivity {

    TabLayout mTabLayout;
    private ViewPager mViewPager;
    TabItem mTab1, mTab2, mTab3;
    public PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs_student);
        mTabLayout = findViewById(R.id.tabLayout);
        mTab1 = findViewById(R.id.Tab1);
        mTab2 = findViewById(R.id.Tab2);
        mTab3 = findViewById(R.id.Tab3);
        mViewPager = findViewById(R.id.viewpager);
        mPagerAdapter = new myPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(mPagerAdapter);

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0)
                {
                    mPagerAdapter.notifyDataSetChanged();
                }
                else  if (tab.getPosition() == 1)
                {
                    mPagerAdapter.notifyDataSetChanged();
                }
                else  if (tab.getPosition() == 2)
                {
                    mPagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

}
}
