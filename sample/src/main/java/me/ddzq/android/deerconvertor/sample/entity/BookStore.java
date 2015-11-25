package me.ddzq.android.deerconvertor.sample.entity;

import java.util.List;

/**
 * Created by dzq on 15/11/25.
 */
public class BookStore {
    private String storeName;

    private List<Book> books;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


//    @Override
//    public String toString() {
//        return "BookStore{" +
//                "storeName='" + storeName + '\'' +
//                ", books=" + books +
//                '}';
//    }
}
