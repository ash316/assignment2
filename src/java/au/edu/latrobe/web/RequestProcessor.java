package au.edu.latrobe.web;

import au.edu.latrobe.ws.client.CalculatorService;
import au.edu.latrobe.ws.client.CalculatorService_Service;
import au.edu.latrobe.ws.client.DivideByZeroException_Exception;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the Servlet which process the Web Service Invocation request.
 * This servlet uses Calculator Service Client and get hold of the PORT Type.
 * The client is then used to invoke the actual web-service endpoint.
 *
 */
public class RequestProcessor extends HttpServlet {

    //Web Service Interface
    private CalculatorService calculatorService;
    
    public void init() {
       System.out.println("About to initialize CalculatorService_Service client.");
       calculatorService = new CalculatorService_Service().getCalculatorServicePort();
       System.out.println("Client initialized successfully."); 
        
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
       
        //fetch data passed from the HTML
          String operationName = getParam(request, "operation");
          String op1 = getParam(request, "operand1");
          String op2 = getParam(request, "operand2");
          String wsResult = "";
          
          response.setContentType("text/html;charset=UTF-8");
          
          if(!isValid(op1, op2)) {
              response.getWriter().print("Invalid Data passed. Either of operands is null or blank.");
          } else {

            System.out.println("Operation Selected : " + operationName);

            switch(operationName) {
                //Add Operation
                case "1":
                   operationName = "addition";
                   int addResult = calculatorService.add(Integer.parseInt(op1), Integer.parseInt(op2));
                   wsResult = String.valueOf(addResult);
                   break;
                case "2":
                    //Sub Operation
                    operationName = "subtract";
                    int subResult = calculatorService.subtract(Integer.parseInt(op1), Integer.parseInt(op2));
                    wsResult = String.valueOf(subResult);
                    break;
                case "3":
                    //Multiply Operation
                    operationName = "multiply";
                    int mulResult = calculatorService.multiply(Integer.parseInt(op1), Integer.parseInt(op2));
                    wsResult = String.valueOf(mulResult);
                    break;    
                case "4":
                    //Divide Operation, must handle Soap Fault on Divide by Zero.
                    operationName = "divide";
                    try {
                      float divResult = calculatorService.divide(Integer.parseInt(op1), Integer.parseInt(op2));
                      wsResult = String.valueOf(divResult);
                    } catch(DivideByZeroException_Exception exception) {
                        wsResult = "Fault Occurred while invoking <i>divide</i> operation :: <b>" + exception.getMessage() + "</b>";
                    }
                    break;
            }

          System.out.println("Operation " + operationName + " invoked for Calculator WebService." );
          response.getWriter().print("The result of invoking <i>" + operationName + "</i> with operands <b>" + op1 + "</b> and <b>"+ op2 + "</b> is :: <b><i>"+  wsResult + "</b></i>");
          }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This is a Servlet for Calling Calculator webservice.";
    }// </editor-fold>

    private String getParam(HttpServletRequest request, String paramName) {
        String paramValue = request.getParameter(paramName);
        return paramValue;
    }
    /**
    * Function to validate the given input.
    */
    private boolean isValid(String op1, String op2) {
        if(op1 == null || op2 == null) {
            return false;
        } else if(op1.trim().equals("") || op2.trim().equals("") ) {
            return false;
        } 
        return true;
    }
}
