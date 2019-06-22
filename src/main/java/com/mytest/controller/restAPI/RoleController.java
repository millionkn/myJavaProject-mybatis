package com.mytest.controller.restAPI;

import com.mytest.Entries.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("roles")
@RequestMapping(value = "/restAPI/roles")
public class RoleController extends Base<Role> {
}
