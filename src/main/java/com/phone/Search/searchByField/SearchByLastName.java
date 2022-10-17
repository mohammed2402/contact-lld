package com.phone.Search.searchByField;

import com.phone.Contact;
import com.phone.CustomDataStructure.Trie;
import com.phone.Search.SearchStrategy.SearchStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchByLastName extends SearchByField {

    public SearchByLastName(Trie trie){
        this.trie = trie;
    }
    @Override
    public List<Contact> search(SearchStrategy searchStrategy, String keyword, Map<String, Contact> contacts) {

        Map<String, String> queryList = new HashMap<>();
        for(Contact contact : contacts.values()){
            queryList.put(contact.getId(),contact.getFirstName());
        }
        List<String> searchResults = searchStrategy.search(keyword , queryList, trie);
        List<Contact> results = new ArrayList<>();
        for(String id : searchResults){
            results.add(contacts.get(id));
        }

        return results;
    }
}

// COntcats -> abhinav - 4 times
// abhinav - v-> true

//searchResults - > abhinav X 4

//


