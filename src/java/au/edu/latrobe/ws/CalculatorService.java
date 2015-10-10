package au.edu.latrobe.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * This is the WebService Implementation class. this class exposes all the operations that this service supports.
 * Callers need to call this service using a a web-service client. 
 * The WSDL is hosted by default at:http://localhost:8080/Assignment2/CalculatorService?wsdl
 * 
 */
@WebService(serviceName = "CalculatorService")
public class CalculatorService {

    /**
     * Addition operation
     */
    @WebMethod(operationName = "add")
    public int add(@WebParam(name = "operand1") int operand1, @WebParam(name = "operand2")int operand2) {
        return operand1 + operand2;
    }
    /**
     * Subtract operation
     */
    @WebMethod(operationName = "subtract")
    public int subtract(@WebParam(name = "operand1") int operand1, @WebParam(name = "operand2")int operand2) {
        return operand1 - operand2;
    }
    /**
     * Multiply operation
     */
    @WebMethod(operationName = "multiply")
    public int multiply(@WebParam(name = "operand1") int operand1, @WebParam(name = "operand2")int operand2) {
        return operand1 * operand2;
    }
    /**
     * Divide operation. Will throw SoapFault in case of divide by zero condition.
     */
    @WebMethod(operationName = "divide")
    public float divide(@WebParam(name = "operand1") int operand1, @WebParam(name = "operand2") int operand2) throws DivideByZeroException {
        if(operand2 == 0) {
            //Throw Soap Fault
            throw new DivideByZeroException("invalid division by zero.");
        }
        return (float)operand1 / (float)operand2;
    }
}
