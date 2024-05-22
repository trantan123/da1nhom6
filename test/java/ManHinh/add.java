package ManHinh;

import Model.ManHinh;
import Repository.ManHinh_DAO;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class add {

    // ma rong
    @Test(expected = IllegalArgumentException.class)
    public void add1() {
        ManHinh_DAO dao = new ManHinh_DAO();
        ManHinh manHinh = new ManHinh("", "IPS", "1920x1080", "5.5 inch", "500 nits", "cam ung");

        dao.insert(manHinh);
    }

    // full truong
    @Test
    public void add2() {
        ManHinh_DAO dao = new ManHinh_DAO();
        ManHinh manHinh = new ManHinh("MH11", "IPS", "1920x1080", "5.5 inch", "500 nits", "cam ung");

        dao.insert(manHinh);
        List<ManHinh> list = dao.selecBySQL("select * from ManHinh where MaManHinh ='MH11'");
        Assert.assertTrue(!list.isEmpty());
    }

    // cong nghe man hinh null
    @Test
    public void add3() {
        ManHinh_DAO dao = new ManHinh_DAO();
        ManHinh manHinh = new ManHinh("MH1111", "", "1920x1080", "5.5 inch", "500 nits", "cam ung");

        dao.insert(manHinh);
        List<ManHinh> list = dao.selecBySQL("select * from ManHinh where MaManHinh ='MH1111'");
        Assert.assertTrue(!list.isEmpty());
    }

    //do phan giai null
    @Test
    public void add4() {
        ManHinh_DAO dao = new ManHinh_DAO();
        ManHinh manHinh = new ManHinh("MH101", "IPS", "", "5.5 inch", "500 nits", "cam ung");

        dao.insert(manHinh);
        List<ManHinh> list = dao.selecBySQL("select * from ManHinh where MaManHinh ='MH101'");
        Assert.assertTrue(!list.isEmpty());
    }

    //kich thuoc null
    @Test
    public void add5() {
        ManHinh_DAO dao = new ManHinh_DAO();
        ManHinh manHinh = new ManHinh("MH107851", "IPS", "10x10", "", "500 nits", "cam ung");

        dao.insert(manHinh);
        List<ManHinh> list = dao.selecBySQL("select * from ManHinh where MaManHinh ='MH101'");
        Assert.assertTrue(!list.isEmpty());
    }


}
