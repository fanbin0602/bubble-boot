package me.fanbin.bubble.auth.endpoints;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author fanbin
 * @date 2021/3/7
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthEndpoint {

    /**
     * 登录页面
     * @param modelAndView
     * @param error
     * @return
     */
    @GetMapping("/auth/login")
    public ModelAndView loginPage(ModelAndView modelAndView,
                                  @RequestParam(value = "error", required = false) String error) {
        modelAndView.setViewName("login");
        modelAndView.addObject("error", error);
        return modelAndView;
    }

}
