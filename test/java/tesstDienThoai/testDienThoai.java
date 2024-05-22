package tesstDienThoai;

import Model.DienThoai;
import Repository.DienThoai_DAO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class testDienThoai {

//    @Test
//    public void add1(){
//        DienThoai_DAO service = new DienThoai_DAO();
//        service.insert(new DienThoai("DT00111122", "iPhone 13", "Apple", "CAM001", "KN001", "PS001", "iOS", "CPU001", "TI001", "MH001","iPhone mới nhất của Apple"));
//
//        List<DienThoai> list = service.selectAll();
//        Assert.assertEquals(6,list.size());
//    }

    // mã rong
    @Test(expected = IllegalArgumentException.class)
    public void add2(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.insert(new DienThoai("", "iPhone 13", "Apple", "CAM001", "KN001", "PS001", "iOS", "CPU001", "TI001", "MH001","iPhone mới nhất của Apple"));
    }

    // mã ket noi rong
    @Test(expected = IllegalArgumentException.class)
    public void add3(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.insert(new DienThoai("DT001", "iPhone 13", "Apple", "CAM001", "", "PS001", "iOS", "CPU001", "TI001", "MH001","iPhone mới nhất của Apple"));
    }

    // mã cam rong
    @Test(expected = IllegalArgumentException.class)
    public void add4(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.insert(new DienThoai("DT001", "iPhone 13", "Apple", "", "KN001", "PS001", "iOS", "CPU001", "TI001", "MH001","iPhone mới nhất của Apple"));
    }

    // mã pin sac rong
    @Test(expected = IllegalArgumentException.class)
    public void add5(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.insert(new DienThoai("DT001", "iPhone 13", "Apple", "CAM001", "KN001", "", "iOS", "CPU001", "TI001", "MH001","iPhone mới nhất của Apple"));
    }

    // mã HDH rong
    @Test(expected = IllegalArgumentException.class)
    public void add6(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.insert(new DienThoai("DT001", "iPhone 13", "Apple", "CAM001", "KN001", "PS001", "", "CPU001", "TI001", "MH001","iPhone mới nhất của Apple"));
    }

    // mã CPU rong
    @Test(expected = IllegalArgumentException.class)
    public void add7(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.insert(new DienThoai("DT001", "iPhone 13", "Apple", "CAM001", "KN001", "PS001", "iOS", "", "TI001", "MH001","iPhone mới nhất của Apple"));
    }

    // mã tien ich rong
    @Test(expected = IllegalArgumentException.class)
    public void add8(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.insert(new DienThoai("DT001", "iPhone 13", "Apple", "CAM001", "KN001", "PS001", "iOS", "CPU001", "", "MH001","iPhone mới nhất của Apple"));
    }

    // mã man hinh rong
    @Test(expected = IllegalArgumentException.class)
    public void add9(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.insert(new DienThoai("DT001", "iPhone 13", "Apple", "CAM001", "KN001", "PS001", "iOS", "CPU001", "TI001", "","iPhone mới nhất của Apple"));
    }

}
