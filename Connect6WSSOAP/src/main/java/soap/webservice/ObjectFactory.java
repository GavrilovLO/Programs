
package soap.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap.webservice package. 
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

    private final static QName _GivePlayer_QNAME = new QName("http://soap/", "GivePlayer");
    private final static QName _GivePlayerResponse_QNAME = new QName("http://soap/", "GivePlayerResponse");
    private final static QName _InputData_QNAME = new QName("http://soap/", "InputData");
    private final static QName _InputDataResponse_QNAME = new QName("http://soap/", "InputDataResponse");
    private final static QName _OutputData_QNAME = new QName("http://soap/", "OutputData");
    private final static QName _OutputDataResponse_QNAME = new QName("http://soap/", "OutputDataResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GivePlayer }
     * 
     */
    public GivePlayer createGivePlayer() {
        return new GivePlayer();
    }

    /**
     * Create an instance of {@link GivePlayerResponse }
     * 
     */
    public GivePlayerResponse createGivePlayerResponse() {
        return new GivePlayerResponse();
    }

    /**
     * Create an instance of {@link InputData }
     * 
     */
    public InputData createInputData() {
        return new InputData();
    }

    /**
     * Create an instance of {@link InputDataResponse }
     * 
     */
    public InputDataResponse createInputDataResponse() {
        return new InputDataResponse();
    }

    /**
     * Create an instance of {@link OutputData }
     * 
     */
    public OutputData createOutputData() {
        return new OutputData();
    }

    /**
     * Create an instance of {@link OutputDataResponse }
     * 
     */
    public OutputDataResponse createOutputDataResponse() {
        return new OutputDataResponse();
    }

    /**
     * Create an instance of {@link InputOutput }
     * 
     */
    public InputOutput createInputOutput() {
        return new InputOutput();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GivePlayer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GivePlayer }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap/", name = "GivePlayer")
    public JAXBElement<GivePlayer> createGivePlayer(GivePlayer value) {
        return new JAXBElement<GivePlayer>(_GivePlayer_QNAME, GivePlayer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GivePlayerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GivePlayerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap/", name = "GivePlayerResponse")
    public JAXBElement<GivePlayerResponse> createGivePlayerResponse(GivePlayerResponse value) {
        return new JAXBElement<GivePlayerResponse>(_GivePlayerResponse_QNAME, GivePlayerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputData }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InputData }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap/", name = "InputData")
    public JAXBElement<InputData> createInputData(InputData value) {
        return new JAXBElement<InputData>(_InputData_QNAME, InputData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputDataResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InputDataResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap/", name = "InputDataResponse")
    public JAXBElement<InputDataResponse> createInputDataResponse(InputDataResponse value) {
        return new JAXBElement<InputDataResponse>(_InputDataResponse_QNAME, InputDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutputData }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OutputData }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap/", name = "OutputData")
    public JAXBElement<OutputData> createOutputData(OutputData value) {
        return new JAXBElement<OutputData>(_OutputData_QNAME, OutputData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutputDataResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OutputDataResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap/", name = "OutputDataResponse")
    public JAXBElement<OutputDataResponse> createOutputDataResponse(OutputDataResponse value) {
        return new JAXBElement<OutputDataResponse>(_OutputDataResponse_QNAME, OutputDataResponse.class, null, value);
    }

}
