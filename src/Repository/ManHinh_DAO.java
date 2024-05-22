package Repository;

import Model.ManHinh;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManHinh_DAO extends ServiceDAO<ManHinh, String> {

    final String insert_sql = "INSERT INTO ManHinh (MaManHinh, CongNgheManHinh, DoPhanGiai, KichThuoc, DoSang, ManHinhCamUng)  VALUES (?,?,?,?, ?, ?);";
    final String update_sql = "UPDATE ManHinh SET  CongNgheManHinh = ?, DoPhanGiai = ?, KichThuoc = ?, DoSang = ?, ManHinhCamUng = ? WHERE MaManHinh = ? ";
    final String delete_sql = "DELETE FROM ManHinh WHERE MaManHinh = ? ";
    final String select_All = "SELECT * FROM ManHinh";
    final String select_Search = "SELECT * FROM ManHinh WHERE MaManHinh = ? ";

    @Override
    public void insert(ManHinh x) {
        if(x.getMaManHinh().isEmpty()){
            System.out.println("ma man hinh rong");
            throw new IllegalArgumentException();
        }
        JDBC.JDBCHelPer.update(insert_sql, x.getMaManHinh(), x.getCongNgheManHinh(), x.getDoPhanGiai(), x.getKichThuoc(), x.getDoSang(), x.getManHinhCamUng());
    }

    @Override
    public void update(ManHinh x) {
        if(x.getMaManHinh().isEmpty()){
            System.out.println("ma man hinh rong");
            throw new IllegalArgumentException();
        }

        List<ManHinh> list = selecBySQL("select * from ManHinh");
        for(ManHinh mh : list){
            if(!mh.getMaManHinh().equals(x.getMaManHinh())){
                System.out.println("ma man hinh khong ton tai");
                throw new IllegalArgumentException();

            }
        }

        JDBC.JDBCHelPer.update(update_sql, x.getCongNgheManHinh(), x.getDoPhanGiai(), x.getKichThuoc(), x.getDoSang(), x.getManHinhCamUng(), x.getMaManHinh());
    }

    @Override
    public void delete(String id) {
        JDBC.JDBCHelPer.update(delete_sql, id);
    }

    @Override
    public List<ManHinh> selectAll() {
        return selecBySQL(select_All);
    }

    @Override
    public List<ManHinh> select_Search(String key) {
        return selecBySQL(select_Search, "%" + key + "%");
    }

    @Override
    public List<ManHinh> selecBySQL(String sql, Object... args) {
        ArrayList<ManHinh> list = new ArrayList<>();
        try {
            ResultSet rs = JDBC.JDBCHelPer.query(sql, args);
            while (rs.next()) {
                String mamanhinh = rs.getString(1);
                String CongNghe = rs.getString(2);
                String DoPhanGiai = rs.getString(3);
                String KichThuoc = rs.getString(4);
                String DoSang = rs.getString(5);
                String CamUng = rs.getString(6);

                ManHinh mn = new ManHinh(mamanhinh, CongNghe, DoPhanGiai, KichThuoc, DoSang, CamUng);
                list.add(mn);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }
}
