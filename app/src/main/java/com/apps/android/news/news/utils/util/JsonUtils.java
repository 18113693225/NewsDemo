package com.apps.android.news.news.utils.util;

import android.text.TextUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Created by android on 2016/9/13.
 */
public class JsonUtils {
    private ObjectMapper mMapper = new ObjectMapper();

    public static synchronized JsonUtils get() {
        return SingletonHolder.INSTANCE;
    }

    public <T> T toObject(String json, Class<T> valueType) {
        if (TextUtils.isEmpty(json)) return null;
        try {
            return mMapper.readValue(json, valueType);
        } catch (IOException e) {
            ErrorUtils.handleException(e);
        }
        return null;
    }

    public <T> List<T> toObjectList(String json, Class<T> valueType) {
        if (TextUtils.isEmpty(json)) return null;
        try {
            //List<MyClass> myObjects = Arrays.asList(mapper.readValue(json, MyClass[].class))
            return mMapper.readValue(json,
                    mMapper.getTypeFactory().constructCollectionType(List.class, valueType));
        } catch (Exception e) {
            e.printStackTrace();
            ErrorUtils.handleException(e);
        }
        return null;
    }

    public String toJson(Object value) {
        try {
            return mMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            ErrorUtils.handleException(e);
        }
        return "";
    }

    private static class SingletonHolder {
        private static final JsonUtils INSTANCE = new JsonUtils();
    }
}
