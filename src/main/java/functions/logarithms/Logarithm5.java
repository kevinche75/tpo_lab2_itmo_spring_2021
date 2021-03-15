package functions.logarithms;

import exceptions.UnreachableResultException;
import functions.Function;
import utils.TransformationService;

public class Logarithm5 extends Function {

    public Logarithm5(double accuracy){
        super(accuracy);
    }

    public static double compLog5(double theta, double accuracy) throws UnreachableResultException {
        return TransformationService.transformLogNToLogK(theta, accuracy, 5);
    }

    @Override
    public double comp(double theta) throws UnreachableResultException{
        return Logarithm5.compLog5(theta, this.accuracy);
    }
}
