package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-string")     //웹에 내려보낼때 코드가 아닌 return값을 바로 내려보냄. 즉, 소스를 봐도 return값만 나옴.
    @ResponseBody //http의 body부분에 return값을 직접 넣겠다라는 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello "+ name;
    }

    @GetMapping("hello-api")
    @ResponseBody               //JSON방식으로 실행하면 "키값" : "value"로 간편하게 나온다.
    public Hello helloapi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }


    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
