package com.phone.Search.SearchStrategy;

import com.phone.CustomDataStructure.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompleteWordSearchStrategy implements SearchStrategy{

    @Override
    public List<String> search(String keyWord, Map<String, String> values, Trie trie) {
        List<String> results = new ArrayList<>();
        results.addAll(trie.searchComplete(keyWord));
        return results;
    }
}
