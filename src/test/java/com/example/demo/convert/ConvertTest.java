package com.example.demo.convert;

import com.example.demo.converter.IPersonConverter;
import com.example.demo.entity.Person;
import com.example.demo.entity.User;
import com.example.demo.enums.MfAnnouncementCategoryEnum;
import com.example.demo.utils.PageUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author snq
 * @Date 2022/4/29 13:38
 */
@SpringBootTest
public class ConvertTest {

    @Resource
    IPersonConverter personConverter;

    @Test
    void convert() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person personTemp = new Person();
            personTemp.setId(i);
            personTemp.setName("name" + i);
            personTemp.setEmail("email" + i);
            personTemp.setBirthday(LocalDateTime.now());
            User userTemp = new User();
            userTemp.setAge(i);
            personTemp.setUser(userTemp);
            personList.add(personTemp);
        }
        System.out.println(IPersonConverter.INSTANCE.toConvertVOList(personList).toString());
    }

    @Test
    void convert1() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person personTemp = new Person();
            personTemp.setId(i);
            personTemp.setName("name" + i);
            personTemp.setEmail("email" + i);
            personTemp.setBirthday(LocalDateTime.now());
            User userTemp = new User();
            userTemp.setAge(i);
            personTemp.setUser(userTemp);
            personList.add(personTemp);
        }
        System.out.println(personConverter.toConvertVOList(personList).toString());
    }


    @Test
    void converter() {
        Person person = new Person();
        person.setId(1);
        person.setName("name");
        person.setEmail("email");
        person.setBirthday(LocalDateTime.now());
        User user = new User();
        user.setAge(1);
        person.setUser(user);

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person personTemp = new Person();
            personTemp.setId(i);
            personTemp.setName("name" + i);
            personTemp.setEmail("email" + i);
            personTemp.setBirthday(LocalDateTime.now());
            User userTemp = new User();
            userTemp.setAge(i);
            personTemp.setUser(userTemp);
            personList.add(personTemp);
        }
        System.out.println(personConverter.toConvertPersonDTO(person));
        System.out.println(personConverter.toConvertPersonVO(person));
        System.out.println(personConverter.toConvertVOList(personList).toString());
    }

    @Test
    void t1() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("s" + i);
        }
        System.out.println(list.subList(0, list.size()));
    }

    @Test
    void t2() {
        String truename="MF_QDIIPortfolioDetail";
        System.out.println(truename);
        String[] before=truename.split("_");

        String bigname="";

        for (int i = 0; i < before.length; i++) {
            if (StringUtils.isNotEmpty(before[i])){
                bigname+=before[i].substring(0,1).toUpperCase(Locale.ROOT)+before[i].substring(1,before[i].length()).toLowerCase(Locale.ROOT);
            }
        }
//        for (int i = 0; i < before.length; i++) {
//            if (StringUtils.isNotEmpty(before[i])){
//                bigname+=before[i].substring(0,1).toUpperCase(Locale.ROOT)+before[i].substring(1,before[i].length());
//            }
//        }
        System.out.println("转换后：");
        System.out.println(bigname);
    }

    @Test
    void t3() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            list.add("s" + i);
        }
//        System.out.println(PageUtil.startPage(list, 1, 10));
        saveDataByPage(list);
    }

    private void saveDataByPage(List<?> list) {
        if (!list.isEmpty()) {
            int i = 1;
            int total = 0;
            for ( ; ;) {
                List<?> saveList = PageUtil.startPage(list, i, 10);
                System.out.println(saveList.toString());
                if (saveList.size() < 10) break;
                i++;
            }
//            while (total < list.size()){
//                List<?> saveList = PageUtil.startPage(list, i, 10);
//                System.out.println(saveList.toString());
//                total += saveList.size();
//                i++;
//            }
//            do {
//                List<?> saveList = PageUtil.startPage(list, i, 10);
//                System.out.println(saveList.toString());
//                if (total >= list.size()) {
//                    break;
//                }
//                total += saveList.size();
//                i++;
//            } while (total < list.size());
        }
    }

    @Test
    void t4() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("s" + i);
        }
        doString(list);
        System.out.println(list);
    }

    public void doString(List<String> strings) {
        strings.add("*********");
    }

    @Test
    void t5() {
        BigDecimal b1 = new BigDecimal("460514956.1000");
        System.out.println(b1.divide(BigDecimal.valueOf(100000000))); // 4.60514956
        System.out.println(b1.divide(BigDecimal.valueOf(100000000),8, BigDecimal.ROUND_HALF_UP)); // 4.60514956
        BigDecimal b2 = new BigDecimal("37.28");
//        System.out.println(b2.divide(BigDecimal.valueOf(12), new MathContext(6))); // 3.106667
        System.out.println(b2.divide(BigDecimal.valueOf(12), 6, BigDecimal.ROUND_HALF_UP)); // 3.106667
    }

    @Test
    void t6() {
        Map<String, Person> map = new LinkedHashMap<>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setId(i);
            p.setName("name" + i);
            map.put("k:" + i, p);
        }

        System.out.println(map.values().stream().map(Person::getId).collect(Collectors.toList()));
    }

    @Test
    void t7() {
        String s = "marks.earch";
        String r  = sub(s);
        System.out.println(r);
    }

    private String sub(String s) {
        if (s.contains(".")) {
            return s.substring(s.indexOf(".")+1);
        }
        return null;
    }

    @Test
    void t8() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            strings.add("s" + i);
        }
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            stringList.add("sl" + i);
        }
        strings = stringList;
        System.out.println(strings);
    }

    @Test
    void t9() {
        MfAnnouncementCategoryEnum[] strings = MfAnnouncementCategoryEnum.values();
        System.out.println(Arrays.toString(strings));
        System.out.println(MfAnnouncementCategoryEnum.getCategoryName(5));
        System.out.println(MfAnnouncementCategoryEnum.getCategoryNames());
    }

}
