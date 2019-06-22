package com.mytest.controller.restAPI;

import com.mytest.Entries.Office;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("office")
@RequestMapping(value = "/restAPI/offices")
public class OfficeController extends Base2<Office> {
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    @ResponseBody
    String update(@PathVariable("id") int id, @RequestBody Office object) {
        if (this.dao.select(id) == null) {
            return "{\"message\":\"科室不存在\"}";
        }
        if (object.getName() != null) {
            dao.update(id, "name", object.getName());
        }
        if (object.getPersonId() != null) {
            dao.update(id, "personId", object.getPersonId() + "");
        }
        return "";
    }
}
