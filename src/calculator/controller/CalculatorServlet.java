package calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorServlet {

    @GetMapping("/calculator")
    public ModelAndView calculator(@RequestParam Float firstOperand,Float secondOperand,char operator){
        Float result = getCalculator(firstOperand,secondOperand,operator);

        ModelAndView modelAndView = new ModelAndView("calculator","result",result);

        return modelAndView;
    }

    public static float getCalculator(float firstOperand, float secondOperand, char operator) {
        switch (operator) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;

            case '*':
                return firstOperand * secondOperand;
            case '/':
                if (secondOperand > 0) {
                    return firstOperand / secondOperand;
                } else {
                    throw new RuntimeException("Can't divide by zero");
                }
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
