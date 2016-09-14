package com.apps.android.news.news.model;

import android.os.Parcel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smartydroid.android.starter.kit.model.entity.Entity;

import java.util.ArrayList;

/**
 * Created by android on 2016/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channels extends Entity {

    public ArrayList<Table> channels;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.channels);
    }

    public Channels() {
    }

    protected Channels(Parcel in) {
        this.channels = in.createTypedArrayList(Table.CREATOR);
    }

    public static final Creator<Channels> CREATOR = new Creator<Channels>() {
        @Override
        public Channels createFromParcel(Parcel source) {
            return new Channels(source);
        }

        @Override
        public Channels[] newArray(int size) {
            return new Channels[size];
        }
    };
}
