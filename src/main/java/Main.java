import exceptions.UnreachableResultException;
import functions.trigonometrics.Cosine;
import system.SystemFunctions;
import static java.lang.Math.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnreachableResultException, IOException {
        SystemFunctions system = new SystemFunctions(10e-6);
        double accuracy = 10e-6;
//        CSVWriter writer = new CSVWriter("test.csv", system, false);
//        writer.addHeader();
//        writer.writeRangeComputations(-2*Math.PI, 2*Math.PI, 0.123);
        for (double i = 2; i < 3; i+=0.3112311){
            double y = (log10(10)+log(i)/log(3))*log(i)/log(2)/log(i) + log(i)/log(5)*2;
            System.out.printf("%.15f, %.15f, %.15f\n", i, y,system.comp(i));
        }
    }
}