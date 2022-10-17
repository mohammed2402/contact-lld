package com.phone.Search.searchByField;

import com.phone.Contact;
import com.phone.CustomDataStructure.Trie;
import com.phone.Search.SearchStrategy.SearchStrategy;

import java.util.List;
import java.util.Map;

public abstract class SearchByField {

    Trie trie;
    public abstract List<Contact> search(SearchStrategy searchStrategy, String keyword, Map<String,Contact> contacts);
}
