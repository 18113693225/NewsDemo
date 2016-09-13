package com.apps.android.news.news.utils.util;

import android.util.Base64;

/**
 * Created by android on 2016/9/13.
 */
public class ParamUtils {


    public static String initParam(String action,String param){
        if(param==null) param = "";
        StringBuffer reqParam = new StringBuffer();
        reqParam.append("<Request action='"+action+"' request='JSON' response='JSON' array='' nohead='true'>");
        reqParam.append("<Data>");
        reqParam.append(param);
        reqParam.append("</Data></Request>");
        return encryptBASE64(reqParam.toString().getBytes());
    }

    /**
     * BASE64加密
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key){
        return Base64.encodeToString(key, Base64.DEFAULT);
    }


}
