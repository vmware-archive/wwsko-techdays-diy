package io.pivotal.wwsko;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by azwickey on 12/23/15.
 */
@RestController
public class DemoContoller {

    @RequestMapping("/test")
    public String test() {
        return "Hello from a cloud native platform";
    }
}
