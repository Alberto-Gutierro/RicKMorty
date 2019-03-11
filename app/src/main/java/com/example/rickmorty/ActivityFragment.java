package com.example.rickmorty;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class ActivityFragment extends AppCompatActivity {

    int chid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Traemos ChId Y lo enviamos al un Recycler View
        Intent intent = getIntent();
        chid = intent.getIntExtra("CHID",1);



        ViewModel mViewModel = ViewModelProviders.of(this).get(ViewModel.class);
        mViewModel.setChid(chid);

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        TabLayout tabLayout = findViewById(R.id.tabs);

        ViewPager mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ShowCharacter fragment;
            switch (position){
                case 0:
                    fragment = new ShowCharacter();
                    fragment.setChid(chid);
                    return fragment;
                case 1:
                    return new FragmentEnemy();
                default :
                    fragment = new ShowCharacter();
                    fragment.setChid(chid);
                    return fragment;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
