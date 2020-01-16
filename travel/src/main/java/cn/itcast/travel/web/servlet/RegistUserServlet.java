package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/RegistUserServlet")
public class RegistUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证码
        String check = request.getParameter("check");
        //从session中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = session.getAttribute("CHECKCODE_SERVER").toString();
        //为了保证验证码只能使用一次
        session.removeAttribute("CHECKCODE_SERVER");
        //比较
        if (checkcode_server ==null || !checkcode_server.equals(check)){
            //验证码错误
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误！");
            //将info对象序列化
            String json = JSON.toJSONString(resultInfo);
            //将json数据写回客户端
            //设置
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }


        //1 获取数据
        Map<String, String[]> map = request.getParameterMap();
        //2 封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3 调用service完成注册
        UserService userService = new UserServiceImpl();
        boolean flag = userService.register(user);
        ResultInfo resultInfo = new ResultInfo();
        //4 响应结果
        if (flag){
            //注册成功
            resultInfo.setFlag(true);
        } else {
            //注册失败
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败！");
        }
        //5 将info对象序列化
        String json = JSON.toJSONString(resultInfo);
        //6 将json数据写回客户端
        //设置
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
