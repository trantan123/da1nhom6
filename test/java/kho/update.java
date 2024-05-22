package kho;

import Model.Kho;
import Repository.Kho_DAO;
import org.junit.Test;

public class update {

    @Test(expected = IllegalArgumentException.class)
    public void update1() {
        Kho_DAO dao = new Kho_DAO();
        dao.update(new Kho("", "TenKho", "DiaChi"));
    }

    @Test
    public void update2() {
        Kho_DAO dao = new Kho_DAO();
        dao.update(new Kho("K001", "TenKho", "DiaChi"));
    }
}
