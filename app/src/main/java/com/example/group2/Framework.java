package com.example.group2;

import android.widget.ImageView;

import java.util.ArrayList;

public class Framework {
    //Introducing attributes
    private String id;
    private String name;
    private ImageView image;

    //Empty Constructor - Best Practice
    public Framework(){

    }

    public Framework(String id, String name, ImageView image){
        this.id = id;
        this.name = name;
        this.image = image;
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

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    //Method to return all the frameworks
    public static Framework getFramework(String id){
        for (Framework framework : getFramework()){
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

    public static ArrayList<Framework> getFramework(){
        ArrayList<Framework> frameworks = new ArrayList<>();
        frameworks.add("y8oeui", "MECEs", R.drawable.);
        frameworks.add("ufhi89", "Profitability Tree", R.drawable);
        frameworks.add("mci08w", "Porter's Five Forces", R.drawable);
        frameworks.add("dui983", "4Ps Marketing Mix", R.drawable);
        return frameworks;
    }


}
