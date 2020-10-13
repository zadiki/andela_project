package com.zitafutemain.andeleproject.Adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.zitafutemain.andeleproject.ui.fragments.IqScoreFragment;
import com.zitafutemain.andeleproject.ui.fragments.LearnersFragment;

public  class CustomViewPagerAdapter extends FragmentStatePagerAdapter {
    public CustomViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new LearnersFragment(); ;
        switch (i){
            case 0:
                fragment= new LearnersFragment();
                break;
            case 1:
                fragment= new IqScoreFragment();
                break;
        }
        return fragment;


    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title="";
        switch (position){
            case 0:
                title="Learning Leaders";
                break;
            case 1:
                title="Skill IQ Leaders";
                break;
        }
        return title;
    }
}