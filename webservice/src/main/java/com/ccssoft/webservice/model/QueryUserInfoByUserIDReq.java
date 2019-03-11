/**
 * QueryUserInfoByUserIDReq.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT)
 * WSDL2Java emitter.
 */
package com.ccssoft.webservice.model;

public class QueryUserInfoByUserIDReq implements java.io.Serializable {
  private String userID;

  private String sequenceID;

  public QueryUserInfoByUserIDReq() {}

  public QueryUserInfoByUserIDReq(String userID, String sequenceID) {
    this.userID = userID;
    this.sequenceID = sequenceID;
  }

  /**
   * Gets the userID value for this QueryUserInfoByUserIDReq.
   *
   * @return userID
   */
  public String getUserID() {
    return userID;
  }

  /**
   * Sets the userID value for this QueryUserInfoByUserIDReq.
   *
   * @param userID
   */
  public void setUserID(String userID) {
    this.userID = userID;
  }

  /**
   * Gets the sequenceID value for this QueryUserInfoByUserIDReq.
   *
   * @return sequenceID
   */
  public String getSequenceID() {
    return sequenceID;
  }

  /**
   * Sets the sequenceID value for this QueryUserInfoByUserIDReq.
   *
   * @param sequenceID
   */
  public void setSequenceID(String sequenceID) {
    this.sequenceID = sequenceID;
  }

  private Object __equalsCalc = null;

  public synchronized boolean equals(Object obj) {
    if (!(obj instanceof QueryUserInfoByUserIDReq)) return false;
    QueryUserInfoByUserIDReq other = (QueryUserInfoByUserIDReq) obj;
    if (obj == null) return false;
    if (this == obj) return true;
    if (__equalsCalc != null) {
      return (__equalsCalc == obj);
    }
    __equalsCalc = obj;
    boolean _equals;
    _equals =
        true
            && ((this.userID == null && other.getUserID() == null)
                || (this.userID != null && this.userID.equals(other.getUserID())))
            && ((this.sequenceID == null && other.getSequenceID() == null)
                || (this.sequenceID != null && this.sequenceID.equals(other.getSequenceID())));
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
    if (getUserID() != null) {
      _hashCode += getUserID().hashCode();
    }
    if (getSequenceID() != null) {
      _hashCode += getSequenceID().hashCode();
    }
    __hashCodeCalc = false;
    return _hashCode;
  }

  // Type metadata
  private static org.apache.axis.description.TypeDesc typeDesc =
      new org.apache.axis.description.TypeDesc(QueryUserInfoByUserIDReq.class, true);

  static {
    typeDesc.setXmlType(
        new javax.xml.namespace.QName(
            "http://bean.unifBoss.iptvbss.newyulong.com", "QueryUserInfoByUserIDReq"));
    org.apache.axis.description.ElementDesc elemField =
        new org.apache.axis.description.ElementDesc();
    elemField.setFieldName("userID");
    elemField.setXmlName(
        new javax.xml.namespace.QName("http://bean.unifBoss.iptvbss.newyulong.com", "userID"));
    elemField.setXmlType(
        new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
    elemField.setNillable(false);
    typeDesc.addFieldDesc(elemField);
    elemField = new org.apache.axis.description.ElementDesc();
    elemField.setFieldName("sequenceID");
    elemField.setXmlName(
        new javax.xml.namespace.QName("http://bean.unifBoss.iptvbss.newyulong.com", "sequenceID"));
    elemField.setXmlType(
        new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
