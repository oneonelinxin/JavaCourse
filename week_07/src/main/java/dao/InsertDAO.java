package dao;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface InsertDAO {
    @Insert("insert into order (id,name,product_id) values (#{id},#{orderName},#{productId})")
    int insert(int id, String orderName, int productId);

    int insertBartch(List<Object> list);
}
