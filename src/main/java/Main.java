import exceptions.UnreachableResultException;
import functions.Function;
import functions.logarithms.*;
import functions.trigonometrics.Cosecant;
import functions.trigonometrics.Cosine;
import functions.trigonometrics.Secant;
import functions.trigonometrics.Sinus;
import system.FirstFunction;
import system.SecondFunction;
import system.SystemFunctions;
import static java.lang.Math.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnreachableResultException, IOException {
        double accuracy = 10e-5;
//        SystemFunctions system = new SystemFunctions(accuracy);
//        FirstFunction system = new FirstFunction(accuracy);
//        SecondFunction system = new SecondFunction(accuracy);
//        Logarithm10 system = new Logarithm10(accuracy);
        Function system = new LogarithmNatural(accuracy);
        CSVWriter writer = new CSVWriter("/home/kevinche/Desktop/Unik/ТПО/logN.csv", system, false);
        writer.writeRangeComputations(0, 4*Math.PI, 0.1);
    }
}