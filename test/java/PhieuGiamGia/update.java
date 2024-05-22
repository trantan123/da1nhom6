package PhieuGiamGia;

import Model.PhieuGiamGia;
import Repository.PhieuGiamGia_DAO;
import org.junit.Test;

import java.sql.Timestamp;

public class update {

    @Test(expected = IllegalArgumentException.class)
    public void update1() {
        PhieuGiamGia_DAO dao = new PhieuGiamGia_DAO();
        PhieuGiamGia phieu = new PhieuGiamGia("", "NV001", "DK001", "TenPhieu", "LoaiGiamGia", "10000",
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                "Mô tả", 1, true);

        dao.update(phieu);
    }

    @Test(expected = IllegalArgumentException.class)
    public void update2() {
        PhieuGiamGia_DAO dao = new PhieuGiamGia_DAO();
        PhieuGiamGia phieu = new PhieuGiamGia("PGG001", "NV001", "DK001", "TenPhieu", "LoaiGiamGia", "",
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                "Mô tả", 1, true);

        dao.update(phieu);
    }

    @Test(expected = IllegalArgumentException.class)
    public void update3() {
        PhieuGiamGia_DAO dao = new PhieuGiamGia_DAO();
        PhieuGiamGia phieu = new PhieuGiamGia("PGG001", "NV001", "", "TenPhieu", "LoaiGiamGia", "10000",
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                "Mô tả", 1, true);

        dao.update(phieu);
    }

    @Test(expected = IllegalArgumentException.class)
    public void update4() {
        PhieuGiamGia_DAO dao = new PhieuGiamGia_DAO();
        PhieuGiamGia phieu = new PhieuGiamGia("PGG001", "", "DK001", "TenPhieu", "LoaiGiamGia", "10000",
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                "Mô tả", 1, true);

        dao.update(phieu);
    }

    @Test(expected = IllegalArgumentException.class)
    public void update5() {
        PhieuGiamGia_DAO dao = new PhieuGiamGia_DAO();
        PhieuGiamGia phieu = new PhieuGiamGia("PGG002", "NV001", "DK001", "TenPhieu", "LoaiGiamGia", "10000",
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                "Mô tả", 1, true);

        dao.update(phieu);
    }

}
