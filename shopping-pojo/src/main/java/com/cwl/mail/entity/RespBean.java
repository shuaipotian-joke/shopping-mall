package com.cwl.mail.entity;

public class RespBean {
    private Integer code;//状态码
    private String message;//提示消息
    private Object data;//返回的数据
    private String url;
    public static  RespBean error(String message,Object data){
        return new RespBean(500,message,data);
    }

    public static RespBean error(String message){
        return new RespBean(500,message);
    }

    public static  RespBean ok(String message,Object data){
        return new RespBean(200,message,data);
    }

    public static RespBean ok(String message){
        return new RespBean(200,message);
    }

    private RespBean(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private RespBean(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private RespBean(Integer code, String message,String url) {
        this.code = code;
        this.message = message;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
