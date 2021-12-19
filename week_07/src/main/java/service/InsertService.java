package service;

import dao.InsertDAO;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class InsertService {
    @Autowired
    private InsertDAO insertDAO;

    public void insert(){
        for (int i = 1;i<100000;i++){
            insertDAO.insert(i,"订单"+i,1001);
        }
    }

    public void insertBatch(){
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 1;i<1000000;i++){
            HashMap<Object, Object> map = new HashMap<>();
            map.put("id",i);
            map.put("orderName","订单"+i);
            map.put("productId",1001);
            list.add(map);
            insertDAO.insertBartch(list);
        }
        insertDAO.insertBatch();
    }
}
