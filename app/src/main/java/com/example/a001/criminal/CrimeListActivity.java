package com.example.a001.criminal;

import android.support.v4.app.Fragment;

/**
 * Created by claylin on 4/3/15.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

}
