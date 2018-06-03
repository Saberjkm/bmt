package bmt;

import java.util.ArrayList;

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

    public boolean addWord(String word) {
        return false;
    }
    
}
