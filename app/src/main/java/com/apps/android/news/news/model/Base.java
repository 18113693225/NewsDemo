package com.apps.android.news.news.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by android on 2016/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Base implements Parcelable {

    public String userId;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
    }

    public Base() {
    }

    protected Base(Parcel in) {
        this.userId = in.readString();
    }

    public static final Parcelable.Creator<Base> CREATOR = new Parcelable.Creator<Base>() {
        @Override
        public Base createFromParcel(Parcel source) {
            return new Base(source);
        }

        @Override
        public Base[] newArray(int size) {
            return new Base[size];
        }
    };
}
