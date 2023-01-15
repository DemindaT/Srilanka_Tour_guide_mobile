package com.example.egypttourguide;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.egypttourguide.alexandria.AlexandriaFragment;
import com.example.egypttourguide.aswan.AswanFragment;
import com.example.egypttourguide.cairo.CairoFragment;
import com.example.egypttourguide.luxor.LuxorFragment;
import com.example.egypttourguide.siwa.SiwaFragment;

public class PlacesAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    final Context mContext;

    public PlacesAdapter(Context context, @NonNull FragmentManager fm) {
        super (fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AlexandriaFragment ();
        } else if (position == 1) {
            return new CairoFragment ();
        }
        else {
            return new AswanFragment ();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString (R.string.alexandria);
        } else if (position == 1) {
            return mContext.getString (R.string.cairo);

        } else {
            return mContext.getString (R.string.aswan);
        }
    }
}
