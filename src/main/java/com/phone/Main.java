package com.phone;

public class Main {
    public static void main(String args[]){
        ContactManager contactManager = new ContactManagerImpl();
        Contact contact = new Contact("1", "Mohammed", "Chikhaliwala", "12345");
        contactManager.add(contact);
        Contact contact1 = new Contact("2", "John", "Doe", "1234");
        contactManager.add(contact1);

        SearchResponse searchResponse = contactManager.search(new SearchRequest(SearchField.FIRST_NAME, SearchType.PARTIAL, "Moha"));

        SearchResponse searchResponse1 = contactManager.search(new SearchRequest(SearchField.FIRST_NAME, SearchType.COMPLETE, "Mohammed"));

        SearchResponse searchResponse2 = contactManager.search(new SearchRequest(SearchField.PHONE, SearchType.PARTIAL, "123"));

        SearchResponse searchResponse3 = contactManager.search(new SearchRequest(SearchField.PHONE, SearchType.PARTIAL, "1234"));

        SearchResponse searchResponse4 = contactManager.search(new SearchRequest(SearchField.PHONE, SearchType.COMPLETE, "1234"));

        System.out.println("Application run complete");



    }
}
