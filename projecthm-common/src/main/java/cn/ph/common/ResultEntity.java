package cn.ph.common;
//返回给页面信息
public class ResultEntity {
    private int code;
    private String message;

    public ResultEntity() {
    }

    public ResultEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
