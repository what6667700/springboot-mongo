package com.dc.model.web.rest;

import com.dc.model.constant.Constants;
import com.dc.utils.BeanUtils;
import com.dc.utils.StringUtils;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ResultDto<T> {

    private static final String PAGE_CLASS="com.github.pagehelper.Page";
    private static final String TOTAL_FIELD="total";
    private String code="0";
    private long total;
    private String message;
    private String level;
    private T data;
    private List<Object> i18nData;

    public ResultDto(){
        super();
    }

    public ResultDto(T data) {
        this.data = data;
        setTotalField(data);
    }

    public ResultDto(T data, List<Object> i18nData) {
        this.data = data;
        this.i18nData = i18nData;
        setTotalField(data);
    }


    public ResultDto(long total, T data) {
        this.total = total;
        this.data = data;
    }

    public ResultDto(String code, String message, String level) {
        this.code = code;
        this.message = message;
        this.level = level;
    }

    public ResultDto(String code, String message, String level, List<Object> i18nData) {
        this.code = code;
        this.message = message;
        this.level = level;
        this.i18nData = i18nData;
    }

    public static <T> ResultDto<T> success(T data){
        return new ResultDto<>(data);
    }

    public static <T> ResultDto<T> successMessage(String message){
        return new ResultDto<>(Constants.SUCCESS_CODE,message,Constants.SUCCESS_LEVEL);
    }


    public void setTotalField(T data){
        if(Objects.nonNull(data) && Collection.class.isAssignableFrom(data.getClass())){
            String value = StringUtils.toString(BeanUtils.getObjectFieldValue(data,PAGE_CLASS,TOTAL_FIELD));
            if(StringUtils.isNumberic(value)){
                this.total = Long.parseLong(value);
            }
        }
    }

    public static String getPageClass() {
        return PAGE_CLASS;
    }

    public static String getTotalField() {
        return TOTAL_FIELD;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Object> getI18nData() {
        return i18nData;
    }

    public void setI18nData(List<Object> i18nData) {
        this.i18nData = i18nData;
    }


    @Override
    public String toString() {
        return "ResultDto [" +
                "code='" + code + '\'' +
                ", total=" + total +
                ", message='" + message + '\'' +
                ", level='" + level + '\'' +
                ", data=" + data +
                ", i18nData=" + i18nData +
                ']';
    }
}
