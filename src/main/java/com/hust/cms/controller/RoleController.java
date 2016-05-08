package com.hust.cms.controller;

import com.hust.cms.auth.AuthClass;
import com.hust.cms.model.Role;
import com.hust.cms.model.RoleType;
import com.hust.cms.service.IRoleService;
import com.hust.cms.service.IUserService;
import com.hust.cms.util.EnumUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
@RequestMapping("/admin/role")
@AuthClass
public class RoleController {
    private IRoleService roleService;
    private IUserService userService;

    public IRoleService getRoleService() {
        return roleService;
    }

    @Inject
    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    public IUserService getUserService() {
        return userService;
    }

    @Inject
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/roles")
    public String list(Model model) {
        model.addAttribute("roles", roleService.listRole());
        return "role/list";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
        model.addAttribute(roleService.load(id));
        model.addAttribute("us", userService.listRoleUsers(id));
        return "role/show";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        roleService.delete(id);
        return "redirect:/admin/role/roles";
    }

    @RequestMapping("/clearUsers/{id}")
    public String clearUsers(@PathVariable int id) {
        roleService.deleteRoleUsers(id);
        return "redirect:/admin/role/roles";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Role());
        model.addAttribute("types", EnumUtils.enum2Name(RoleType.class));
        return "role/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Role role) {
        roleService.add(role);
        return "redirect:/admin/role/roles";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        model.addAttribute(roleService.load(id));
        model.addAttribute("types", EnumUtils.enum2Name(RoleType.class));
        return "role/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, Role role) {
        Role er = roleService.load(id);
        er.setName(role.getName());
        er.setRoleType(role.getRoleType());
        roleService.update(er);
        return "redirect:/admin/role/roles";
    }
}
