/**
 * UserDetailInfo.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT)
 * WSDL2Java emitter.
 */
package com.ccssoft.webservice.model;

public class UserDetailInfo implements java.io.Serializable {
  private String customerID;

  private String userID;

  private String userName;

  private String state;

  private Integer payType;

  private String openTime;

  private Integer orderLevel;

  private String deviceID;

  private String userAreaID;

  public UserDetailInfo() {}

  public UserDetailInfo(
      String customerID,
      String userID,
      String userName,
      String state,
      Integer payType,
      String openTime,
      Integer orderLevel,
      String deviceID,
      String userAreaID) {
    this.customerID = customerID;
    this.userID = userID;
    this.userName = userName;
    this.state = state;
    this.payType = payType;
    this.openTime = openTime;
    this.orderLevel = orderLevel;
    this.deviceID = deviceID;
    this.userAreaID = userAreaID;
  }

  /**
   * Gets the customerID value for this UserDetailInfo.
   *
   * @return customerID
   */
  public String getCustomerID() {
    return customerID;
  }

  /**
   * Sets the customerID value for this UserDetailInfo.
   *
   * @param customerID
   */
  public void setCustomerID(String customerID) {
    this.customerID = customerID;
  }

  /**
   * Gets the userID value for this UserDetailInfo.
   *
   * @return userID
   */
  public String getUserID() {
    return userID;
  }

  /**
   * Sets the userID value for this UserDetailInfo.
   *
   * @param userID
   */
  public void setUserID(String userID) {
    this.userID = userID;
  }

  /**
   * Gets the userName value for this UserDetailInfo.
   *
   * @return userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Sets the userName value for this UserDetailInfo.
   *
   * @param userName
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Gets the state value for this UserDetailInfo.
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   * Sets the state value for this UserDetailInfo.
   *
   * @param state
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * Gets the payType value for this UserDetailInfo.
   *
   * @return payType
   */
  public Integer getPayType() {
    return payType;
  }

  /**
   * Sets the payType value for this UserDetailInfo.
   *
   * @param payType
   */
  public void setPayType(Integer payType) {
    this.payType = payType;
  }

  /**
   * Gets the openTime value for this UserDetailInfo.
   *
   * @return openTime
   */
  public String getOpenTime() {
    return openTime;
  }

  /**
   * Sets the openTime value for this UserDetailInfo.
   *
   * @param openTime
   */
  public void setOpenTime(String openTime) {
    this.openTime = openTime;
  }

  /**
   * Gets the orderLevel value for this UserDetailInfo.
   *
   * @return orderLevel
   */
  public Integer getOrderLevel() {
    return orderLevel;
  }

  /**
   * Sets the orderLevel value for this UserDetailInfo.
   *
   * @param orderLevel
   */
  public void setOrderLevel(Integer orderLevel) {
    this.orderLevel = orderLevel;
  }

  /**
   * Gets the deviceID value for this UserDetailInfo.
   *
   * @return deviceID
   */
  public String getDeviceID() {
    return deviceID;
  }

  /**
   * Sets the deviceID value for this UserDetailInfo.
   *
   * @param deviceID
   */
  public void setDeviceID(String deviceID) {
    this.deviceID = deviceID;
  }

  /**
   * Gets the userAreaID value for this UserDetailInfo.
   *
   * @return userAreaID
   */
  public String getUserAreaID() {
    return userAreaID;
  }

  /**
   * Sets the userAreaID value for this UserDetailInfo.
   *
   * @param userAreaID
   */
  public void setUserAreaID(String userAreaID) {
    this.userAreaID = userAreaID;
  }

  private Object __equalsCalc = null;

  public synchronized boolean equals(Object obj) {
    if (!(obj instanceof UserDetailInfo)) return false;
    UserDetailInfo other = (UserDetailInfo) obj;
    if (obj == null) return false;
    if (this == obj) return true;
    if (__equalsCalc != null) {
      return (__equalsCalc == obj);
    }
    __equalsCalc = obj;
    boolean _equals;
    _equals =
        true
            && ((this.customerID == null && other.getCustomerID() == null)
                || (this.customerID != null && this.customerID.equals(other.getCustomerID())))
            && ((this.userID == null && other.getUserID() == null)
                || (this.userID != null && this.userID.equals(other.getUserID())))
            && ((this.userName == null && other.getUserName() == null)
                || (this.userName != null && this.userName.equals(other.getUserName())))
            && ((this.state == null && other.getState() == null)
                || (this.state != null && this.state.equals(other.getState())))
            && ((this.payType == null && other.getPayType() == null)
                || (this.payType != null && this.payType.equals(other.getPayType())))
            && ((this.openTime == null && other.getOpenTime() == null)
                || (this.openTime != null && this.openTime.equals(other.getOpenTime())))
            && ((this.orderLevel == null && other.getOrderLevel() == null)
                || (this.orderLevel != null && this.orderLevel.equals(other.getOrderLevel())))
            && ((this.deviceID == null && other.getDeviceID() == null)
                || (this.deviceID != null && this.deviceID.equals(other.getDeviceID())))
            && ((this.userAreaID == null && other.getUserAreaID() == null)
                || (this.userAreaID != null && this.userAreaID.equals(other.getUserAreaID())));
    __equalsCalc = null;
    return _equals;
  }

  private boolean __hashCodeCalc = false;

