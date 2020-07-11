import java.io.*;
import java.util.ArrayList;

public class FileExp {

    public static void main(String[] args) {
        ArrayList<Integer> d = new ArrayList<>();
//        for(int i = 0; i < 100; i++){
//            d.add(i);
//        }
//        File outFile = new File("list");
//        try {
//            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outFile));
//            out.writeObject(d);
//            out.close();
//        } catch (IOException excp) {}

        File inFile = new File("list");
        try {
            ObjectInputStream inp =
                    new ObjectInputStream(new FileInputStream(inFile));
            d = (ArrayList<Integer>) inp.readObject();
            inp.close();
        } catch (IOException | ClassNotFoundException excp) {
            d = null;
        }

        System.out.println(d);
    }

}