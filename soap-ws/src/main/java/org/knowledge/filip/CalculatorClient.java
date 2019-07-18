package org.knowledge.filip;

import org.tempuri.*;

public class CalculatorClient {

    /*############################################################
      ### Calculator is the name of the service, e.g. wsdl:service
        # CalculatorSoap is the port name, e.g. wsdl:port
     */
    private CalculatorSoap calculator = new Calculator().getCalculatorSoap();

    public int doAddition(int x, int y) {
        int rez = 0;

        rez = calculator.add(x, y); // does the call to the WS
        return rez;
    }
    
    public int doSubstraction(int x, int y) {
        int rez = 0;
        rez = calculator.subtract(x, y);
        return rez;
    }
    
    public int doMultiplication(int x, int y) {
        int rez = 0;
        rez = calculator.multiply(x, y);
        return rez;
    }
    
    public int doDivision(int x, int y) {
        int rez = 0;
        rez = calculator.divide(x, y);
        return rez;
    }
}
