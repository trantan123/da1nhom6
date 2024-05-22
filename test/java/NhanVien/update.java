package NhanVien;

import Model.Nhan_Vien;
import Repository.Nhan_Vien_Service;
import org.junit.Assert;
import org.junit.Test;

public class update {

    // ma can tim rong
    @Test(expected = IllegalArgumentException.class)
    public void update1() {
        Nhan_Vien_Service dao = new Nhan_Vien_Service();
        Nhan_Vien nhanVien = new Nhan_Vien("NV001", "Nguyen Van A", "123 Street", "1990-01-01", "0123456789", "avatar.jpg", "Nam", "password", "2024-04-10", "Active", "abc@example.com", "Employee");

        dao.updateSV("", nhanVien);
    }

    // ma nv null
    @Test(expected = IllegalArgumentException.class)
    public void update2() {
        Nhan_Vien_Service dao = new Nhan_Vien_Service();
        Nhan_Vien nhanVien = new Nhan_Vien("nv100000", "Nguyen Van A", "123 Street", "1990-01-01", "0123456789", "avatar.jpg", "Nam", "password", "2024-04-10", "Active", "abc@example.com", "Employee");

        dao.updateSV("nv100000", new Nhan_Vien());
    }

    // ma can tim null
    @Test(expected = IllegalArgumentException.class)
    public void update3() {
        Nhan_Vien_Service dao = new Nhan_Vien_Service();
        Nhan_Vien nhanVien = new Nhan_Vien("NV001ma00000", "Nguyen Van A", "123 Street", "1990-01-01", "0123456789", "avatar.jpg", "Nam", "password", "2024-04-10", "Active", "abc@example.com", "Employee");

        dao.updateSV("NV001ma00000", nhanVien);
    }

    // ma nv ma can tim khac nhau
    @Test(expected = IllegalArgumentException.class)
    public void update4() {
        Nhan_Vien_Service dao = new Nhan_Vien_Service();
        Nhan_Vien nhanVien = new Nhan_Vien("NV001", "Nguyen Van A", "123 Street", "1990-01-01", "0123456789", "avatar.jpg", "Nam", "password", "2024-04-10", "Active", "abc@example.com", "Employee");

        dao.updateSV("NV002", nhanVien);
    }

    // hop le
    @Test
    public void update5() {
        // Thêm một nhân viên vào cơ sở dữ liệu để kiểm tra việc cập nhật
        Nhan_Vien_Service dao = new Nhan_Vien_Service();
        Nhan_Vien nhanVien = new Nhan_Vien("NV001", "Nguyen Van A", "123 Street", "1990-01-01", "0123456789", "avatar.jpg", "Nam", "password", "2024-04-10", "Active", "abc@example.com", "Employee");
        dao.add(nhanVien);

        // Tạo một nhân viên mới để cập nhật
        Nhan_Vien updatedNhanVien = new Nhan_Vien("NV002", "Nguyen Van B", "456 Street", "1995-01-01", "0987654321", "new_avatar.jpg", "Nu", "new_password", "2024-04-15", "Inactive", "xyz@example.com", "Manager");

        try {
            int rowsAffected = dao.updateSV("NV001", updatedNhanVien);
            Assert.assertEquals(1, rowsAffected);

            // Kiểm tra xem nhân viên đã được cập nhật thành công trong cơ sở dữ liệu hay không
            Nhan_Vien retrievedNhanVien = dao.searchByid("NV002");
            Assert.assertNotNull(retrievedNhanVien);
            Assert.assertEquals("Nguyen Van B", retrievedNhanVien.getTenNV());
            Assert.assertEquals("456 Street", retrievedNhanVien.getDiaChi());
            // Kiểm tra các trường dữ liệu khác tương tự
        } catch (IllegalArgumentException e) {
            Assert.fail("Unexpected IllegalArgumentException was thrown");
        }
    }
}
