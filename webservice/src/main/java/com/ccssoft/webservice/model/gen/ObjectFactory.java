//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.0 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.03.07 时间 10:29:58 AM CST 
//


package com.ccssoft.webservice.model.gen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.chinamobile.js.pboss.service.sg2pbossservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReplyWorkSheetIn_QNAME = new QName("http://service.pboss.js.chinamobile.com/SG2PBOSSService", "in");
    private final static QName _ReplyWorkSheetResponseReturn_QNAME = new QName("http://service.pboss.js.chinamobile.com/SG2PBOSSService", "return");
    private final static QName _HandleMessageHandleMessage_QNAME = new QName("http://service.pboss.js.chinamobile.com/SG2PBOSSService", "handleMessage");
    private final static QName _MessageAdapterMessageAdapter_QNAME = new QName("http://service.pboss.js.chinamobile.com/SG2PBOSSService", "messageAdapter");

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes
   * for package: com.chinamobile.js.pboss.service.sg2pbossservice
   */
  public ObjectFactory() {}

    /**
     * Create an instance of {@link ReplyWorkSheet }
     * 
     */
    public ReplyWorkSheet createReplyWorkSheet() {
        return new ReplyWorkSheet();
    }

    /**
     * Create an instance of {@link ReplyWorkSheetResponse }
     *
     */
    public ReplyWorkSheetResponse createReplyWorkSheetResponse() {
        return new ReplyWorkSheetResponse();
    }

    /**
     * Create an instance of {@link com.ccssoft.webservice.model.gen.HandleMessage }
     *
     */
    public com.ccssoft.webservice.model.gen.HandleMessage createHandleMessage() {
        return new com.ccssoft.webservice.model.gen.HandleMessage();
    }

    /**
     * Create an instance of {@link HandleMessageResponse }
     *
     */
    public HandleMessageResponse createHandleMessageResponse() {
        return new HandleMessageResponse();
    }

    /**
     * Create an instance of {@link IsAlive }
     *
     */
    public IsAlive createIsAlive() {
        return new IsAlive();
    }

    /**
     * Create an instance of {@link IsAliveResponse }
     *
     */
    public IsAliveResponse createIsAliveResponse() {
        return new IsAliveResponse();
    }

    /**
     * Create an instance of {@link MessageAdapter }
     *
     */
    public MessageAdapter createMessageAdapter() {
        return new MessageAdapter();
    }

    /**
     * Create an instance of {@link MessageAdapterResponse }
     *
     */
    public MessageAdapterResponse createMessageAdapterResponse() {
        return new MessageAdapterResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.pboss.js.chinamobile.com/SG2PBOSSService", name = "in", scope = ReplyWorkSheet.class)
    public JAXBElement<Object> createReplyWorkSheetIn(Object value) {
        return new JAXBElement<Object>(_ReplyWorkSheetIn_QNAME, Object.class, ReplyWorkSheet.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.pboss.js.chinamobile.com/SG2PBOSSService", name = "return", scope = ReplyWorkSheetResponse.class)
    public JAXBElement<String> createReplyWorkSheetResponseReturn(String value) {
        return new JAXBElement<String>(_ReplyWorkSheetResponseReturn_QNAME, String.class, ReplyWorkSheetResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.pboss.js.chinamobile.com/SG2PBOSSService", name = "handleMessage", scope = com.ccssoft.webservice.model.gen.HandleMessage.class)
    public JAXBElement<Object> createHandleMessageHandleMessage(Object value) {
        return new JAXBElement<Object>(_HandleMessageHandleMessage_QNAME, Object.class, HandleMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.pboss.js.chinamobile.com/SG2PBOSSService", name = "return", scope = HandleMessageResponse.class)
    public JAXBElement<Object> createHandleMessageResponseReturn(Object value) {
        return new JAXBElement<Object>(_ReplyWorkSheetResponseReturn_QNAME, Object.class, HandleMessageResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.pboss.js.chinamobile.com/SG2PBOSSService", name = "in", scope = IsAlive.class)
    public JAXBElement<Object> createIsAliveIn(Object value) {
        return new JAXBElement<Object>(_ReplyWorkSheetIn_QNAME, Object.class, IsAlive.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.pboss.js.chinamobile.com/SG2PBOSSService", name = "return", scope = IsAliveResponse.class)
    public JAXBElement<Object> createIsAliveResponseReturn(Object value) {
        return new JAXBElement<Object>(_ReplyWorkSheetResponseReturn_QNAME, Object.class, IsAliveResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.pboss.js.chinamobile.com/SG2PBOSSService", name = "messageAdapter", scope = MessageAdapter.class)
    public JAXBElement<Object> createMessageAdapterMessageAdapter(Object value) {
        return new JAXBElement<Object>(_MessageAdapterMessageAdapter_QNAME, Object.class, MessageAdapter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.pboss.js.chinamobile.com/SG2PBOSSService", name = "return", scope = MessageAdapterResponse.class)
    public JAXBElement<Object> createMessageAdapterResponseReturn(Object value) {
        return new JAXBElement<Object>(_ReplyWorkSheetResponseReturn_QNAME, Object.class, MessageAdapterResponse.class, value);
    }

}
