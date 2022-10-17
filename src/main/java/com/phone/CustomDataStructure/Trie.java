package com.phone.CustomDataStructure;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert (String id, String word){
        TrieNode crawler = root;

        int level;
        int size = word.length();

        for(level =0 ; level < size ; level++){
            if(Objects.isNull(crawler.getNext().get(word.charAt(level)))) {
                crawler.getNext().put(word.charAt(level), new TrieNode());
            }
            crawler.getPartialWordIds().add(id);
            crawler = crawler.getNext().get(word.charAt(level));
        }

        crawler.getCompleteWordIds().add(id);
        crawler.getPartialWordIds().add(id);

    }

    public Set<String> searchPartial(String word){
        TrieNode crawler = root;
        Set<String> resultIds = new HashSet<>();
        int level;
        int size = word.length();

        for(level = 0 ; level < size ; level++){
            if(Objects.isNull(crawler.getNext().get(word.charAt(level)))) {
                return null;
            }
            resultIds.addAll(crawler.getPartialWordIds());
            crawler = crawler.getNext().get(word.charAt(level));
        }

        return crawler.getPartialWordIds();
    }

    public Set<String> searchComplete(String word){
        TrieNode crawler = root;
        int level;
        int size = word.length();

        for(level = 0 ; level < size ; level++){
            if(Objects.isNull(crawler.getNext().get(word.charAt(level)))) {
                return null;
            }
            crawler = crawler.getNext().get(word.charAt(level));
        }

        return crawler.getCompleteWordIds();
    }

}
