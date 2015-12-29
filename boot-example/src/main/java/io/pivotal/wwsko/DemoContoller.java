package io.pivotal.wwsko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by azwickey on 12/23/15.
 */
@RestController
public class DemoContoller {

    @Autowired
    private DataRepository _repo;

    @RequestMapping("/test")
    public String test() {
        _repo.save(new Model("azwickey", "hello world"));
        return "Hello from a cloud native platform";
    }

    @RequestMapping("/data")
    public Iterable<Model> dataTest() {
        return _repo.findAll();
    }
}
