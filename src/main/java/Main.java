import exceptions.UnreachableResultException;
import functions.trigonometrics.Cosine;
import system.System;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnreachableResultException, IOException {
        System system = new System(10e-3);
        CSVWriter writer = new CSVWriter("test.csv", system, false);
        writer.addHeader();
        writer.writeRangeComputations(-2*Math.PI, 2*Math.PI, 0.123);
    }
}
