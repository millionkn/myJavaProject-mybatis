package com.mytest.controller.restAPI;

import com.mytest.Entries.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("person")
@RequestMapping(value = "/restAPI/persons")
public class PersonController extends Base<User> {
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    @ResponseBody
    String update(@PathVariable("id") int id, @RequestBody User person) {
        User user = this.dao.select(id);
        if (user == null) {
            return "{\"message\":\"用户不存在\"}";
        }
        if (person.getName() != null) {
            dao.update(id, "name", person.getName());
        }
        if (person.getOfficeId() != null) {
            dao.update(id, "officeId", person.getOfficeId() + "");
        }
        if (person.getRoleId() != null) {
            dao.update(id, "roleId", person.getRoleId() + "");
        }
        return "";
    }
}
