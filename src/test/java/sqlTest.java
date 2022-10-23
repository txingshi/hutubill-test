import com.exercise.hutubill.mapper.CategoryMapper;
import com.exercise.hutubill.mapper.RecordMapper;
import com.exercise.hutubill.pojo.Category;
import com.exercise.hutubill.pojo.Record;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LuckyMi
 * @sine 2022/9/21 15:05
 */

@ContextConfiguration(locations = { "classpath:spring.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class sqlTest {

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    RecordMapper recordMapper;
    @Test
    public void testOneMay(){
        List<Category> list = categoryMapper.getAllCategoryNameAndCount();

        //System.out.println(list.get(5).getRecordList().size());
        for (Category category : list) {
            System.out.println(category);
        }
        //for (int i = 0; i < map.size(); i++) {
        //    System.out.println(map.get(i).get("recordList").getRecordList());
        //
        //}

        //for (Map<String, Category> categoryMap : map) {
        //    for (String s : categoryMap.keySet()) {
        //        System.out.println(s);
        //        System.out.println(categoryMap.get(s));
        //    }
        //}
        //for (String s : map.keySet()) {
        //    System.out.println(s);
        //}
        //List<Record> recordBySortId = recordMapper.getRecordBySortId(1);
        ////for (Record record : recordBySortId) {
        //    System.out.println(recordBySortId.get(1).getComment());
        ////}

    }

    @Test
    public void getSpendBasisDay(){
        List<Map<String, Object>> allSpendBasisDay = recordMapper.getAllSpendBasisDay();
        for (Map<String, Object> map : allSpendBasisDay) {
            for (String key : map.keySet()) {
                if (key.equals("date")){
                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                    String dateStr = fmt.format(map.get(key));
                    System.out.println(key + ":" + dateStr.substring(8));
                }else {
                    System.out.println(key + ":" + map.get(key));
                }
            }

        }
    }



}
