package com.apps.android.news.news.model;

import android.os.Parcel;

import com.apps.android.news.news.utils.util.JsonUtils;
import com.smartydroid.android.starter.kit.account.Account;
import com.smartydroid.android.starter.kit.model.entity.Entity;

/**
 * Created by android on 2016/9/13.
 */
public class User extends Entity implements Account {

    public Integer ids;
    public  String name;

    @Override
    public String token() {
        return null;
    }

    @Override
    public Object key() {
        return null;
    }

    @Override
    public String toJson() {
        return JsonUtils.get().toJson(this);
    }

    public User() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.ids);
        dest.writeString(this.name);
    }

    protected User(Parcel in) {
        this.ids = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
