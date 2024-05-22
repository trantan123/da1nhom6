package NhanVien;

import Model.Nhan_Vien;
import Repository.Nhan_Vien_Service;
import org.junit.Assert;
import org.junit.Test;

public class removw {

    // rong
    @Test(expected = IllegalArgumentException.class)
    public void delete1() {
        Nhan_Vien_Service dao = new Nhan_Vien_Service();
        dao.deleteSV("");
    }

    // khong tim thay ma
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteWithNonexistentMaNV() {
        Nhan_Vien_Service dao = new Nhan_Vien_Service();
        dao.deleteSV("NV999");
    }

    @Test
    public void testDeleteWithValidMaNV() {
        //Thêm một nhân viên vào cơ sở dữ liệu để kiểm tra việc xóa
        Nhan_Vien_Service dao = new Nhan_Vien_Service();
        Nhan_Vien nhanVien = new Nhan_Vien("test", "Nguyen Van A", "123 Street", "1990-01-01", "0123456789", "avatar.jpg", "Nam", "password", "2024-04-10", "Active", "abc@example.com", "Employee");
        dao.add(nhanVien);

        try {
            int rowsAffected = dao.deleteSV("test");
            Assert.assertEquals(1, rowsAffected);

            // Kiểm tra xem nhân viên có còn tồn tại trong cơ sở dữ liệu sau khi xóa hay không
            Nhan_Vien deletedNV = dao.searchByid("NV001");
            Assert.assertNull(deletedNV);
        } catch (IllegalArgumentException e) {
            Assert.fail("Unexpected IllegalArgumentException was thrown");
        }
    }
}
