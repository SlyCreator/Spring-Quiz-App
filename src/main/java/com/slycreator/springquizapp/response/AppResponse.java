package com.slycreator.springquizapp.response;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AppResponse {
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    private AppResponse() {
    }

    public static AppResponse ok() {
        AppResponse r = new AppResponse();
        r.setSuccess(true);
        r.setCode(ResponseConstant.SUCCESS);
        r.setMessage("success");
        return r;
    }

    public static AppResponse error() {
        AppResponse r = new AppResponse();
        r.setSuccess(false);
        r.setCode(ResponseConstant.ERROR);
        r.setMessage("error");
        return r;
    }

    public AppResponse success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public AppResponse message(String message) {
        this.setMessage(message);
        return this;
    }

    public AppResponse code(Integer code) {
        this.setCode(code);
        return this;
    }

    public AppResponse data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public AppResponse data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
