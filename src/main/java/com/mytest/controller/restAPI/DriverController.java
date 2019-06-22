package com.mytest.controller.restAPI;

import com.mytest.Entries.Driver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("driver")
@RequestMapping(value = "/restAPI/drivers")
public class DriverController extends Base2<Driver> {
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    @ResponseBody
    String update(@PathVariable("id") int id, @RequestBody Driver object) {
        if (this.dao.select(id) == null) {
            return "{\"message\":\"设备不存在\"}";
        }
        if (object.getName() != null) {
            dao.update(id, "name", object.getName() + "");
        }
        if (object.getOfficeId() != null) {
            dao.update(id, "officeId", object.getOfficeId() + "");
        }
        if (object.getBuyDate() != null) {
            dao.update(id, "buyDate", object.getBuyDate() + "");
        }
        if (object.getInspectionTimes() != null) {
            dao.update(id, "inspectiontimes", object.getInspectionTimes() + "");
        }
        if (object.getLine() != null) {
            dao.update(id, "line", object.getLine() + "");
        }
        if (object.getExtra() != null) {
            dao.update(id, "extra", object.getExtra() + "");
        }
        return "";
    }
}
