package net.iizs.aor.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DevConsoleController {

    @RequestMapping("/devconsole")
    public String devConsole() {
        return "devconsole";
    }

}
