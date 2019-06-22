package com.mytest.controller.restAPI;

import com.mytest.Entries.Supplier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("supplier")
@RequestMapping(value = "/restAPI/suppliers")
public class SupplierController extends Base2<Supplier> {
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    @ResponseBody
    String update(@PathVariable("id") int id, @RequestBody Supplier object) {
        if (this.dao.select(id) == null) {
            return "{\"message\":\"供应商不存在\"}";
        }
        if (object.getName() != null) {
            dao.update(id, "name", object.getName());
        }
        if (object.getBusinessLicense() != null) {
            dao.update(id, "Businesslicense", object.getBusinessLicense() + "");
        }
        if (object.getMedicalDeviceBusinessLicense() != null) {
            dao.update(id, "Medicaldevicebusinesslicense", object.getMedicalDeviceBusinessLicense() + "");
        }
        return "";
    }
}
