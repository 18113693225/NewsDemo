package com.apps.android.news.news.model;

import android.os.Parcel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartydroid.android.starter.kit.model.entity.Entity;

/**
 * Created by android on 2016/9/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Table extends Entity {
    public String id;
    public String name;
    public String orderId;
    public String isSelected;
    @JsonProperty("_ID")
    public String ID;

    public Table() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.orderId);
        dest.writeString(this.isSelected);
        dest.writeString(this.ID);
    }

    protected Table(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.orderId = in.readString();
        this.isSelected = in.readString();
        this.ID = in.readString();
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
