//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.demo.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel("返回结果")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("是否成功")
    private boolean success;

    @ApiModelProperty("状态码")
    private int code;

    @ApiModelProperty("信息")
    private String msg;

    @ApiModelProperty("数据")
    private T data;

    public Result() {
    }

    public static Result<Void> success() {
        Result<Void> result = new Result<>();
        result.setSuccess(true);
        result.setCode(SystemCode.SUCCESS.getCode());
        result.setMsg(SystemCode.SUCCESS.getDescription());
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setCode(SystemCode.SUCCESS.getCode());
        result.setMsg(SystemCode.SUCCESS.getDescription());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(int code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(ISystemCode iSystemCode, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setCode(iSystemCode.getCode());
        result.setMsg(iSystemCode.getDescription());
        result.setData(data);
        return result;
    }

    public static Result<Void> error() {
        Result<Void> result = new Result<>();
        result.setSuccess(false);
        result.setCode(SystemCode.UNCAUGHT_EXCEPTION.getCode());
        result.setMsg(SystemCode.UNCAUGHT_EXCEPTION.getDescription());
        return result;
    }

    public static <T> Result<T> error(T data) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setCode(SystemCode.UNCAUGHT_EXCEPTION.getCode());
        result.setMsg(SystemCode.UNCAUGHT_EXCEPTION.getDescription());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(String msg, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setCode(SystemCode.UNCAUGHT_EXCEPTION.getCode());
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(int errorCode, String msg, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setCode(errorCode);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(int errorCode, String msg) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setCode(errorCode);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> error(ISystemCode iSystemCode, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setCode(iSystemCode.getCode());
        result.setMsg(iSystemCode.getDescription());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(ISystemCode iSystemCode) {
        return error(iSystemCode.getCode(), iSystemCode.getDescription());
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{success=" + this.success + ", code=" + this.code + ", msg='" + this.msg + '\'' + ", data=" + this.data + '}';
    }
}
