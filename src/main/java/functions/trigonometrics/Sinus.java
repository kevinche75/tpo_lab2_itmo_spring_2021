package functions.trigonometrics;
import exceptions.UnreachableResultException;
import functions.Function;
import utils.TransformationService;

public class Sinus extends Function {

    public Sinus(double accuracy){
        super(accuracy);
    }

    public static double compSin(double theta, double accuracy) throws UnreachableResultException {
        return TransformationService.transformSinToCos(theta, accuracy);
    }

    @Override
    public double comp(double theta) throws UnreachableResultException {
        return Sinus.compSin(theta, this.accuracy);
    }

    @Override
    public String toString(){
        return "sin(x)";
    }
}
