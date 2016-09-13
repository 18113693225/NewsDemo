package com.apps.android.news.news.model;

import android.os.Parcel;

import com.smartydroid.android.starter.kit.model.entity.Entity;

/**
 * Created by android on 2016/9/13.
 */
public class Table extends Entity {
    public String name;
    public Integer index;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeValue(this.index);
    }

    public Table() {
    }

    protected Table(Parcel in) {
        this.name = in.readString();
        this.index = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Table> CREATOR = new Creator<Table>() {
        @Override
        public Table createFromParcel(Parcel source) {
            return new Table(source);
        }

        @Override
        public Table[] newArray(int size) {
            return new Table[size];
        }
    };
}
