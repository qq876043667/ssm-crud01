package com.atgui.controller;

import com.atgui.bean.Employee;
import com.atgui.bean.Msg;
import com.atgui.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

//    @RequestMapping(value = "/emps")
//    public String getEmps(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model) {
//        /**
//         * 这不是一个分页查询
//         * 引入分页插件
//         * 在查询之前调用,传入页码，遗迹分页的大小
//         */
//        PageHelper.startPage(pn,5);
//
//        /**
//         * startPage之后的这个查询就是分页查询
//         */
//        List<Employee> emps = employeeService.getAll();
//
//        PageInfo pageInfo = new PageInfo(emps, 5);
//
//        model.addAttribute("page", pageInfo);
//
//        return "list";
//    }

    @RequestMapping(value = "/emps")
    @ResponseBody
    public Msg getEmpWithJson(@RequestParam(value = "pn", defaultValue = "1")Integer pn) {

        PageHelper.startPage(pn,5);

        /**
         * startPage之后的这个查询就是分页查询
         */
        List<Employee> emps = employeeService.getAll();

        PageInfo page = new PageInfo(emps, 5);

        return Msg.success().add("pageInfo", page);


    }
}
