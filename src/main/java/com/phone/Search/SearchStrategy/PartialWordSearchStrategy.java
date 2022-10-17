package com.phone.Search.SearchStrategy;

import com.phone.Contact;
import com.phone.CustomDataStructure.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PartialWordSearchStrategy implements SearchStrategy {

    @Override
    public List<String> search(String keyWord, Map<String, String> values, Trie trie) {
        List<String> results = new ArrayList<>();
        for(String id : values.keySet()){
            if(values.get(id).contains(keyWord)) {
                results.add(id);
            }
        }
        return results;
    }
}
