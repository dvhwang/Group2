package com.example.group2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/*Modified Code from:
Author: Julian Prester
Year: 2019
Link: https://github.com/INFS-3634/Beers
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        if(savedInstanceState == null){
            Bundle arguments = new Bundle();
            arguments.putString(DetailFragment.ARG_ITEM_ID, getIntent().getStringExtra(DetailFragment.ARG_ITEM_ID));
            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(arguments);

            //Inserting the fragment XML file to the placeholder
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detail_container, fragment)
                    .commit();
        }
    }
}
