package br.com.dev.controller;

import br.com.dev.converter.NumberConverter;
import br.com.dev.exception.UnsupportedMathOperationException;
import br.com.dev.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/math")
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    private SimpleMath math = new SimpleMath();

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public String sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        String result = String.valueOf(math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)));

        return "Sum: " + NumberConverter.convertToDouble(numberOne) + " + " + NumberConverter.convertToDouble(numberTwo) + " = " + result;
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public String subtraction(@PathVariable(value = "numberOne") String numberOne,
                              @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        String result = String.valueOf(math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)));

        return "Subtraction: " + NumberConverter.convertToDouble(numberOne) + " - " + NumberConverter.convertToDouble(numberTwo) + " = " + result;
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public String multiplication(@PathVariable(value = "numberOne") String numberOne,
                                 @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        String result = String.valueOf(math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)));

        return "Multiplication: " + NumberConverter.convertToDouble(numberOne) + " * " + NumberConverter.convertToDouble(numberTwo) + " = " + result;
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public String division(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        String result = String.valueOf(math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)));

        return "Division: " + NumberConverter.convertToDouble(numberOne) + " / " + NumberConverter.convertToDouble(numberTwo) + " = " + result;
    }

    @GetMapping("/mean/{numberOne}/{numberTwo}")
    public String mean(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        String result = String.valueOf(math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)));

        return "Mean: (" + NumberConverter.convertToDouble(numberOne) + " + " + NumberConverter.convertToDouble(numberTwo) + ") / 2 = " + result;
    }

    @GetMapping("/squareRoot/{numberOne}/{numberTwo}")
    public String squareRoot(@PathVariable(value = "number") String number) throws Exception {
        if (!NumberConverter.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        String result = String.valueOf(math.squareRoot(NumberConverter.convertToDouble(number)));

        return "Square Root of " + NumberConverter.convertToDouble(number) + " = " + result;
    }

}
