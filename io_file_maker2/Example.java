

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;

public class Example implements Serializable {

    public static void printDir() {
        System.out.println(System.getProperty("user.dir"));
    }

    public static void returnFile() {
    }

    public static void main(String[] args) throws IOException {
//        // relative path && this serves as a pointer to the file itself whether it exists or not
//        File exampleFile1 = new File("example.txt");
//        // absolute path && this serves as a pointer to the file itself whether it exists or not
//        File exampleFile2 = new File("/Users/ryanallynnader/desktop/Test/example.txt");
//        exampleFile1.createNewFile();
//
//        File exampleDirectory = new File("exampleDir");
//        exampleDirectory.mkdir();
//
//        Utils.writeContents(exampleFile1, "The Hello World");
//        System.out.println(Utils.readContentsAsString(exampleFile1));

//        HashSet<String> set = new HashSet<>();
//        set.add("Michelle");
//        set.add("Omar");
//        set.add("Zoe");
//        set.add("Arjun");
//        File f = new File("set");
//        Utils.writeObject(f, set);
//        HashSet<String> setLoaded = Utils.readObject(f, HashSet.class);
//        System.out.println(setLoaded);
//        HashSet<String> set1 = new HashSet<>();
//        set1.add("a");
//        set1.add("b");
//        set1.add("c");
//        set1.add("d");
//        Utils.writeObject(f, set1);
//        HashSet<String> setLoaded2 = Utils.readObject(f, HashSet.class);
//        System.out.println(setLoaded2);

        HashSet<String> set10 = new HashSet<>();
        set10.add("The");
        set10.add("Big");
        set10.add("Dog");
        set10.add("Jumps");
        File f = new File("ohh.ryan");
        Utils.writeObject(f, 1);
        Integer setLoaded = Utils.readObject(f, Integer.class);
//        HashSet<String> setLoaded = Utils.readObject(f, HashSet.class);
        System.out.println(setLoaded);

    }



}