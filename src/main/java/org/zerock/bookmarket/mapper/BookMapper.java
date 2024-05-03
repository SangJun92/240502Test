package org.zerock.bookmarket.mapper;

import org.zerock.bookmarket.domain.BookVO;
import org.zerock.bookmarket.domain.MemberVO;
import org.zerock.bookmarket.dto.MemberDTO;

public interface BookMapper {

    void addBook(BookVO bookVO);
}