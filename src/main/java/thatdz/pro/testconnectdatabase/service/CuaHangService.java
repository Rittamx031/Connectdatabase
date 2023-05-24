package thatdz.pro.testconnectdatabase.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thatdz.pro.testconnectdatabase.Repo.CuaHangRepository;
import thatdz.pro.testconnectdatabase.entity.CuaHang;

@Service
public class CuaHangService {
    // DI cuaHangrepository
    @Autowired
    private CuaHangRepository repository;

    public CuaHang saveCuaHang(CuaHang cuaHang) {
        return repository.save(cuaHang);
    }

    public List<CuaHang> saveCuaHangs(List<CuaHang> CuaHangs) {
        return repository.saveAll(CuaHangs);
    }

    public List<CuaHang> getCuaHangs() {
        return repository.findAll();
    }

    public CuaHang getCuaHangById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteCuaHang(UUID id) {
        repository.deleteById(id);
        return "CuaHang removed !! " + id;
    }

    public CuaHang updateCuaHang(CuaHang CuaHang) {
        CuaHang existingCuaHang = repository.findById(CuaHang.getId()).orElse(null);
        existingCuaHang.setId(CuaHang.getId());
        existingCuaHang.setDiaChi(CuaHang.getDiaChi());
        existingCuaHang.setTenCH(CuaHang.getTenCH());
        return repository.save(existingCuaHang);
    }
}
