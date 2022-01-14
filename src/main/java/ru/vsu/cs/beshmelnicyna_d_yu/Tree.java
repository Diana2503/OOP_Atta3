package ru.vsu.cs.beshmelnicyna_d_yu;

import java.util.Set;

public interface Tree {
    boolean add(String s);

    boolean isPresent(String s);

    Set<String> search(String s);

    void getLevel(Trie.Node node, Set<String> res, StringBuilder prefix);

    boolean remove(String s);
}
