
package au.edu.latrobe.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for add complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="add">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operand1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="operand2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "add", propOrder = {
    "operand1",
    "operand2"
})
public class Add {

    protected int operand1;
    protected int operand2;

    /**
     * Gets the value of the operand1 property.
     * 
     */
    public int getOperand1() {
        return operand1;
    }

    /**
     * Sets the value of the operand1 property.
     * 
     */
    public void setOperand1(int value) {
        this.operand1 = value;
    }

    /**
     * Gets the value of the operand2 property.
     * 
     */
    public int getOperand2() {
        return operand2;
    }

    /**
     * Sets the value of the operand2 property.
     * 
     */
    public void setOperand2(int value) {
        this.operand2 = value;
    }

}
