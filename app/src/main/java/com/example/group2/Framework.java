package com.example.group2;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.util.ArrayList;

public class Framework {
    //Introducing attributes
    private String id;
    private String name;
    private int listImage;
    private int detailImage;

    //Empty Constructor - Best Practice
    public Framework(){

    }

    public Framework(String id, String name, int listImage, int detailImage){
        this.id = id;
        this.name = name;
        this.listImage = listImage;
        this.detailImage = detailImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getListImage() {
        return listImage;
    }

    public void setListImage(int listImage) {
        this.listImage = listImage;
    }

    public int getDetailImage() {
        return detailImage;
    }

    public void setDetailImage(int detailImage) {
        this.detailImage = detailImage;
    }

    //Method to return all the frameworks
    public static Framework getDummyFramework(String id){
        for (Framework framework : getDummyFrameworks()){
            if (framework.getId().equals(id)){
                return framework;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return id;
    }

    public static ArrayList<Framework> getDummyFrameworks(){
        ArrayList<Framework> frameworks = new ArrayList<>();
        frameworks.add(new Framework("y8oeui", "MECEs",R.drawable.mece,R.drawable.frameworks_1));
        frameworks.add(new Framework("ufhi89", "Profitability Tree", R.drawable.tree, R.drawable.frameworks_3));
        frameworks.add(new Framework("mci08w", "Porter's Five Forces", R.drawable.porterfive, R.drawable.frameworks_4));
        frameworks.add(new Framework("dui983", "4Ps Marketing Mix", R.drawable.ps, R.drawable.frameworks_5));
        return frameworks;
    }


}
