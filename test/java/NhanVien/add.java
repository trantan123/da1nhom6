package NhanVien;

import Model.Nhan_Vien;
import Repository.Nhan_Vien_Service;
import org.junit.Assert;
import org.junit.Test;

public class add {

    // ma rong
    @Test(expected = IllegalArgumentException.class)
    public void add1() {
        Nhan_Vien_Service dao = new Nhan_Vien_Service();
        Nhan_Vien nhanVien = new Nhan_Vien("", "Nguyen Van A", "123 Street", "1990-01-01", "0123456789", "avatar.jpg", "Nam", "password", "2024-04-10", "Active", "abc@example.com", "Employee");

        dao.add(nhanVien);
    }

    @Test
    public void add2() {
        Nhan_Vien_Service dao = new Nhan_Vien_Service();
        Nhan_Vien nhanVien = new Nhan_Vien("NV00123", "Nguyen Van A", "123 Street", "1990-01-01", "0123456789", "avatar.jpg", "Nam", "password", "2024-04-10", "Active", "abc@example.com", "Employee");

        Nhan_Vien nv = dao.searchByid("NV00123");
        Assert.assertTrue(nv != null);
    }

    // sdt null
    @Test
    public void add3() {
        Nhan_Vien_Service dao = new Nhan_Vien_Service();
        Nhan_Vien nhanVien = new Nhan_Vien("NV001234", "Nguyen Van A", "123 Street", "1990-01-01", "", "avatar.jpg", "Nam", "password", "2024-04-10", "Active", "abc@example.com", "Employee");

        Nhan_Vien nv = dao.searchByid("NV001234");
        Assert.assertTrue(nv != null);
    }
}
