package org.zerock.bookmarket.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.bookmarket.domain.BookVO;
import org.zerock.bookmarket.domain.MemberVO;
import org.zerock.bookmarket.dto.BookDTO;
import org.zerock.bookmarket.mapper.BookMapper;

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
}
