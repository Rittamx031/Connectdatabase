package thatdz.pro.testconnectdatabase.Controller;

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

import java.util.ArrayList;
import java.util.UUID;
@Controller
public class CuaHangController {
    @Autowired
    private CuaHang cuaHang;
    private static ArrayList<CuaHang> listCH = new ArrayList<>( );
    static {
        // listCH.add(new CuaHang("thatdz" ,"thatdz",0));
        // listCH.add(new CuaHang("thatdz1" ,"diachi 1",1));
        // listCH.add(new CuaHang("thatdz2" ,"diachi 2",2));
        // listCH.add(new CuaHang("thatdz3" ,"diachi 3",3));
        // listCH.add(new CuaHang("thatdz4" ,"diachi 4",4));
    }
    public CuaHang getbyID(UUID id){
        for (CuaHang ch:listCH) {
            if(id == ch.getId()){
                return ch;
            }
        }
        return null;
    };


    @ModelAttribute("cuaHang")
    public CuaHang setSignUpForm() {
        return cuaHang;
    }

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listCH",listCH);
        System.out.println(listCH);
        return "index";
    }
    @GetMapping("create")
    public String create(){
        return "create";
    }
    @GetMapping("edit")
    public String edit(Model model , @RequestParam("id") String id){
        UUID idnumber = UUID.fromString(id);
        model.addAttribute("cuaHang", getbyID(idnumber));
        System.out.println(getbyID(idnumber).toString());
        return "update";
    }
    @GetMapping("delete")
    public String delete(Model model , @RequestParam("id") String id){
        UUID idnumber = UUID.fromString(id);
        CuaHang cuahangEdit = getbyID(idnumber);
        listCH.remove(cuahangEdit);
        model.addAttribute("listCH",listCH);
        return "index";
    }
    @PostMapping("store")
    public String store(Model model,@Valid @ModelAttribute("cuaHang") CuaHang cuaHang, BindingResult theBindingResult){
        listCH.add(cuaHang);
        model.addAttribute("listCH",listCH);
        if (theBindingResult.hasErrors()) {
            // model.addAttribute("null", theBindingResult.)
            return "create";
        } else {
          return "index";
        }
    }
    @PostMapping("update")
    public String update(@Valid @ModelAttribute("cuaHang") CuaHang cuaHang, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            return "update";
        }
        UUID idnumber = cuaHang.getId();
        CuaHang cuahangEdit = getbyID(idnumber);
        listCH.set(listCH.indexOf(cuahangEdit), cuaHang);
        model.addAttribute("listCH", listCH);
        return "index";
    }
    
}
