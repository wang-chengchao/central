/**
 * QueryUserInfoByUserIDResp.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT)
 * WSDL2Java emitter.
 */
package com.ccssoft.webservice.model;

public class QueryUserInfoByUserIDResp implements java.io.Serializable {
  private ResultBean resultInfo;

  private UserDetailInfo userInfo;

  public QueryUserInfoByUserIDResp() {}

  public QueryUserInfoByUserIDResp(
    ResultBean resultInfo,
     UserDetailInfo userInfo) {
    this.resultInfo = resultInfo;
    this.userInfo = userInfo;
  }

  /**
   * Gets the resultInfo value for this QueryUserInfoByUserIDResp.
   *
   * @return resultInfo
   */
  public ResultBean getResultInfo() {
    return resultInfo;
  }

  /**
   * Sets the resultInfo value for this QueryUserInfoByUserIDResp.
   *
   * @param resultInfo
   */
  public void setResultInfo(ResultBean resultInfo) {
    this.resultInfo = resultInfo;
  }

  /**
   * Gets the userInfo value for this QueryUserInfoByUserIDResp.
   *
   * @return userInfo
   */
  public UserDetailInfo getUserInfo() {
    return userInfo;
  }

  /**
   * Sets the userInfo value for this QueryUserInfoByUserIDResp.
   *
   * @param userInfo
   */
  public void setUserInfo(UserDetailInfo userInfo) {
    this.userInfo = userInfo;
  }

  private Object __equalsCalc = null;

  public synchronized boolean equals(Object obj) {
    if (!(obj instanceof QueryUserInfoByUserIDResp)) return false;
    QueryUserInfoByUserIDResp other = (QueryUserInfoByUserIDResp) obj;
    if (obj == null) return false;
    if (this == obj) return true;
    if (__equalsCalc != null) {
      return (__equalsCalc == obj);
    }
    __equalsCalc = obj;
    boolean _equals;
    _equals =
        true
            && ((this.resultInfo == null && other.getResultInfo() == null)
                || (this.resultInfo != null && this.resultInfo.equals(other.getResultInfo())))
            && ((this.userInfo == null && other.getUserInfo() == null)
                || (this.userInfo != null && this.userInfo.equals(other.getUserInfo())));
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
    if (getResultInfo() != null) {
      _hashCode += getResultInfo().hashCode();
    }
    if (getUserInfo() != null) {
      _hashCode += getUserInfo().hashCode();
    }
    __hashCodeCalc = false;
    return _hashCode;
  }

  // Type metadata
  private static org.apache.axis.description.TypeDesc typeDesc =
      new org.apache.axis.description.TypeDesc(QueryUserInfoByUserIDResp.class, true);

  static {
    typeDesc.setXmlType(
        new javax.xml.namespace.QName(
            "http://bean.unifBoss.iptvbss.newyulong.com", "QueryUserInfoByUserIDResp"));
    org.apache.axis.description.ElementDesc elemField =
        new org.apache.axis.description.ElementDesc();
    elemField.setFieldName("resultInfo");
    elemField.setXmlName(
        new javax.xml.namespace.QName("http://bean.unifBoss.iptvbss.newyulong.com", "resultInfo"));
    elemField.setXmlType(
        new javax.xml.namespace.QName("http://bean.unifBoss.iptvbss.newyulong.com", "ResultBean"));
    elemField.setNillable(false);
    typeDesc.addFieldDesc(elemField);
    elemField = new org.apache.axis.description.ElementDesc();
    elemField.setFieldName("userInfo");
    elemField.setXmlName(
        new javax.xml.namespace.QName("http://bean.unifBoss.iptvbss.newyulong.com", "userInfo"));
    elemField.setXmlType(
        new javax.xml.namespace.QName(
            "http://bean.unifBoss.iptvbss.newyulong.com", "UserDetailInfo"));
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
