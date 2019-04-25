package com.example.group2;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private Framework framework;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments().containsKey(ARG_ITEM_ID)){
            framework = Framework.getFramework(getArguments().getString(ARG_ITEM_ID));
            this.getActivity().setTitle(framework.getName());
        }
        //setContentView(R.layout.activity_detail_fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.activity_detail_fragment, container, false);

        if(framework != null){
            ((ImageView) rootView.findViewById(R.id.mainView)).setImageResource(framework.getDetailImage());
        }
        return rootView;
    }
}
