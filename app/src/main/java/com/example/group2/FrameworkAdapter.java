package com.example.group2;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class FrameworkAdapter extends RecyclerView.Adapter<FrameworkAdapter.FrameworkViewHolder> {
    private FrameworkMain parentActivity;
    private ArrayList<Framework> frameworks;
    private boolean twoPanes;
}
