package bmt; 

import java.util.ArrayList; 
import java.io.*;

public final class BMT {
    private static WordTree wordTree;

    private static boolean initialised = false;

    public static boolean initialise() {
        initialised = true;
        wordTree = new WordTree();
        return true;
    }

    public static ArrayList<String> getWordsAsList() throws Exception {
        if (initialised == false) { throw new Exception("BMT has not been initialised"); }
        return wordTree.getWordsAsList();
    }

    public static void loadDictionary(String dictionaryDirectory) throws Exception {
        if (initialised == false) { throw new Exception("BMT has not been initialised"); }
        try {
            File directory = new File(dictionaryDirectory);
            if (directory.listFiles().length == 0) { throw new Exception("Directory has no files"); }
            String fileContent;
            for (File file : directory.listFiles()) {
                fileContent = new String((new FileInputStream(file)).readAllBytes());
                System.out.println(fileContent);
            }
        }catch (Exception e) {
            throw e;
        }
    }  
}
