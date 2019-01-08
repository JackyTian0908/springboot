package org.shiroboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.shiroboot.domain.User;
import org.shiroboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("one")
	public String getOne(){
		return "one";
	}
	@RequestMapping("two")
	public String getTwo(){
		return "two";
	}
	@RequestMapping("ajaxlogin")
	public String getAjaxLogin(){
		return "ajaxlogin";
	}
	@RequestMapping("autologin")
	public String getAutologin(Model model){
		Subject subject = SecurityUtils.getSubject();
		//封装用户数据
		UsernamePasswordToken userToken = new UsernamePasswordToken("1","1");
		//执行登录方法,用捕捉异常去判断是否登录成功
		try {
			subject.login(userToken);
			System.out.println("登录成功");
			return "redirect:/info";
		} catch (UnknownAccountException e) {
			//用户名不存在
			model.addAttribute("msg","用户名不存在");
			System.out.println("用户名不存在");
			return "redirect:/login";
		}catch (IncorrectCredentialsException e) {
			//密码错误
			model.addAttribute("msg","密码错误");
			System.out.println("密码错误");
			return "redirect:/login";
		}
	}
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	@RequestMapping("permission")
	public String permission(){
		return "permission";
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String toLogin(User user,Model model){
		
		//System.out.println(newUser.getName()+newUser.getPassword());
		//shiro用户认证
	    //获取subject
		Subject subject = SecurityUtils.getSubject();
		//封装用户数据
		UsernamePasswordToken userToken = new UsernamePasswordToken(user.getName(),user.getPassword());
		//执行登录方法,用捕捉异常去判断是否登录成功
		try {
			subject.login(userToken);
			System.out.println("登录成功");
			return "redirect:/info";
		} catch (UnknownAccountException e) {
			//用户名不存在
			model.addAttribute("msg","用户名不存在");
			System.out.println("用户名不存在");
			return "redirect:/login";
		}catch (IncorrectCredentialsException e) {
			//密码错误
			model.addAttribute("msg","密码错误");
			System.out.println("密码错误");
			return "redirect:/login";
		}
		
	}
 
}