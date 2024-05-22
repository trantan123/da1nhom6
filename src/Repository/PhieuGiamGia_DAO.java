package Repository;

import Model.PhieuGiamGia;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class PhieuGiamGia_DAO extends ServiceDAO<PhieuGiamGia, String>{

    final String insert_sql = "INSERT INTO PhieuGiamGia (MaPhieuGiamGia, MaNhanVien, MaDieuKienGiamGia, LoaiGiamGia, Giatri, NgayTao, NgayBatDau, NgayHetHan, MoTa, SoLanSuDung, TrangThaiPhieu) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
    final String update_sql = "UPDATE PhieuGiamGia SET   MaNhanVien =  ?, MaDieuKienGiamGia =  ?, TenPhieu = ?, LoaiGiamGia =  ?, Giatri =  ?, NgayTao =  ?, NgayBatDau =  ?, NgayHetHan =  ?, MoTa =  ?, SoLanSuDung =  ?, TrangThaiPhieu =  ? WHERE MaPhieuGiamGia = ? ";
    final String delete_sql = "DELETE FROM PhieuGiamGia WHERE MaPhieuGiamGia = ? ";
    final String select_All = "SELECT * FROM PhieuGiamGia";
    final String select_Search = "SELECT * FROM PhieuGiamGia WHERE MaPhieuGiamGia like ? ";
    
    @Override
    public void insert(PhieuGiamGia x) {
        if(x.getMaPhieuGiamGia().isEmpty()){
            System.out.println("ma PGG rong");
            throw new IllegalArgumentException();
        }

        if(x.getGiatri().isEmpty()){
            System.out.println("gia tri giam rong");
            throw new IllegalArgumentException();
        }

        if(x.getMaDieuKienGiamGia().isEmpty()){
            System.out.println("ma dieu kien giam gia null");
            throw new IllegalArgumentException();
        }
        if(x.getMaNV().isEmpty()){
            System.out.println("ma nv null");
            throw new IllegalArgumentException();
        }
        JDBC.JDBCHelPer.update(insert_sql, x.getMaPhieuGiamGia(), x.getMaNV(), x.getMaDieuKienGiamGia(), x.getLoaiGiamGia(), x.getGiatri(), x.getNgayTao(), x.getNgayBatDau(),  x.getNgayHetHan(), x.getMoTa(), x.getSoLanSuDung(), x.isTrangThaiPhieu());
    }

    @Override
    public void update(PhieuGiamGia x) {
        if(x.getMaPhieuGiamGia().isEmpty()){
            System.out.println("ma PGG rong");
            throw new IllegalArgumentException();
        }

        if(x.getGiatri().isEmpty()){
            System.out.println("gia tri giam rong");
            throw new IllegalArgumentException();
        }

        if(x.getMaDieuKienGiamGia().isEmpty()){
            System.out.println("ma dieu kien giam gia null");
            throw new IllegalArgumentException();
        }
        if(x.getMaNV().isEmpty()){
            System.out.println("ma nv null");
            throw new IllegalArgumentException();
        }
        List<PhieuGiamGia> list = selecBySQL("select * from PhieuGiamGia");
        for(PhieuGiamGia pgg : list){
            if(!x.getMaPhieuGiamGia().equals(pgg.getMaPhieuGiamGia())){
                System.out.println("khong tim thay ma cancap nhat");
                throw new IllegalArgumentException();

            }
        }
        JDBC.JDBCHelPer.update(update_sql, x.getMaPhieuGiamGia(), x.getMaNV(), x.getMaDieuKienGiamGia(), x.getLoaiGiamGia(), x.getGiatri(), x.getNgayTao(), x.getNgayBatDau(),  x.getNgayHetHan(), x.getMoTa(), x.getSoLanSuDung(), x.isTrangThaiPhieu());
    }

    @Override
    public void delete(String id) {
        if(id.isEmpty()){
            System.out.println("id can xoa rong!");
            throw new IllegalArgumentException();
        }
        List<PhieuGiamGia> list = selecBySQL("select * from PhieuGiamGia");
        for(PhieuGiamGia pgg : list){
            if(!pgg.getMaPhieuGiamGia().equals(id)){
                System.out.println("khong tim thay ma cancap nhat");
                throw new IllegalArgumentException();

            }
        }

        JDBC.JDBCHelPer.query(delete_sql, id);
    }

    @Override
    public List<PhieuGiamGia> selectAll() {
        return selecBySQL(select_All);
    }

    @Override
    public List<PhieuGiamGia> select_Search(String key) {
        return selecBySQL(select_Search, "%" + key + "" );
    }

    @Override
    public List<PhieuGiamGia> selecBySQL(String sql, Object... args) {
         ArrayList<PhieuGiamGia> list = new ArrayList<>();
        try {
             ResultSet rs = JDBC.JDBCHelPer.query(sql, args);
             while(rs.next()){
                 String mapgg = rs.getString(1);
                 String nv = rs.getString(2);
                 String dkGiam = rs.getString(3);
                 String tenphieu = rs.getString(4);
                 String loaigg = rs.getString(5);
                 String gitri = rs.getString(6);
                 Timestamp ngaytao = rs.getTimestamp(7);
                 Timestamp ngaybd = rs.getTimestamp(8);
                 Timestamp ngaykt = rs.getTimestamp(9);
                 String mota = rs.getString(10);
                 int solansudung = rs.getInt(11);
                 boolean trangthai = rs.getBoolean(12);
                
                 PhieuGiamGia o = new PhieuGiamGia(mapgg, nv, dkGiam,tenphieu, loaigg, gitri, ngaytao, ngaybd, ngaykt, mota, solansudung, trangthai);
                 list.add(o);
             }
        }  catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }


}
