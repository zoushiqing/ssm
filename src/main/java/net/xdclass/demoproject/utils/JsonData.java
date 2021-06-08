package net.xdclass.demoproject.utils;

public class JsonData {
    private int code;
    private String msg;
    private Object data;

    public JsonData() {
    }

    public JsonData(int code, Object data, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data, "");
    }

    public static JsonData buildError(String msg) {
        return new JsonData(-1, "", msg);
    }

    public static JsonData buildError(String msg, int code) {
        return new JsonData(code, "", msg);
    }
}
