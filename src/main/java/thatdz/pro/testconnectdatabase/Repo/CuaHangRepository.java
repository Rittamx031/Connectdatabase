package thatdz.pro.testconnectdatabase.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import thatdz.pro.testconnectdatabase.entity.CuaHang;
// extend jsprepository to use all method query support by spring data jpa
public interface CuaHangRepository extends JpaRepository<CuaHang,UUID> {
}
