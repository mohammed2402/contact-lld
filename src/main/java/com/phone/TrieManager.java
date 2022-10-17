package com.phone;

import com.phone.CustomDataStructure.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieManager {
    Map<SearchField, Trie> trieMap;

    public TrieManager() {
        trieMap = new HashMap<>();
        for(SearchField searchField : SearchField.values()){
            trieMap.put(searchField, new Trie());
        }
    }

    public void insertIntoTries(Contact contact){
        trieMap.get(SearchField.FIRST_NAME).insert(contact.getId(),contact.getFirstName());
        trieMap.get(SearchField.LAST_NAME).insert(contact.getId(),contact.getLastName());
        trieMap.get(SearchField.PHONE).insert(contact.getId(),contact.getPhoneNumber());

    }

}
