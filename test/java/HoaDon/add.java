package HoaDon;

import Model.DonHang;
import Model.KhachHang;
import Repository.HoaDonDao;
import org.junit.Test;

public class add {

    // ma rong
    @Test(expected = IllegalArgumentException.class)
    public void add1() {
        HoaDonDao dao = new HoaDonDao();
        KhachHang kh = new KhachHang("KH001", "Nguyễn Văn An", true, "2000-01-01", "annv@gmail.com", "0123456789", "annv_vatar.jpg", null, true, null);
        DonHang donHang = new DonHang("", null, kh, "NV005", 120000000, "PGG005",  110000000, "Chuyển khoản", "Cũ", "Đã thanh toán");

        dao.insert(donHang);
    }

    // khach hang rong
    @Test(expected = IllegalArgumentException.class)
    public void add2() {
        HoaDonDao dao = new HoaDonDao();
//        KhachHang kh = new KhachHang("KH001", "Nguyễn Văn An", true, "2000-01-01", "annv@gmail.com", "0123456789", "annv_vatar.jpg", null, true, null);
        DonHang donHang = new DonHang("HD001", null, null, "NV005", 120000000, "PGG005",  110000000, "Chuyển khoản", "Cũ", "Đã thanh toán");

        dao.insert(donHang);
    }

    // nhan vien rong
    @Test(expected = IllegalArgumentException.class)
    public void add3() {
        HoaDonDao dao = new HoaDonDao();
        KhachHang kh = new KhachHang("KH001", "Nguyễn Văn An", true, "2000-01-01", "annv@gmail.com", "0123456789", "annv_vatar.jpg", null, true, null);
        DonHang donHang = new DonHang("HD001", null, kh, "", 120000000, "PGG005",  110000000, "Chuyển khoản", "Cũ", "Đã thanh toán");

        dao.insert(donHang);
    }

    // test thanh cong
    @Test
    public void add4() {
        HoaDonDao dao = new HoaDonDao();
        KhachHang kh = new KhachHang("KH001", "Nguyễn Văn An", true, "2000-01-01", "annv@gmail.com", "0123456789", "annv_vatar.jpg", null, true, null);
        DonHang donHang = new DonHang("HD00123", null, kh, "NV001", 120000000, "PGG005",  110000000, "Chuyển khoản", "Cũ", "Đã thanh toán");

        dao.insert(donHang);
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void testInsertWithNullKhachHang() {
//        HoaDonDao dao = new HoaDonDao();
//        DonHang donHang = new DonHang("HD001", /* other fields */);
//        donHang.setKhachHang(null);
//
//        dao.insert(donHang);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testInsertWithEmptyMaNV() {
//        HoaDonDao dao = new HoaDonDao();
//        DonHang donHang = new DonHang("HD001", /* other fields */);
//        donHang.setMaNV("");
//
//        dao.insert(donHang);
//    }
}
