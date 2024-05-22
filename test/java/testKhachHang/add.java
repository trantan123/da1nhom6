package testKhachHang;

import Model.HangKhachHang;
import Model.KhachHang;
import Repository.KhachHangDAO;
import org.junit.Assert;
import org.junit.Test;

public class add {
    @Test
    public void add() {
        KhachHangDAO dao = new KhachHangDAO();
        KhachHang khachHang = new KhachHang("", "Nguyen Van A", true, "1990-01-01", "abc@example.com", "123456789", "avatar.jpg", "Ghi chu", true, new HangKhachHang(1, "Hang 1", 2, 5000));

        try {
            dao.insert(khachHang);
            Assert.fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }
}
