package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    //웹어플리케이션에서 /hello라고 들어오면 hello라는 메서드를 호출한다.
    //GetMapping의 Get은 Get/Post의 Get을 의미
    @GetMapping("hello")
    public String hello(Model model) {
        //model은 mvc의 model을 의미
        model.addAttribute("data", "dgdsf!!");
        //hello.html로 가서 렌더링해라.
        return "hello";

    }
}
