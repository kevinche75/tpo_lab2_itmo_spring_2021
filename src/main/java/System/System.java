package System;

import exceptions.UnreachableResultException;
import functions.Function;

public class System extends Function {

    private FirstFunction firstFunction;
    private SecondFunction secondFunction;

    public System(double accuracy){
        super(accuracy);
        firstFunction = new FirstFunction(accuracy);
        secondFunction = new SecondFunction(accuracy);
    }

    @Override
    public double comp(double x) throws UnreachableResultException {
        if (x <= 0) return firstFunction.comp(x);
        else return secondFunction.comp(x);
    }
}