import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FileMaker implements Serializable {

    public static void putObjectToFile() throws IOException {
        int totalSize = 100;
        File outFile = new File("/Users/ryanallynnader/desktop/crazy/intArray");
        int[] ar = new int[totalSize];
        for (int i = 0; i < totalSize; i += 1) {
            ar[i] = i;
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outFile));
        out.writeObject("the");
        out.writeObject(ar);
        out.writeObject(1);

        ArrayList<String> x = new ArrayList<>(100);
        x.add(0, "the");

        out.writeObject(x);

        out.close();
    }

    public static int[] pullObjectFromFileIntArray() throws IOException, ClassNotFoundException {
        int[] ar;
        File inFile = new File("/Users/ryanallynnader/desktop/crazy/intArray");
        ObjectInputStream inp = new ObjectInputStream(new FileInputStream(inFile));
        ar = (int[]) inp.readObject();
        inp.close();
        return ar;
    }

    public static String pullObjectFromFileString() throws IOException, ClassNotFoundException {
        String ar;
        File inFile = new File("/Users/ryanallynnader/desktop/crazy/intArray");
        ObjectInputStream inp = new ObjectInputStream(new FileInputStream(inFile));
        ar = (String) inp.readObject();
        inp.close();
        return ar;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileMaker.putObjectToFile();

        String yy = FileMaker.pullObjectFromFileString();
        System.out.println(yy);
        
        int[] xx = FileMaker.pullObjectFromFileIntArray();
        System.out.println(Arrays.toString(xx));
    }

}