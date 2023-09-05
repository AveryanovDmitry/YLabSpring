package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.entity.BookEntity;
import com.edu.ulab.app.mapper.BookMapper;
import com.edu.ulab.app.service.BookService;
import com.edu.ulab.app.storage.StorageBooks;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    StorageBooks storage;
    BookMapper mapper;

    BookServiceImpl(StorageBooks storage, BookMapper mapper) {
        this.storage = storage;
        this.mapper = mapper;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        bookDto.setId(storage.generateId());
        BookEntity book = storage.save(mapper.bookDtoToBookEntity(bookDto));
        log.info("created a book, assigned an id, saved in storage");
        return mapper.bookEntityToBookDto(book);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        BookEntity bookEntity = storage.updateBook(mapper.bookDtoToBookEntity(bookDto));
        log.info("Updated book with existing id");
        return mapper.bookEntityToBookDto(bookEntity);
    }

    @Override
    public List<BookDto> getBooksByUserId(Long userId) {
        log.info("Get List book by existing userId");
        return storage.getByUserId(userId)
                .stream()
                .map(mapper::bookEntityToBookDto)
                .toList();
    }

    @Override
    public void deleteBookByUserId(Long id) {
        log.info("Delete book by existing id");
        storage.deleteByUserId(id);
    }
}
