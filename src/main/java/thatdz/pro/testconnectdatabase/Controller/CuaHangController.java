package thatdz.pro.testconnectdatabase.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import thatdz.pro.testconnectdatabase.entity.CuaHang;
import thatdz.pro.testconnectdatabase.service.CuaHangService;

@Controller
public class CuaHangController {
    @Autowired
    public CuaHangService service;
    @GetMapping("index")
    public String getdatalist(Model model){
        List<CuaHang> listCuaHang = service.getCuaHangs();
        for (CuaHang cuaHang : listCuaHang) {
            System.out.println(cuaHang.toString());
        }
        model.addAttribute("listCH",listCuaHang);
        return "index";
    }
}
