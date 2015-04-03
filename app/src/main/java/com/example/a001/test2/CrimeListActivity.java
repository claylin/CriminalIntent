package com.example.a001.test2;

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
