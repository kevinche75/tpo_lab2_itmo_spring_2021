package system;

import exceptions.UnreachableResultException;
import functions.Function;
import functions.logarithms.*;
import utils.RangeValueService;

public class SecondFunction extends Function {

    private LogarithmNatural logN;
    private Logarithm2 log2;
    private Logarithm3 log3;
    private Logarithm5 log5;
    private Logarithm10 log10;

    public SecondFunction(double accuracy){
        super(accuracy);
        logN = new LogarithmNatural(accuracy);
        log2 = new Logarithm2(accuracy);
        log3 = new Logarithm3(accuracy);
        log5 = new Logarithm5(accuracy);
        log10 = new Logarithm10(accuracy);
    }

    public double comp(double x) throws UnreachableResultException {
        if (RangeValueService.checkRangeValueSecondFunction(x, accuracy))
            throw new UnreachableResultException("X doesn't math the range of acceptable values");
        return (log10.comp(x) + log3.comp(x)) * log2.comp(x) / logN.comp(x) + log5.comp(x) + log5.comp(x);
    }

    @Override
    public String toString(){
        return "(log10(x)+log3(x))*log2(x)/logN(x)+log5(x)+log5(x)";
    }
}
