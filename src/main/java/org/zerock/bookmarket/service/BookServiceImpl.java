package org.zerock.bookmarket.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.bookmarket.domain.BookVO;
import org.zerock.bookmarket.dto.BookDTO;
import org.zerock.bookmarket.mapper.BookMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(BookDTO bookDTO) {
        log.info(modelMapper);
        BookVO bookVO = modelMapper.map(bookDTO, BookVO.class);
        log.info(bookVO);
        bookMapper.addBook(bookVO);

    }

    @Override
    public List<BookDTO> bookList() {
        List<BookDTO> dtoList = bookMapper.listBook().stream()
                .map(vo -> modelMapper.map(vo, BookDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

//    @Override
//    public BookDTO getBook(String id) {
//        BookVO bookVO = bookMapper.selectBook(id);
//        BookDTO bookDTO = modelMapper.map(bookVO, BookDTO.class);
//
//        return bookDTO;
//    }
}
