package org.zerock.bookmarket.service;

import org.zerock.bookmarket.dto.MemberDTO;

public interface MemberService {

    void register(MemberDTO memberDTO);

    MemberDTO loging(MemberDTO memberDTO);

//    List<MemberDTO> getAll();
//
//    MemberDTO getOne(Long tno);
//
//    void remove(Long tno);
//
//    void modify(MemberDTO memberDTO);


}
