package com.example.demo.controller;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductListController {
    @RequestMapping(value = {"/","/Giay"})
    public String GiayPage() {
        return "productgiay";
    }
    @RequestMapping(value = {"/","/Balo"})
    public String BaloPage() {
        return "productbalo";
    }
    @RequestMapping(value = {"/","/SanPham"})
    public String SanPhamPage() {
        return "productall";
    }
}
