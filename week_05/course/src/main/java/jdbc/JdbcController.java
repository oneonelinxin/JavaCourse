package jdbc;

import java.sql.SQLException;

@RestController
public class JdbcController {
    @Autowired
// jdbcTemplate 是springboot的核心文件  用来简化数据库操作,内部定义了很多避免错误的机制
// springboot默认提供了数据源com.zaxxer.hikari.HikariDataSource
// springboot自动注入数据源,使用它不用管理数据源,也不用管理关闭问题
            JdbcTemplate jdbcTemplate;
 
    @GetMapping("/query")
    public List<Map<String, Object>> queryAll() {
        String sql = "select * from user";
        System.out.println(jdbcTemplate);
//       执行sql语句
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
 
    //    增加用户
    @GetMapping("/addUser")
    public String addUser() {
        String sql = "insert into mybatis.user(id,name,pwd) values (5,'小明','123456')";
        jdbcTemplate.update(sql);
        return "addUser-ok";
    }

    //更新用户
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id) {
        String sql = "update mybatis.user set name=?,pwd=? where id=" + id;
        Object[] objects = new Object[2];
        objects[0] = "小明2";
        objects[1] = "zxcv";
        jdbcTemplate.update(sql, objects);
        return "updateUser-ok";
    }

    //删除用户
    @GetMapping("/delUser/{id}")
    public String delUser(@PathVariable("id") int id) {
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql, id);
        return "delUser-ok";
    }

    @RequestMapping("/druidData1")
    public String druidData1() throws SQLException {
        String sql1 = "INSERT INTO user_tmp(`id`, `username`) VALUES(22, 222)";
        // id=1的主键冲突插入失败
        String sql2 = "INSERT INTO user_tmp(`id`, `username`) VALUES(1, 111)";
        Connection conn = jdbcTemplate.getDataSource().getConnection();
        LOG.info("1:{}", conn);
        boolean ac = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            int[] rs2 = jdbcTemplate.batchUpdate(new String[]{sql1, sql2});
            conn.commit();
        } catch (Throwable e) {
            LOG.error("Error occured, cause by: {}", e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(ac);
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOG.error("Error occurred while closing connectin, cause by: {}", e.getMessage());
                }
            }
        }
        return "test";
    }
}
