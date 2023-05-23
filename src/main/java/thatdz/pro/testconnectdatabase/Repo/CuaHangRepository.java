package thatdz.pro.testconnectdatabase.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import thatdz.pro.testconnectdatabase.entity.CuaHang;

public interface CuaHangRepository extends JpaRepository<CuaHang,UUID> {
}
