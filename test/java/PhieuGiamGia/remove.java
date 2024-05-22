package PhieuGiamGia;

import Model.PhieuGiamGia;
import Repository.PhieuGiamGia_DAO;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;

public class remove {

    @Test(expected = IllegalArgumentException.class)
    public void remove1() {
        PhieuGiamGia_DAO dao = new PhieuGiamGia_DAO();
        dao.delete("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove2() {
        PhieuGiamGia_DAO dao = new PhieuGiamGia_DAO();
        dao.delete("PGG002jshdufhsuhf");
    }

//    @Test
//    public void remove3(){
//        PhieuGiamGia_DAO dao = new PhieuGiamGia_DAO();
//        PhieuGiamGia phieu = new PhieuGiamGia("PGG00123", "", "DKGG001", "TenPhieu", "LoaiGiamGia", "10000",
//                new Timestamp(System.currentTimeMillis()),
//                new Timestamp(System.currentTimeMillis()),
//                new Timestamp(System.currentTimeMillis()),
//                "Mô tả", 1, true);
//
//        dao.insert(phieu);
//        try {
//            dao.delete("PGG00123");
//            List<PhieuGiamGia> list = dao.select_Search("PGG00123");
//            Assert.assertTrue(list.isEmpty());
//
//        }catch (IllegalArgumentException i){
//            Assert.fail();
//        }
//    }
}
