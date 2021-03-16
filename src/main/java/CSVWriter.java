import exceptions.UnreachableResultException;
import functions.Function;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter implements AutoCloseable{

    private File file;
    private FileWriter fileWriter;
    private Function function;

    public CSVWriter(String filename, Function function, boolean isToEnd) throws IOException {
        file = new File(filename);
        if (file.createNewFile()){
            System.out.println("File created: " + file.getName());
        }
        this.fileWriter = new FileWriter(file, isToEnd);
        this.function = function;
    }

    public void addHeader() throws IOException {
        fileWriter.write("x, " + function.toString() + "\n");
        fileWriter.flush();
    }

    public void writeRangeComputations(double start, double end, double step) throws IOException {
        double y;
        for (double x = start; x < end; x+=step) {
            try {
                y = function.comp(x);
                } catch (UnreachableResultException e) {
                y = Double.NaN;
            }
            fileWriter.write(x + "," + y + "\n");
        }
        fileWriter.flush();
    }

    @Override
    public void close() throws Exception {
        fileWriter.close();
    }
}
