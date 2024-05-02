package org.zerock.bookmarket.mapper;

import org.zerock.bookmarket.domain.MemberVO;
import org.zerock.bookmarket.dto.MemberDTO;

public interface MemberMapper {

    void insert(MemberVO memberVO);

    MemberVO login(MemberDTO memberDTO);

//    List<MemberVO> selectALL();
//
//    MemberVO selectOne(String memberID);
//
//    void delete(String memberID);
//
//    void update(MemberVO memeberVO);



//    List<TodoVO> selectList(PageRequestDTO pageRequestDTO); // 페이징 관련 메서드 추가 부분
//
//    int getCount(PageRequestDTO pageRequestDTO); //  전체 갯수를 알아야 페이징을 나누기가 가능

}
