package kata;

public class Trie {
    private TrieNode root = new TrieNode(false);

    public void insert(String word){
        TrieNode currentNode = root;
        TrieNode nextNode = new TrieNode(false);
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!currentNode.containsCharacter(letter)) {
                nextNode = new TrieNode(false);
                currentNode.addChild(letter, nextNode);
            }
            currentNode = currentNode.getChildTrieNodeFor(letter);

        }
        currentNode.setIsWord();
    }

    public boolean isWordContained(String wordToFind) {
        TrieNode currentNode = root;
        for (int i = 0; i < wordToFind.length(); i++) {
            char letter = wordToFind.charAt(i);
            if (!currentNode.containsCharacter(letter)) {
                return false;
            }
            currentNode = currentNode.getChildTrieNodeFor(letter);
        }
        return currentNode.isWord();
    }
}
