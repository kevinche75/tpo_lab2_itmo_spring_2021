package functions.logarithms;

import exceptions.UnreachableResultException;
import functions.Function;
import utils.TransformationService;

public class Logarithm2 extends Function {

    public Logarithm2(double accuracy){
        super(accuracy);
    }

    public static double compLog2(double theta, double accuracy) throws UnreachableResultException {
        return TransformationService.transformLogNToLogK(theta, accuracy, 2);
    }

    @Override
    public double comp(double theta) throws UnreachableResultException{
        return Logarithm2.compLog2(theta, this.accuracy);
    }

    @Override
    public String toString(){
        return "log2(x)";
    }
}
