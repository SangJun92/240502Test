package org.zerock.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.bookmarket.dto.BookDTO;
import org.zerock.bookmarket.mapper.BookMapper;
import org.zerock.bookmarket.service.BookService;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/book")
@Log4j2
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;


    @GetMapping("/addBook")
    public String addBook(BookDTO bookDTO) {

        return "/book/addBook";
    }

    @PostMapping("/addBook")
    public String addBook(BookDTO bookDTO, RedirectAttributes redirectAttributes, MultipartFile file,
                          BindingResult bindingResult) throws IOException {

        log.info("POST.......");
        //실제 파일 이름 출력
        log.info(file.getOriginalFilename());
        //파일의 크기
        log.info(file.getSize());
        //파일의 확장자
        log.info(file.getContentType());
        //파일을 저장하는 메서드 : new File("파일을 저장할 경로//파일이름.확장자")
        file.transferTo(new File("c://files//" + file.getOriginalFilename()));

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/book/addBook";
        }

        bookDTO.setImgFileName(file.getOriginalFilename());

        log.info(bookDTO);
        bookService.register(bookDTO);
        redirectAttributes.addFlashAttribute("message", "도서추가 완료");
        return "redirect:/book/books";
    }

    @GetMapping({"/books", "/editBook"})
    public void books(Model model) {
        log.info("-------- /book/books --------");
        // 에러가 존재한다면, 출력후, 리다이렉트

        model.addAttribute("books", bookService.bookList());
    }

    @GetMapping("/book")
    public void book(String id, Model model) {
        BookDTO bookDTO = bookService.readOne(id);
        model.addAttribute("book", bookDTO);
        model.addAttribute("book", bookService.readOne(id));
    }

//    @GetMapping("/modify")
}
