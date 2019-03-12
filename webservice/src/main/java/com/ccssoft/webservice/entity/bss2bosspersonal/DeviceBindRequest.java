//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.0 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.03.11 时间 02:50:36 PM CST 
//


package com.ccssoft.webservice.entity.bss2bosspersonal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>DeviceBindRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DeviceBindRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MAC" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="forcedFlag" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="detailParam" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceBindRequest", namespace = "http://bean.unifBoss.iptvbss.newyulong.com", propOrder = {
    "userID",
    "mac",
    "forcedFlag",
    "detailParam"
})
public class DeviceBindRequest {

    @XmlElement(required = true)
    protected java.lang.String userID;
    @XmlElement(name = "MAC", required = true)
    protected java.lang.String mac;
    protected int forcedFlag;
    @XmlElement(required = true)
    protected java.lang.String detailParam;
    
    public java.lang.String getUserID() {
        return userID;
    }
    
    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }
    
    public java.lang.String getMac() {
        return mac;
    }
    
    public void setMac(java.lang.String mac) {
        this.mac = mac;
    }
    
    public int getForcedFlag() {
        return forcedFlag;
    }
    
    public void setForcedFlag(int forcedFlag) {
        this.forcedFlag = forcedFlag;
    }
    
    public java.lang.String getDetailParam() {
        return detailParam;
    }
    
    public void setDetailParam(java.lang.String detailParam) {
        this.detailParam = detailParam;
    }
}
