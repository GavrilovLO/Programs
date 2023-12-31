
package soap.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Server", targetNamespace = "http://soap/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Server {


    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod(operationName = "GivePlayer")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GivePlayer", targetNamespace = "http://soap/", className = "soap.webservice.GivePlayer")
    @ResponseWrapper(localName = "GivePlayerResponse", targetNamespace = "http://soap/", className = "soap.webservice.GivePlayerResponse")
    @Action(input = "http://soap/Server/GivePlayerRequest", output = "http://soap/Server/GivePlayerResponse")
    public int givePlayer();

    /**
     * 
     * @return
     *     returns soap.webservice.InputOutput
     */
    @WebMethod(operationName = "OutputData")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "OutputData", targetNamespace = "http://soap/", className = "soap.webservice.OutputData")
    @ResponseWrapper(localName = "OutputDataResponse", targetNamespace = "http://soap/", className = "soap.webservice.OutputDataResponse")
    @Action(input = "http://soap/Server/OutputDataRequest", output = "http://soap/Server/OutputDataResponse")
    public InputOutput outputData();

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod(operationName = "InputData")
    @RequestWrapper(localName = "InputData", targetNamespace = "http://soap/", className = "soap.webservice.InputData")
    @ResponseWrapper(localName = "InputDataResponse", targetNamespace = "http://soap/", className = "soap.webservice.InputDataResponse")
    @Action(input = "http://soap/Server/InputDataRequest", output = "http://soap/Server/InputDataResponse")
    public void inputData(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2);

}
