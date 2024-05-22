package NhaSanXuat;

import Model.NhaSanXuat;
import Repository.NhaSanXuat_DAO;
import org.junit.Assert;
import org.junit.Test;

public class add {

    // Test case: Thêm một nhà sản xuất mới thành công
    @Test
    public void add1() {
        NhaSanXuat_DAO dao = new NhaSanXuat_DAO();
        NhaSanXuat nsx = new NhaSanXuat("NSX001ab", "Samsung", "Hàn Quốc", "Địa chỉ", "www.samsung.com", "info@samsung.com", "0123456789");

        try {
            dao.insert(nsx);
        } catch (IllegalArgumentException e) {
            Assert.fail("Unexpected IllegalArgumentException thrown: " + e.getMessage());
        }
    }

    // Test case: Thêm một nhà sản xuất với mã NSX đã tồn tại
//    @Test
//    public void testInsert_DuplicateMaNSX() {
//        NhaSanXuat_DAO dao = new NhaSanXuat_DAO();
//        NhaSanXuat nsx = new NhaSanXuat("NSX001a", "Samsung", "Hàn Quốc", "Địa chỉ", "www.samsung.com", "info@samsung.com", "0123456789");
//
//        dao.insert(nsx);
//    }

    // Test case: Thêm một nhà sản xuất với mã NSX rỗng
    @Test(expected = IllegalArgumentException.class)
    public void testInsert_EmptyMaNSX() {
        NhaSanXuat_DAO dao = new NhaSanXuat_DAO();
        NhaSanXuat nsx = new NhaSanXuat("", "Samsung", "Hàn Quốc", "Địa chỉ", "www.samsung.com", "info@samsung.com", "0123456789");

        dao.insert(nsx);
    }

    // Test case: Thêm một nhà sản xuất với thông tin hợp lệ, nhưng cơ sở dữ liệu gặp sự cố
//    @Test
//    public void testInsert_DatabaseError() {
//        // Giả sử cơ sở dữ liệu gặp lỗi khi thêm vào
//        // Trong trường hợp thực tế, bạn có thể sử dụng mock objects hoặc stubs để tái tạo tình huống này
//        NhaSanXuat_DAO dao = new NhaSanXuat_DAO();
//        NhaSanXuat nsx = new NhaSanXuat("NSX001234 ", "Sony", "Nhật Bản", "Địa chỉ", "www.sony.com", "info@sony.com", "0123456789");
//
//        try {
//            dao.insert(nsx);
//            Assert.fail("Expected IllegalArgumentException not thrown");
//        } catch (IllegalArgumentException e) {
//            // Kiểm tra rằng ngoại lệ đã được ném
//            Assert.assertNotNull(e.getMessage());
//        }
//    }
}
