package PhieuGiamGia;

import Model.PhieuGiamGia;
import Model.phieugiamgia1;
import Repository.PhieuGiamGia_DAO;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;

public class add {


    // ma rong
    @Test(expected = IllegalArgumentException.class)
    public void add1() {
        PhieuGiamGia_DAO dao = new PhieuGiamGia_DAO();
        PhieuGiamGia phieu = new PhieuGiamGia("", "NV001", "DK001", "TenPhieu", "LoaiGiamGia", "10000",
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                "Mô tả", 1, true);
        dao.insert(phieu);
    }

    // gia tri giam null
    @Test(expected = IllegalArgumentException.class)
    public void add2() {
        PhieuGiamGia_DAO dao = new PhieuGiamGia_DAO();
        PhieuGiamGia phieu = new PhieuGiamGia("PGG001", "NV001", "DK001", "TenPhieu", "LoaiGiamGia", "",
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                "Mô tả", 1, true);

        dao.insert(phieu);
    }

//  dieu kien giam gia null
    @Test(expected = IllegalArgumentException.class)
    public void add3() {
        PhieuGiamGia_DAO dao = new PhieuGiamGia_DAO();
        PhieuGiamGia phieu = new PhieuGiamGia("PGG001", "NV001", "", "TenPhieu", "LoaiGiamGia", "10000",
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                "Mô tả", 1, true);

        dao.insert(phieu);
    }

    //  nv null
    @Test(expected = IllegalArgumentException.class)
    public void add4() {
        PhieuGiamGia_DAO dao = new PhieuGiamGia_DAO();
        PhieuGiamGia phieu = new PhieuGiamGia("PGG00110", "", "DKGG001", "TenPhieu", "LoaiGiamGia", "10000",
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                "Mô tả", 1, true);

        dao.insert(phieu);
    }

    // pass
  @Test
    public void add5() {
      PhieuGiamGia_DAO dao = new PhieuGiamGia_DAO();
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        PhieuGiamGia phieu = new PhieuGiamGia("PGG0011111", "NV001", "DK001", "TenPhieu", "LoaiGiamGia", "10000",
                                                currentTime, currentTime, currentTime,
                                                "Mô tả", 1, true);

        try {
            dao.insert(phieu);

            List<PhieuGiamGia> list = dao.selecBySQL("select * from MaPhieuGiamGia = 'PGG0011111'");
            Assert.assertTrue(!list.isEmpty());
        } catch (IllegalArgumentException e) {
            Assert.fail("Unexpected IllegalArgumentException was thrown");
        }
    }
}
