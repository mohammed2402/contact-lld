package com.phone.Factories;

import com.phone.CustomDataStructure.Trie;
import com.phone.SearchField;
import com.phone.Search.searchByField.SearchByField;
import com.phone.Search.searchByField.SearchByFirstName;
import com.phone.Search.searchByField.SearchByLastName;
import com.phone.Search.searchByField.SearchByPhone;

public class SearchByFieldFactory {
    public static SearchByField getSearchByField(SearchField searchField, Trie trie){
        switch (searchField){
            case FIRST_NAME:
                return new SearchByFirstName(trie);
            case LAST_NAME:
                return new SearchByLastName(trie);
            case PHONE:
                return new SearchByPhone(trie);


        }
        return new SearchByPhone(trie);
    }
}
