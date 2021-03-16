package system;

import exceptions.UnreachableResultException;
import functions.Function;

public class SystemFunctions extends Function {

    public FirstFunction firstFunction;
    public SecondFunction secondFunction;

    public SystemFunctions(double accuracy){
        super(accuracy);
        firstFunction = new FirstFunction(accuracy);
        secondFunction = new SecondFunction(accuracy);
    }

    @Override
    public double comp(double x) throws UnreachableResultException {
        if (x <= 0) return firstFunction.comp(x);
        else return secondFunction.comp(x);
    }

    @Override
    public String toString(){
        return "(sec(x)*cos(x)/sin(x)+sin(x))*csc(x)_if_x<=0_(log10(x)+log3(x))*log2(x)/logN(x)+log5(x)+log5(x)_if_x>0";
    }
}