package com.apps.android.news.news.api.service;

import com.apps.android.news.news.api.ApiService;
import com.apps.android.news.news.model.DSFAModel;
import com.apps.android.news.news.utils.util.ParamUtils;
import com.apps.android.news.news.utils.util.StringUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/18.
 */
public class DSFAServiceManager {
    /**
     * 获取用户所有频道
     */
    private static final String GET_LABLES = "news\\actions\\mobile\\actions\\channels.xml";
    /**
     * 获取用户频道所对应的新闻
     */
    private static final String GET_USER_LABEL_NEWS = "news\\actions\\mobile\\actions\\getUserLabelNewsByAndroid.xml";

    /**
     * 查询所有频道标签
     * @param dsfaCallback
     */
    public static void getLables(DSFACallback dsfaCallback){
        String param = ParamUtils.initParam(GET_LABLES,null);
        doPost(param,dsfaCallback);
    }

    /**
     * 获取用户关注频道的新闻
     * @param userId
     * @param lableId
     * @param dsfaCallback
     */
    public static void getNewsByUserId(String userId,String lableId,DSFACallback dsfaCallback){
        if(StringUtils.isBlank(userId)){
            dsfaCallback.error(new DSFAError("用户ID为空!"));
            return;
        }
        if(StringUtils.isBlank(lableId)){
            dsfaCallback.error(new DSFAError("频道ID为空!"));
            return;
        }
        String param = "{userId:'"+userId+"',labelId:'"+lableId+"'}";
        String reqParam = ParamUtils.initParam(GET_USER_LABEL_NEWS,param);
        doPost(reqParam,dsfaCallback);
    }

    private static void doPost(String param, final DSFACallback dsfaCallback){
        Call<DSFAModel> dsfaModelCall = ApiService.createDSFAService().doPost(param);
        dsfaModelCall.enqueue(new Callback<DSFAModel>() {
            @Override
            public void onResponse(Call<DSFAModel> call, Response<DSFAModel> response) {
                DSFAModel model = response.body();
                dsfaCallback.success(model);
            }

            @Override
            public void onFailure(Call<DSFAModel> call, Throwable t) {
                String msg = t.getMessage();
                DSFAError dsfaError = new DSFAError(msg);
                dsfaCallback.error(dsfaError);
            }
        });
    }

    public interface DSFACallback{
        public void success(DSFAModel dsfaModel);
        public void error(DSFAError error);
    }

    public static class DSFAError{
        private static final int ERROR = 0;
        private static final int TIMEOUT = 1;//连接超时
        private static final int OTHER = 2;//未知错误
        private String errorMsg;
        private int errorCode;
        public DSFAError(String msg,int errorCode){
            this.errorMsg = msg;
            this.errorCode = errorCode;
        }
        public DSFAError(String errorMsg){
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public int getErrorCode() {
            return errorCode;
        }
    }
}
