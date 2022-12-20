package br.com.minhaapi.controllers;

import br.com.minhaapi.converters.NumberConverter;
import br.com.minhaapi.exceptions.UnsupportedMathOperationException;
import br.com.minhaapi.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Insira um valor numérico!");

        }
        return math.sum(NumberConverter.convertToDouble(numberOne), (NumberConverter.convertToDouble(numberTwo)));
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Insira um valor numérico");
        }
        return math.subtraction(NumberConverter.convertToDouble(numberOne), (NumberConverter.convertToDouble(numberTwo)));
    }

    @RequestMapping(value = "multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Insira um valor numérico");
        }
        return math.multiplication(NumberConverter.convertToDouble(numberOne), (NumberConverter.convertToDouble(numberTwo)));
    }

    @RequestMapping(value = "division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Insira um valor numérico");
        }
        return math.division(NumberConverter.convertToDouble(numberOne), (NumberConverter.convertToDouble(numberTwo)));
    }
}





