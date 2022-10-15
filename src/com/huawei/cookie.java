package com.huawei;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:VictoryChan
 * @Description：
 * @Date:Creat in3:01 2022/10/16
 * @Modified By:
 */

@WebServlet("/cookie/generate")
public class cookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //创建cookie对象
        Cookie cookie=new Cookie("productid","132415649875777");
        Cookie cookie2=new Cookie("username","zhangsan");

        //设置cookie在一小时后失效，保存在硬盘文件中，只要大于0秒就会保存在硬盘，单位为秒
        //cookie.setMaxAge(60*60);
        //设置cookie的有效期为0，表示该cookie被删除，主要应用在：使用这种方式删除浏览器上的同名cookie
        //cookie.setMaxAge(0);
        //设置cookie的有效期<0,表示该cookie不会被存储(表示不会被存储到硬盘文件中，会放在浏览器运行内存中)
        cookie.setMaxAge(-1);//和不调用setMaxAge是同一效果。
        cookie2.setMaxAge(-1);


        //默认情况下，没有设置path的时候，cookie关联的路径是什么？
        cookie.setPath(request.getContextPath());
        cookie2.setPath(request.getContextPath());


        //将cookie响应到浏览器
        response.addCookie(cookie);
        response.addCookie(cookie2);
    }
}
