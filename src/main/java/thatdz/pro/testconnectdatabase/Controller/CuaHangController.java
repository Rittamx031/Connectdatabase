package thatdz.pro.testconnectdatabase.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import thatdz.pro.testconnectdatabase.entity.CuaHang;
import thatdz.pro.testconnectdatabase.service.CuaHangService;

@Controller
public class CuaHangController {
    @Autowired
    public CuaHangService service;
    @Autowired CuaHang cuahang;
    @GetMapping("index")
    public String getdatalist(Model model){
        List<CuaHang> listCuaHang = service.getCuaHangs();
        for (CuaHang cuaHang : listCuaHang) {
            System.out.println(cuaHang.toString());
        }
        model.addAttribute("listCH",listCuaHang);
        return "index";
    }
    @ModelAttribute("cuahang")
    public CuaHang setSignUpForm() {
        return cuahang;
    }
    @GetMapping("create")
        public String goToCreateForm(){
        return "create";
    }
    @GetMapping("delete")
        public String deleteCuaHang(Model model, @RequestParam("id") String id)
    {
        service.deleteCuaHang(UUID.fromString(id));
        List<CuaHang> listCuaHang = service.getCuaHangs();
        model.addAttribute("listCH",listCuaHang);
        return "index";
    }
    @GetMapping("edit")
    public String editCuaHang(Model model,@RequestParam("id") String id){
        model.addAttribute("cuahang", service.getCuaHangById(UUID.fromString(id)));
        return "update";
    }
    @PostMapping("store")
    public String storeCuaHang(Model model,@Valid @ModelAttribute("cuaHang") CuaHang cuahang, BindingResult theBindingResult){
        if (theBindingResult.hasErrors()) {
            return "create";
        } else {
            service.saveCuaHang(cuahang);
            model.addAttribute("listCH",service.getCuaHangs());
          return "index";
        }
    }
    @PostMapping("update")
    public String update(@Valid @ModelAttribute("cuaHang") CuaHang cuahang, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            return "update";
        }
        service.updateCuaHang(cuahang);
        model.addAttribute("listCH",service.getCuaHangs());
        return "index"; 
    }
    
}
