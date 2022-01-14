import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.vsu.cs.beshmelnicyna_d_yu.Trie;


public class TrieTest {

    @Test
    public void addNode() {
        Trie tree = new Trie();
        tree.add("alala");
        tree.add("a");
        tree.add("b");
        Assertions.assertTrue(tree.isPresent("a"));
        Assertions.assertTrue(tree.isPresent("b"));
    }

    @Test
    public void removeNode() {
        Trie tree = new Trie();
        tree.add("a");
        tree.add("b");
        tree.remove("a");
        Assertions.assertFalse(tree.isPresent("a"));
        Assertions.assertTrue(tree.isPresent("b"));
    }

    @Test
    public void add() {
        Trie tree = new Trie();
        tree.add("hello");
        tree.add("hell");
        tree.add("hello");
        tree.add("helloy");
        tree.add("goodnight");
        tree.add("goodmorning");
        tree.add("helmet");
        Assertions.assertTrue(tree.isPresent("helloy"));
        Assertions.assertFalse(tree.isPresent("helloll"));
        Assertions.assertFalse(tree.isPresent("gum"));
    }

    @Test
    public void isPresent() {
        Trie tree = new Trie();
        tree.add("helloy");
        tree.add("hell");
        tree.add("goodnight");
        tree.add("goodmorning");
        tree.add("helmet");
        Assertions.assertFalse(tree.isPresent("goodmo"));
        Assertions.assertFalse(tree.isPresent("helmost"));
        Assertions.assertTrue(tree.isPresent("hell"));
        Assertions.assertFalse(tree.isPresent("helloye"));
    }

    @Test
    public void remove() {
        Trie tree = new Trie();
        tree.add("helloy");
        tree.add("hell");
        tree.remove("helloy");
        Assertions.assertTrue(tree.isPresent("hell"));
        Assertions.assertFalse(tree.isPresent("helmet"));
        Assertions.assertFalse(tree.isPresent("gum"));
        Assertions.assertFalse(tree.isPresent("helloy"));
        tree.add("hello");
        tree.remove("hello");
        Assertions.assertFalse(tree.isPresent("hello"));
        Assertions.assertTrue(tree.isPresent("hell"));
    }

    @Test
    void search() {
        Trie tree = new Trie();
        tree.add("helloy");
        tree.add("hell");
        tree.add("goodnight");
        tree.add("goodmorning");
        tree.add("helmet");
        Set<String> result = new HashSet<>();
        result.add("goodmorning");
        result.add("goodnight");
        String prefix = "good";
        Set<String> strings = tree.search(prefix);
        Assertions.assertEquals(result, strings);
    }
}