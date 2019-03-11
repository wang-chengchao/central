package com.ccssoft.webservice.model;

public class ResultBean {
  private int returnCode;
  private String returnMessage; // 	String(<=1024)

  public int getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(int returnCode) {
    this.returnCode = returnCode;
  }

  public String getReturnMessage() {
    return returnMessage;
  }

  public void setReturnMessage(String returnMessage) {
    this.returnMessage = returnMessage;
  }
}
