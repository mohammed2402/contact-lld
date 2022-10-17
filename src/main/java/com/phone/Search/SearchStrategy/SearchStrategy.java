package com.phone.Search.SearchStrategy;

import com.phone.CustomDataStructure.Trie;

import java.util.List;
import java.util.Map;

public interface SearchStrategy {
    List<String> search(String keyWord, Map<String, String> values, Trie trie);
}
