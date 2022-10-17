package com.phone;

import com.phone.CustomDataStructure.Trie;
import com.phone.Factories.SearchByFieldFactory;
import com.phone.Search.SearchStrategy.SearchStrategy;
import com.phone.Factories.SearchFactory;
import com.phone.Search.searchByField.SearchByField;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ContactManagerImpl implements ContactManager{
    Map<String, Contact> contactsByID;
    TrieManager trieManager;

    public ContactManagerImpl() {
        contactsByID = new HashMap<>();
        trieManager = new TrieManager();
    }
    @Override
    public boolean add(Contact contact) {
        validateContact(contact);
        contactsByID.put(contact.getId(), contact);
        trieManager.insertIntoTries(contact);

        return true;
    }

    public boolean update(Contact contact) {
        validateContact(contact);
        if(contactsByID.get(contact.getId()) == null){
            throw new RuntimeException("Contact not found for given ID");
        }
        contactsByID.remove(contact.getId());
        contactsByID.put(contact.getId(), contact);
        return true;
    }

    public SearchResponse search(SearchRequest searchRequest) {

        SearchStrategy searchStrategy = SearchFactory.getSearchStrategy(searchRequest.getSearchType());
        List<Contact> results;

        SearchByField searchByField = SearchByFieldFactory.getSearchByField(searchRequest.getSearchField(), trieManager.trieMap.get(searchRequest.getSearchField()));

        results = searchByField.search(searchStrategy, searchRequest.getInput(), contactsByID);

        return new SearchResponse(results.size(), results);
    }

    private void validateContact(Contact contact){
        if(Objects.isNull(contact.getId())) {
            throw new RuntimeException("Id cannot be null");
        }

        if(Objects.isNull(contact.getFirstName())) {
            throw new RuntimeException("First Name cannot be null");
        }

        if(Objects.isNull(contact.getLastName())) {
            throw new RuntimeException("Last Name cannot be null");
        }

        if(Objects.isNull(contact.getPhoneNumber())) {
            throw new RuntimeException("Phone Number cannot be null");
        }
    }
}
