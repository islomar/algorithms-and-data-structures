package kata;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private boolean isWord;
    private Map<Character, TrieNode> children = new HashMap<>();

        public TrieNode(boolean isWord) {
        this.isWord = isWord;
    }

    public boolean containsCharacter(Character c) {
        return this.children.get(c) != null;
    }

    public TrieNode getChildTrieNodeFor(Character c) {
            return this.children.get(c);
    }

    public void addChild(Character character, TrieNode child) {
        this.children.putIfAbsent(character, child);
    }

    public boolean hasChildren() {
            return !this.children.isEmpty();
    }

    public boolean isWord() {
        return this.isWord;
    }

    public void setIsWord() {
        this.isWord = true;
    }

    @Override
    public String toString() {
        return "TrieNode { isWord='" + isWord + "', children=" + children + " }";
    }
}