  public synchronized int hashCode() {
    if (__hashCodeCalc) {
      return 0;
    }
    __hashCodeCalc = true;
    int _hashCode = 1;
    if (getCustomerID() != null) {
      _hashCode += getCustomerID().hashCode();
    }
    if (getUserID() != null) {
      _hashCode += getUserID().hashCode();
    }
    if (getUserName() != null) {
      _hashCode += getUserName().hashCode();
    }
    if (getState() != null) {
      _hashCode += getState().hashCode();
    }
    if (getPayType() != null) {
      _hashCode += getPayType().hashCode();
    }
    if (getOpenTime() != null) {
      _hashCode += getOpenTime().hashCode();
    }
    if (getOrderLevel() != null) {
      _hashCode += getOrderLevel().hashCode();
    }
    if (getDeviceID() != null) {
      _hashCode += getDeviceID().hashCode();
    }
    if (getUserAreaID() != null) {
      _hashCode += getUserAreaID().hashCode();
    }
    __hashCodeCalc = false;
    return _hashCode;
  }

  // Type metadata
  private static org.apache.axis.description.TypeDesc typeDesc =
      new org.apache.axis.description.TypeDesc(UserDetailInfo.class, true);

  static {
    typeDesc.setXmlType(
        new javax.xml.namespace.QName(
            "http://bean.unifBoss.iptvbss.newyulong.com", "UserDetailInfo"));
    org.apache.axis.description.ElementDesc elemField =
        new org.apache.axis.description.ElementDesc();
    elemField.setFieldName("customerID");
    elemField.setXmlName(
        new javax.xml.namespace.QName("http://bean.unifBoss.iptvbss.newyulong.com", "customerID"));
    elemField.setXmlType(
        new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
    elemField.setMinOccurs(0);
    elemField.setNillable(false);
    typeDesc.addFieldDesc(elemField);
    elemField = new org.apache.axis.description.ElementDesc();
    elemField.setFieldName("userID");
    elemField.setXmlName(
        new javax.xml.namespace.QName("http://bean.unifBoss.iptvbss.newyulong.com", "userID"));
    elemField.setXmlType(
        new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
    elemField.setNillable(false);
    typeDesc.addFieldDesc(elemField);
    elemField = new org.apache.axis.description.ElementDesc();
    elemField.setFieldName("userName");
    elemField.setXmlName(
        new javax.xml.namespace.QName("http://bean.unifBoss.iptvbss.newyulong.com", "userName"));
    elemField.setXmlType(
        new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
    elemField.setMinOccurs(0);
    elemField.setNillable(false);
    typeDesc.addFieldDesc(elemField);
    elemField = new org.apache.axis.description.ElementDesc();
    elemField.setFieldName("state");
    elemField.setXmlName(
        new javax.xml.namespace.QName("http://bean.unifBoss.iptvbss.newyulong.com", "state"));
    elemField.setXmlType(
        new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
    elemField.setMinOccurs(0);
    elemField.setNillable(false);
    typeDesc.addFieldDesc(elemField);
    elemField = new org.apache.axis.description.ElementDesc();
    elemField.setFieldName("payType");
    elemField.setXmlName(
        new javax.xml.namespace.QName("http://bean.unifBoss.iptvbss.newyulong.com", "payType"));
    elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
    elemField.setMinOccurs(0);
    elemField.setNillable(true);
    typeDesc.addFieldDesc(elemField);
    elemField = new org.apache.axis.description.ElementDesc();
    elemField.setFieldName("openTime");
    elemField.setXmlName(
        new javax.xml.namespace.QName("http://bean.unifBoss.iptvbss.newyulong.com", "openTime"));
    elemField.setXmlType(
        new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
    elemField.setMinOccurs(0);
    elemField.setNillable(true);
    typeDesc.addFieldDesc(elemField);
    elemField = new org.apache.axis.description.ElementDesc();
    elemField.setFieldName("orderLevel");
    elemField.setXmlName(
        new javax.xml.namespace.QName("http://bean.unifBoss.iptvbss.newyulong.com", "orderLevel"));
    elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
    elemField.setMinOccurs(0);
    elemField.setNillable(true);
    typeDesc.addFieldDesc(elemField);
    elemField = new org.apache.axis.description.ElementDesc();
    elemField.setFieldName("deviceID");
    elemField.setXmlName(
        new javax.xml.namespace.QName("http://bean.unifBoss.iptvbss.newyulong.com", "deviceID"));
    elemField.setXmlType(
        new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
    elemField.setMinOccurs(0);
    elemField.setNillable(true);
    typeDesc.addFieldDesc(elemField);
    elemField = new org.apache.axis.description.ElementDesc();
    elemField.setFieldName("userAreaID");
    elemField.setXmlName(
        new javax.xml.namespace.QName("http://bean.unifBoss.iptvbss.newyulong.com", "userAreaID"));
    elemField.setXmlType(
        new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
    elemField.setMinOccurs(0);
    elemField.setNillable(true);
    typeDesc.addFieldDesc(elemField);
  }

  /** Return type metadata object */
  public static org.apache.axis.description.TypeDesc getTypeDesc() {
    return typeDesc;
  }

  /** Get Custom Serializer */
  public static org.apache.axis.encoding.Serializer getSerializer(
      String mechType, Class _javaType, javax.xml.namespace.QName _xmlType) {
    return new org.apache.axis.encoding.ser.BeanSerializer(_javaType, _xmlType, typeDesc);
  }

  /** Get Custom Deserializer */
  public static org.apache.axis.encoding.Deserializer getDeserializer(
      String mechType, Class _javaType, javax.xml.namespace.QName _xmlType) {
    return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType, _xmlType, typeDesc);
  }
}
