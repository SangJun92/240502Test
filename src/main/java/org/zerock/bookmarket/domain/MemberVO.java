package org.zerock.bookmarket.domain;

import lombok.*;

import java.time.LocalDate;

//@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberVO {
    private String memberID;
    private String memberPW;
    private String memberName;
    private String phone;
    private String address;
    private String email;
    private LocalDate createDate;
}
