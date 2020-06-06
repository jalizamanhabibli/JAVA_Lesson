package com.company.dto;

/**
 * Created by IntelliJ IDEA.
 * User: Alizaman
 * Date: 23/05/2020
 * Time: 13:34
 */
public class ResponseDto {
    private Integer errorCode;
    private String errorMessage;
    private String successMessage;
    private Object object;

    private ResponseDto() {
    }

    public static ResponseDto of(Object obj){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setObject(obj);
        return responseDto;
    }

    public static ResponseDto of(Object obj,String successMessage){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setSuccessMessage(successMessage);
        responseDto.setObject(obj);
        return responseDto;
    }

    public static ResponseDto of(Integer errorCode,String errorMessage){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setErrorCode(errorCode);
        responseDto.setErrorMessage(errorMessage);
        return responseDto;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", successMessage='" + successMessage + '\'' +
                ", object=" + object +
                '}';
    }
}
