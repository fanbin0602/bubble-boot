package me.fanbin.bubble.auth.sms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author fanbin
 * @date 2022/1/19
 */
@RestController
@RequestMapping("/sms")
public class SmsCodeController {

    @GetMapping("/getCode")
    public String getCode(@RequestParam("mobile") String mobile,
                          HttpSession session) {
        String code = "123456";
        session.setAttribute("mobile", mobile);
        session.setAttribute("smsCode", code);
        return code;
    }

}
