package tesstDienThoai;

import Model.DienThoai;
import Repository.DienThoai_DAO;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class testSearch {

    @Test
    public void test_null1() {
        DienThoai_DAO service = new DienThoai_DAO();

        List<DienThoai> result = service.select_Search(null);

        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void test_null2() {
        DienThoai_DAO service = new DienThoai_DAO();

        List<DienThoai> result = service.select_Search("");

        Assert.assertTrue(result.isEmpty());
    }

//    @Test
//    public void testSearchWithNonExistentKey() {
//        DienThoai_DAO service = new DienThoai_DAO();
//
//        List<DienThoai> result = service.select_Search("nonexistentkey");
//
//        Assert.assertTrue(result.isEmpty());
//    }

    @Test
    public void test_pass() {
        DienThoai_DAO service = new DienThoai_DAO();

        List<DienThoai> result = service.select_Search("DT001");

        Assert.assertTrue(!result.isEmpty());
    }
}
