package com.mytest.controller.restAPI;

import com.mytest.Entries.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("log")
@RequestMapping(value = "/restAPI/logs")
public class LogController extends Base2<Log> {
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    @ResponseBody
    String update(@PathVariable("id") int id, @RequestBody Log object) {
        if (this.dao.select(id) == null) {
            return "{\"message\":\"记录不存在\"}";
        }
        if (object.getExtra() != null) {
            dao.update(id, "extra", object.getExtra() + "");
        }
        return "";
    }
}
