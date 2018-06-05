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
            this.depth = -1;
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

        public Node(char character, int depth, boolean end) {
            this.depth = depth;
            this.representedCharacter = character;
            this.isEndOfWord = end;
            this.childNodes = new ArrayList<>();
        }

        public boolean isEndOfWord() { return this.isEndOfWord; }
        public void setEndOfWord(boolean bool) { this.isEndOfWord = bool; }
 
        public char getCharacter() { return this.representedCharacter; }
        public void setCharacter(char character) { this.representedCharacter = character; }

        // Not sure if i really need to carry around the hasAdded bool
        public boolean addWord(String word, boolean hasAdded) {
            if (word.length() == 0) { return hasAdded; } 
            Node testNode = this.contains(word.charAt(0));
            // If testNode is null this means that its a new word to be added so process it
            if (testNode == null) {
                // If only a single character left then add an end of word node
                if (word.length() == 1) {
                    this.childNodes.add(new Node(word.charAt(0), this.depth + 1, true));
                    return true;
                } else {
                    Node newNode = new Node(word.charAt(0), this.depth + 1, false);
                    this.childNodes.add(newNode);
                    return (newNode.addWord(word.substring(1), true));
                }
            } else {
                // If its the last characte in <word> check if the node is designated as an end of word character.
                if (word.length() == 1) {
                    if (testNode.isEndOfWord()) { 
                        return hasAdded;
                    } else {
                        testNode.setEndOfWord(true);
                        return true;
                    }
                } else {
                    return (testNode.addWord(word.substring(1), hasAdded));
                }
            }
        }

        public Node contains(char character) {
            for (Node node : this.childNodes) {
                if (node.getCharacter() == character) { return node; }
            }
            return null;
        }
    }

    private Node rootNode;

    public WordTree() {
        this.rootNode = new Node();
    }
    
    /**
    * Inserts a {@code string} into the WordTree.
    * It returns a boolean denoting whether the word has been added or not.
    * Also trims whitespace and converts to lowercase.
    *
    * @param word the {@code string} to be inserted into the WordTree
    * @return {@code true} if word has been added.<br>
    *         {@code false} if word hasn't been added or it already exists. 
    */
    public boolean addWord(String word) {
        return rootNode.addWord(word.trim().toLowerCase(), false); 
    }
    
}
