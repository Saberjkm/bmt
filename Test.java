import bmt.*;

public class Test {
    public static void main(String... args) {
        try {
            BMT.initialise();
            BMT.loadDictionary("dictionary");
            for (String word : BMT.getWordsAsList()) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
