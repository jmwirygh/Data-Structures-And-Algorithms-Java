/**
 * Name:
 * Student Number:
 */

public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie);

        trie.insert("apples");
        System.out.println(trie);

        trie.insert("api");
        System.out.println(trie);

        trie.insert("append");
        System.out.println(trie);

        System.out.println(trie.contains("app"));
        System.out.println(trie.contains("api"));

        System.out.println(trie.closestMatch("app", 1));
        System.out.println(trie.closestMatch("a", 1));
        System.out.println(trie.closestMatch("aploe", 2));

        /** 
            Expected output:
            
            [false, NO_SUFFIX, [a]][true, pple, []]
            [false, NO_SUFFIX, [a]][false, NO_SUFFIX, [p]][false, NO_SUFFIX, [p]][false, NO_SUFFIX, [l]][false, NO_SUFFIX, [e]][true, NO_SUFFIX, [s]][true, NO_SUFFIX, []]
            [false, NO_SUFFIX, [a]][false, NO_SUFFIX, [p]][false, NO_SUFFIX, [i, p]][true, NO_SUFFIX, []][false, NO_SUFFIX, [l]][false, NO_SUFFIX, [e]][true, NO_SUFFIX, [s]][true, NO_SUFFIX, []]
            [false, NO_SUFFIX, [a]][false, NO_SUFFIX, [p]][false, NO_SUFFIX, [i, p]][true, NO_SUFFIX, []][false, NO_SUFFIX, [e, l]][true, nd, []][false, NO_SUFFIX, [e]][true, NO_SUFFIX, [s]][true, NO_SUFFIX, []]
            false
            true
            api
            null
            apple

         */

    }
}