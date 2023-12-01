package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminProfileControler {
	@GetMapping("/admin/Profile")
	public String loginAdminPage() {
		return "admin/profile";
	}
}
