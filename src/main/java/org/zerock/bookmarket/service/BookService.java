package org.zerock.bookmarket.service;

import org.zerock.bookmarket.dto.BookDTO;

import java.util.List;

public interface BookService {

    void register(BookDTO bookDTO);

    List<BookDTO> bookList();

    BookDTO readOne(String id);

    void updateBook(BookDTO bookDTO);

    void remove(String id);
}
