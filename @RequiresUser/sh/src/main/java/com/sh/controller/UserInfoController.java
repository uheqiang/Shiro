package com.sh.controller;

import com.sh.entities.UserInfo;
import com.sh.service.UserInfoService;
import org.apache.shiro.authz.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//@RequiresRoles("VIP1")
//@RequiresPermissions("save")
@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 注解@RequiresAuthentication：要求通过认证
     *
     * @return
     */
    @RequiresAuthentication
    @ResponseBody
    @GetMapping("/requiresAuthentication")
    public Map<String, Object> testRequiresAuthentication() {
        Map<String, Object> result = new HashMap<>();
        result.put("ok", "RequiresAuthentication");
        return result;
    }

    /**
     * 注解@RequiresUser：要求已经登录
     *
     * @return
     */
    @RequiresUser
    @ResponseBody
    @GetMapping("/requiresUser")
    public Map<String, Object> testRequiresUser() {
        Map<String, Object> result = new HashMap<>();
        result.put("ok", "RequiresUser");
        return result;
    }

    /**
     * 获取用户信息
     *
     * 注解@RequiresRoles：角色限制
     * 1.可以标记在类上。类中所有暴露出来的请求方法都将得到限制。
     * 2.可以标记在方法上。该方法将得到限制。
     * value：可以同时写多个角色。如：@RequiresRoles(value = {"VIP1","VIP2"})
     * logical：value是一个字符串数组，意味着可以写多个角色，那么这些角色是都满足还是满足其中一个呢？
     * 该属性就是说明角色们之间的关系，有两个取值，分别为Logical.AND和Logical.OR，顾名思义，
     * Logical.AND：都满足。如：@RequiresRoles(value = {"VIP1","VIP2"})，你需要同时满足VIP1和VIP2才行。
     * Logical.OR：满足其中一个。如：@RequiresRoles(value = {"VIP1","VIP2"})，你只需满足VIP1或VIP2。
     * <p>
     * 注解@RequiresPermissions：权限限制
     * 1.可以标记在类上。类中所有暴露出来的请求方法都将得到限制。
     * 2.可以标记在方法上。该方法将得到限制。
     * value：可以同时写多个权限。如：@RequiresPermissions(value = {"save","query"})
     * logical：value是一个字符串数组，意味着可以写多个权限，那么这些权限是都满足还是满足其中一个呢？
     * 该属性就是说明权限们之间的关系，有两个取值，分别为Logical.AND和Logical.OR，顾名思义，
     * Logical.AND：都满足。如：@RequiresRoles(value = {"save","query"})，你需要同时满足save和query才行。
     * Logical.OR：满足其中一个。如：@RequiresRoles(value = {"save","query"})，你只需满足save或query。
     *
     * @return
     */
    @RequiresRoles("VIP1")
    @RequiresPermissions("save")
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public UserInfo getUserInfo() {
        return userInfoService.getUserInfoByName("Tom");
    }


    /**
     * 只需要指定自定义登录界面
     * 对于Android、IOS等其他终端来说，返回Json即可。
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 指定自定义错误页面
     *
     * @return
     */
    @PostMapping("/error")
    public String error() {
        return "error";
    }

}
