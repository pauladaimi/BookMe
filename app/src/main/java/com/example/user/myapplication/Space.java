package com.example.user.myapplication;

import android.util.Log;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Space {

    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("spots")
    @Expose
    private List<Spot> spots = null;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public String toString(){
        String SpaceString="";
        for(int i=0; i<spots.size();i++){
            SpaceString+= spots.get(i).getX()+" " +spots.get(i).getY() ;
        }

        SpaceString+=" "+getInfo().getName();

        return SpaceString;
    }

}