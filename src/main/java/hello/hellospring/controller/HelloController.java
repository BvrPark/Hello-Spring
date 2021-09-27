package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller     //Spring은 @Controller라고 꼭 적어줘야 함
public class HelloController {

    @GetMapping("hello")    //웹 어플리케이션에서 /hello라고 들어오면 이 메서드를 호출
    public String Hello(Model model){
        model.addAttribute("data", "Hello!!"); //key는 data value는 Hello!!
        return "hello";     //templates/hello.html에게 model과 함께 랜더링해줘라
                            //기본설정이 templates안의 ViewName("text").html을 찾는 것으로 설정
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
}
