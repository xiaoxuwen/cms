package com.hust.cms.controller;

import com.hust.cms.auth.AuthClass;
import com.hust.cms.auth.AuthMethod;
import com.hust.cms.web.CmsSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@AuthClass("login")
public class AdminController {

    @RequestMapping("/admin")
    @AuthMethod
    public String index() {
        return "admin/index";
    }

    @AuthMethod
    @RequestMapping("/admin/logout")
    public String logout(HttpSession session) {
        CmsSessionContext.removeSession(session);
        session.invalidate();
        return "redirect:/login";
    }
}
