package com.example.servlet.web.springmvc.v3;

import com.example.servlet.domain.member.Member;
import com.example.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    //@RequestMapping(value = "/members/new-form", method = RequestMethod.GET)
    @GetMapping("/members/new-form")
    public String newForm(){
        return "new-form";
        // ModelAndView로 반드시 보낼 필요는 없다
    }

    //@RequestMapping(value = "/members/save", method = RequestMethod.POST)
    @PostMapping("/members/save")
    public String save(@RequestParam("username") String username,
                             @RequestParam("age") int age,
                             Model model){

        Member member = new Member(username, age);
        memberRepository.save(member);

        /*ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);*/
        model.addAttribute("member", member);

        return "save-result";
    }

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model){

        List<Member> members = memberRepository.findAll();

      /*  ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);*/
        model.addAttribute("members", members);

        return "members";
    }
}
