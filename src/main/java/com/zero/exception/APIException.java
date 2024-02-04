package com.zero.exception;

import com.zero.common.response.ResultCode;
import lombok.Getter;

@Getter // 只要getter方法，无需setter
public class APIException extends RuntimeException {
  private final int code;
  private final String msg;

  public APIException() {
    this(1001, "接口错误");
  }

  public APIException(String msg) {
    this(1001, msg);
  }

  public APIException(int code, String msg) {
    super(msg);
    this.code = code;
    this.msg = msg;
  }

  public APIException(ResultCode code) {
    super(code.getMessage());
    this.code = code.getCode();
    this.msg = code.getMessage();
  }
}
