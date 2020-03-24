package bean;

import lombok.Data;

@Data
public class Response<T>{
    /**
     * 200 成功
     *
     */
    private String code;
    private String msg;
    private T data;

    public Response() {
    }

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
