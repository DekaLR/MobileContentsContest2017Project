package mobile.contents.contest.FragmentActivitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.*;

import mobile.contents.contest.R;


public class MainCelActivity extends Fragment{

    //public static MainCelActivity newInstance() {return new MainCelActivity(); }

    public MainCelActivity() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View Rview = inflater.inflate(R.layout.maincelactivity, container, false);

        return Rview;
    }
}


