package bmt;

import java.util.ArrayList;

/**
* This WordTree class acts as a radix trie for storing words.<br>
* It has a few tools to make it simpler to define words and prefixes/sufixes.<br>
*
* @author Jacob Mckenna
*/
public class WordTree {
    private class Node {
        private int depth;
        private boolean isEndOfWord;
        private char representedCharacter;
        private ArrayList<Node> childNodes;

        public Node() {
            this.depth = 0;
            this.isEndOfWord = false;
            this.representedCharacter = 0;
            this.childNodes = new ArrayList<>();
        }
        
        public Node(char character, int depth) {
            this.depth = depth; 
            this.representedCharacter = character;
            this.isEndOfWord = false;
            this.childNodes = new ArrayList<>();
        }

        public boolean isEndOfWord() { return this.isEndOfWord; }

        public char getCharacter() { return this.representedCharacter; }
        public void setCharacter(char character) { this.representedCharacter = character; }
    }

    private Node rootNode;

    public WordTree() {
        this.rootNode = new Node();
    }
    
    /**
    * Inserts a {@code string} into the WordTree.
    * It returns a boolean denoting whether the word has been added or not.
    *
    * @param word the {@code string} to be insterted into the WordTree
    * @return {@code true} if word has been added.<br>
    *         {@code false} if word hasn't been added or it already exists. 
    */
    public boolean addWord(String word) {
        return false;
    }
    
}
