package com.lds.dto;

/**
 * Created by n0049901 on 2018/9/26.
 */
public class BaseResponse {

    public BaseResponse(Object content) {
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
