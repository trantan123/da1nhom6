package tesstDienThoai;

import Model.DienThoai;
import Repository.DienThoai_DAO;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class testupdate {

    // mã rong
    @Test
    public void update(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.update(new DienThoai("DT001", "iPhone 13", "Apple", "CAM001", "KN001", "PS001", "iOS", "CPU001", "TI001", "MH001","iPhone mới nhất của Apple"));

    }

    // mã rong
    @Test(expected = IllegalArgumentException.class)
    public void update1(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.update(new DienThoai("", "iPhone 13", "Apple", "CAM001", "KN001", "PS001", "iOS", "CPU001", "TI001", "MH001","iPhone mới nhất của Apple"));
    }

    // mã khong ton tai
//    @Test(expected = IllegalArgumentException.class)
//    public void update2(){
//        DienThoai_DAO service = new DienThoai_DAO();
//        service.update(new DienThoai("asfsdfdagrg", "iPhone 13", "Apple", "CAM001", "KN001", "PS001", "iOS", "CPU001", "TI001", "MH001","iPhone mới nhất của Apple"));
//        service.gettendt("asfsdfdagrg");
////        Assert.
//    }

    @Test(expected = IllegalArgumentException.class)
    public void update3(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.update(new DienThoai("DT001", "iPhone 13", "Apple", "CAM001", "", "PS001", "iOS", "CPU001", "TI001", "MH001","iPhone mới nhất của Apple"));
    }

    // mã cam rong
    @Test(expected = IllegalArgumentException.class)
    public void update4(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.update(new DienThoai("DT001", "iPhone 13", "Apple", "", "KN001", "PS001", "iOS", "CPU001", "TI001", "MH001","iPhone mới nhất của Apple"));
    }

    // mã pin sac rong
    @Test(expected = IllegalArgumentException.class)
    public void update5(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.update(new DienThoai("DT001", "iPhone 13", "Apple", "CAM001", "KN001", "", "iOS", "CPU001", "TI001", "MH001","iPhone mới nhất của Apple"));
    }

    // mã HDH rong
    @Test(expected = IllegalArgumentException.class)
    public void update6(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.insert(new DienThoai("DT001", "iPhone 13", "Apple", "CAM001", "KN001", "PS001", "", "CPU001", "TI001", "MH001","iPhone mới nhất của Apple"));
    }

    // mã CPU rong
    @Test(expected = IllegalArgumentException.class)
    public void update7(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.update(new DienThoai("DT001", "iPhone 13", "Apple", "CAM001", "KN001", "PS001", "iOS", "", "TI001", "MH001","iPhone mới nhất của Apple"));
    }

    // mã tien ich rong
    @Test(expected = IllegalArgumentException.class)
    public void update8(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.update(new DienThoai("DT001", "iPhone 13", "Apple", "CAM001", "KN001", "PS001", "iOS", "CPU001", "", "MH001","iPhone mới nhất của Apple"));
    }

    // mã man hinh rong
    @Test(expected = IllegalArgumentException.class)
    public void update9(){
        DienThoai_DAO service = new DienThoai_DAO();
        service.update(new DienThoai("DT001", "iPhone 13", "Apple", "CAM001", "KN001", "PS001", "iOS", "CPU001", "TI001", "","iPhone mới nhất của Apple"));
    }

}
