package com.zerobase.fastlms;

// MainPage 클래스 만든 목적!!
// 매핑하기 위해서...
// 주소와(논리적인주소인터넷주소) 물리적인파일(프로그래밍을 해야 하니까) 매핑

// http://www.naver.com/new/lis.do
// 하나의 주소에 대해서
// 어디서 매핑? 누가 매핑?
// 후보군? 클래스, 속성, 메소드

// http://localhost:8080/

import com.zerobase.fastlms.components.MailComponents;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;


    @RequestMapping("/")
    public String index() {

        String email = "wj402@naver.com";
        String subject = " 안녕하세요. 박찬성입니다.";
        String text = "<p>안녕하세요</p> <p>반갑습니다.</p>";

        mailComponents.sendMail(email, subject, text);

        return "index";
    }

    // 스프링 -> MVC (View -> 템플릿엔진 화면에 내용을 출력(html))
    // .NET -> MVC (View -> 출력)
    // python django -> MTV(Template -> 화면출력)
    // 백엔든과정 -> V(화면에 보여진 부분) -> 프론트엔드과정
    // V -> HTML ==> 웹페이지가
    // V -> json ==> API

    // request -> WEB -> SERVER
    // response -> SERVER -> WEB

    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter printWriter = response.getWriter();

        String msg = "<html>" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "</head>" +
                "<body>" +
                "<p>hello</p> <p>fastlms websilte!!!</p>" +
                "<p>안녕하세요!!! ===> </p>" +
                "</body>" +
                "</html>";
        printWriter.write(msg);
        printWriter.close();
    }

}
