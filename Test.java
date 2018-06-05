import bmt.*;

public class Test {
    public static void main(String... args) {
        WordTree testTree = new WordTree();
        System.out.println(testTree.addWord("hello"));
        System.out.println(testTree.addWord("hello  "));
        System.out.println(testTree.addWord("hell"));
        System.out.println(testTree.addWord("hell"));
        System.out.println("Hello World");
    }
}
