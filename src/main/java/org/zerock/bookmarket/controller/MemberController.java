package org.zerock.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.bookmarket.dto.MemberDTO;
import org.zerock.bookmarket.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String joinGet(MemberDTO memberDTO) {
        return "/member/join";
    }

    @PostMapping("/join")
    public String joinPost(MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
        memberService.register(memberDTO);
        redirectAttributes.addFlashAttribute("message", "회원가입 완료");
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginGet(MemberDTO memberDTO) {
        return "/member/login";
    }

    @PostMapping("/login")
    public String loginPost(HttpServletRequest req, RedirectAttributes redirectAttributes, Model model, MemberDTO memberDTO) {
        try {
            MemberDTO loginInfo = memberService.loging(memberDTO);

            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", loginInfo);
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "로그인 실패");
            return "redirect:/member/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {

        HttpSession session = req.getSession();
        session.removeAttribute("loginInfo");
        session.invalidate();

        return "redirect:/";
    }
}
