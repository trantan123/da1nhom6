package HoaDon;

import Model.DonHang;
import Model.KhachHang;
import Repository.HoaDonDao;
import org.junit.Test;

public class update {


    // ma rong
    @Test(expected = IllegalArgumentException.class)
    public void update1() {
        HoaDonDao dao = new HoaDonDao();
        KhachHang kh = new KhachHang("KH001", "Nguyễn Văn An", true, "2000-01-01", "annv@gmail.com", "0123456789", "annv_vatar.jpg", null, true, null);
        DonHang donHang = new DonHang("", null, kh, "NV005", 120000000, "PGG005",  110000000, "Chuyển khoản", "Cũ", "Đã thanh toán");

        dao.update(donHang);
    }

    // khach hang rong
    @Test(expected = IllegalArgumentException.class)
    public void update2() {
        HoaDonDao dao = new HoaDonDao();
//        KhachHang kh = new KhachHang("KH001", "Nguyễn Văn An", true, "2000-01-01", "annv@gmail.com", "0123456789", "annv_vatar.jpg", null, true, null);
        DonHang donHang = new DonHang("HD001", null, null, "NV005", 120000000, "PGG005",  110000000, "Chuyển khoản", "Cũ", "Đã thanh toán");

        dao.update(donHang);
    }

    // nhan vien rong
    @Test(expected = IllegalArgumentException.class)
    public void update3() {
        HoaDonDao dao = new HoaDonDao();
        KhachHang kh = new KhachHang("KH001", "Nguyễn Văn An", true, "2000-01-01", "annv@gmail.com", "0123456789", "annv_vatar.jpg", null, true, null);
        DonHang donHang = new DonHang("HD001", null, kh, "", 120000000, "PGG005",  110000000, "Chuyển khoản", "Cũ", "Đã thanh toán");

        dao.update(donHang);
    }

    // test thanh cong
    @Test
    public void update4() {
        HoaDonDao dao = new HoaDonDao();
        KhachHang kh = new KhachHang("KH001", "Nguyễn Văn An", true, "2000-01-01", "annv@gmail.com", "0123456789", "annv_vatar.jpg", null, true, null);
        DonHang donHang = new DonHang("HD001", null, kh, "NV001", 120000000, "PGG005",  110000000, "Chuyển khoản", "Cũ", "Đã thanh toán");

        dao.update(donHang);
    }
}
