package com.example.group2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*Modified Code from:
Author: Julian Prester
Year: 2019
Link: https://github.com/INFS-3634/Beers
 */

public class FrameworkAdapter extends RecyclerView.Adapter<FrameworkAdapter.FrameworkViewHolder> {
    private FrameworkMain parentActivity;
    private ArrayList<Framework> mFrameworks;
    private boolean twoPane;

    private View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Framework framework = (Framework) view.getTag();
            //If two panes are invoked then append the detail fragment
            if(twoPane){
                Bundle arguments = new Bundle();
                arguments.putString(DetailFragment.ARG_ITEM_ID, framework.getId());
                DetailFragment fragment = new DetailFragment();
                fragment.setArguments(arguments);
                parentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.detail_container, fragment).commit();
            } else {
                Context context = view.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailFragment.ARG_ITEM_ID, framework.getId());
                context.startActivity(intent);
            }
        }
    };

    public FrameworkAdapter(FrameworkMain parent, ArrayList<Framework> frameworks, boolean twoPane){
        parentActivity = parent;
        mFrameworks = frameworks;
        this.twoPane = twoPane;
    }

    public static class FrameworkViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView rowImage;

        public FrameworkViewHolder(View v){
            super(v);
            title = v.findViewById(R.id.frameworkName);
            rowImage = v.findViewById(R.id.frameworkImage);
        }
    }

    //Inflating the view with our customised row
    @Override
    public FrameworkAdapter.FrameworkViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.framework_list_row, parent, false);
        return new FrameworkViewHolder(v);
    }

    //Inserting the relevant widgets to the view based on the item stored on the Framework list
    @Override
    public void onBindViewHolder(FrameworkViewHolder holder, int position){
        Framework framework = mFrameworks.get(position);
        holder.title.setText(framework.getName());
        holder.rowImage.setImageResource(framework.getListImage());
        holder.itemView.setTag(framework);
        holder.itemView.setOnClickListener(onClickListener);
    }

    //Returning the number of items in the Framework list
    @Override
    public int getItemCount(){
        return mFrameworks.size();
    }

}
