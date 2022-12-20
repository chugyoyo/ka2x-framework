package com.ka2x.common.exception;

/**
 * <p>
 * detail: Ka2x内部的错误
 * </p>
 *
 * @author 吴泽欣
 * @since 2022/9/5 9:22
 **/
public class Ka2xException extends RuntimeException{

    public Ka2xException(String message) {
        super(message);
    }

    public Ka2xException(Throwable throwable) {
        super(throwable);
    }

    public Ka2xException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
