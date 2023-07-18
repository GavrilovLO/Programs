
package soap.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for inputOutput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="inputOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="whosemove" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="busy" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inputOutput", propOrder = {
    "id",
    "whosemove",
    "busy"
})
public class InputOutput {

    protected int id;
    protected int whosemove;
    protected int busy;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the whosemove property.
     * 
     */
    public int getWhosemove() {
        return whosemove;
    }

    /**
     * Sets the value of the whosemove property.
     * 
     */
    public void setWhosemove(int value) {
        this.whosemove = value;
    }

    /**
     * Gets the value of the busy property.
     * 
     */
    public int getBusy() {
        return busy;
    }

    /**
     * Sets the value of the busy property.
     * 
     */
    public void setBusy(int value) {
        this.busy = value;
    }

}
