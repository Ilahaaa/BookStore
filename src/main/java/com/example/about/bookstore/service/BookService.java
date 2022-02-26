package com.example.about.bookstore.service;

import com.example.about.bookstore.dao.entity.BookEntity;
import com.example.about.bookstore.dao.repository.BookRepository;
import com.example.about.bookstore.mapper.BookMapper;
import com.example.about.bookstore.model.dto.BookDto;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getBookParams() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }

    public BookEntity findById(Integer id) {
        return bookRepository.findById(id).get();
    }

    public List<BookEntity> getByTypeD() {
        List<BookEntity> books =
                bookRepository.findByTypeD();
        return books;
    }
    public List<BookEntity> getByTypeB() {
        List<BookEntity> books =
                bookRepository.findByTypeB();
        return books;
    }

    public BookEntity getBookParams(Long id) {
        return bookRepository.findById(Math.toIntExact(id)).get();
    }

//public List<BookEntity>findAll(){
//        return bookRepository.findAll();
//}
//

}



