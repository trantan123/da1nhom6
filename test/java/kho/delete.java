package kho;

import Model.Kho;
import Repository.Kho_DAO;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class delete {

    @Test(expected = IllegalArgumentException.class)
    public void delete1() {
        Kho_DAO dao = new Kho_DAO();
        dao.delete("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void delete2() {
        Kho_DAO dao = new Kho_DAO();
        dao.delete("MK696969");
    }

//    @Test
//    public void delete3() {
//        Kho_DAO dao = new Kho_DAO();
//        dao.insert(new Kho("testdelete", "TenKho", "DiaChi"));
//
//        dao.delete("testdelete");
////
////        List<Kho> list = dao.selecBySQL("select * from Kho where MaKho = 'testdelete'");
////        Assert.assertTrue(list.isEmpty());
//    }
}
