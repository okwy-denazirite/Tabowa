package com.hellohasan.sqlite_multiple_three_tables_crud.mainTabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class myPagerAdapter extends FragmentPagerAdapter {
    private  int numberoftabs;

    public myPagerAdapter(@NonNull FragmentManager fm, int  numberoftabs) {
        super(fm);
        this.numberoftabs = numberoftabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return  new tab1();
            case 1:
                return  new tab2();
            case 2:
                return  new tab3();
            default:
                return  null;
        }

    }

    @Override
    public int getCount() {
        return numberoftabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
