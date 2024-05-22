package kho;

import Model.Kho;
import Repository.Kho_DAO;
import org.junit.Test;

public class add {

    @Test(expected = IllegalArgumentException.class)
    public void add1() {
        Kho_DAO dao = new Kho_DAO();
        dao.insert(new Kho("", "TenKho", "DiaChi"));
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void add2() {
//        Kho_DAO dao = new Kho_DAO();
//        dao.insert(new Kho("K001", "TenKho", "DiaChi"));
//    }

    @Test
    public void add2() {
        Kho_DAO dao = new Kho_DAO();
        dao.insert(new Kho("MK003", "TenKho", "DiaChi"));
    }
}
