package HoaDon;

import Model.DonHang;
import Model.HoaDonChiTiet;
import Repository.HoaDonDao;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class hienThi {

    // tim kiem thao ma hoa don
    @Test(expected = IllegalArgumentException.class)
    public void hienThi1(){
        HoaDonDao service = new HoaDonDao();
        ArrayList<HoaDonChiTiet> list = service.getAllHoaDonChiTietByMa("");
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void hienThi2(){
//        HoaDonDao service = new HoaDonDao();
//        ArrayList<HoaDonChiTiet> list = service.getAllHoaDonChiTietByMa("HD001");
//        Assert.assertTrue(!list.isEmpty());
//    }

    @Test(expected = IllegalArgumentException.class)
    public void hienThi3(){
        HoaDonDao service = new HoaDonDao();
        DonHang dh = service.getByID("");
        Assert.assertTrue(dh == null);
    }


}
