package com.arteyciencia.a2jqch.derechobolivia;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AsignaturasFragment.OnFragmentInteractionListener, LeyesFragment.OnFragmentInteractionListener, View.OnClickListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private FloatingActionButton fab,op1,op2,op3;
    Animation FabOpen,FabClose,FabRClockwise,FabRanticlockwise; //me quede en esta parte del tutorial
    boolean isOpen=false; //usaremos esta variable para los fab buttons
    private Intent intent;//usaremos este intent para acceder a otras activitys
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        op1=(FloatingActionButton)findViewById(R.id.op1);
        op2=(FloatingActionButton)findViewById(R.id.op2);
        op3=(FloatingActionButton)findViewById(R.id.op3);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        FabClose= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        FabRClockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        FabRanticlockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);
        fab.setOnClickListener(this);
        op1.setOnClickListener(this);
        op2.setOnClickListener(this);
        op3.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                if(isOpen){
                    op1.startAnimation(FabClose);
                    op2.startAnimation(FabClose);
                    op3.startAnimation(FabClose);
                    fab.startAnimation(FabRanticlockwise);
                    op1.setClickable(false);
                    op2.setClickable(false);
                    op3.setClickable(false);
                    isOpen=false;
                }
                else{
                    op1.startAnimation(FabOpen);
                    op2.startAnimation(FabOpen);
                    op3.startAnimation(FabOpen);
                    fab.startAnimation(FabRClockwise);
                    op1.setClickable(true);
                    op2.setClickable(true);
                    op3.setClickable(true);
                    isOpen=true;
                  /*  if(resCampanilla!=0){
                        spCampanilla.play(resCampanilla,1,1,0,0,1);
                    }*/
                }
                break;
            case R.id.op1:
                //intent=new Intent(getApplicationContext(),PreguntasActivity.class);
                //startActivity(intent);
                break;
            case R.id.op2:
                Toast.makeText(getApplicationContext(),"La informática es el arte de controlar la complejidad",Toast.LENGTH_LONG).show();
                break;
            case R.id.op3:
                Intent faceIntent= getOpenFacebookIntent(MainActivity.this);
                startActivity(faceIntent);
                break;
        }
    }
    public static Intent getOpenFacebookIntent(Context context) {//este método abre nuestra página de facebook
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/165373163880374"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/cotillones360"));
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment newInstance(int sectionNumber) {
            Fragment fragment=null;
            switch (sectionNumber){
                case 1:
                    fragment=new AsignaturasFragment();
                    break;
                case 2:
                    fragment=new LeyesFragment();
                    break;
                case 3:
                    fragment=new LeyesFragment();
                    break;

            }
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);

            return fragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "ASIGNATURAS";
                case 1:
                    return "LEYES";
                case 2:
                    return "PLANTILLAS";
            }
            return null;
        }
    }
}
