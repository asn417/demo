package com.example.demo;

import com.example.demo.stream.DecryptData;
import com.example.demo.utils.ListUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    public void testListUtil(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("aa");
        list.add("dd");
        list.add("cc");

        List<String> list1 = ListUtil.distinct1(list);
        //ListUtil.distinct2(list);
        ListUtil.distinct3(list);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("list1 -> index:"+i+" -> "+list1.get(i));
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list2 -> index:"+i+" -> "+list.get(i));
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list3 -> index:"+i+" -> "+list.get(i));
        }
    }

    @Test
    public void md5HashTest( ) {
        String input = "/customerParam/addCustomerParam";
        try {
            //参数校验
            if (null == input) {
                return;
            }
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] digest = md.digest();
            BigInteger bi = new BigInteger(1, digest);
            String hashText = bi.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            System.out.println(hashText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void generateRand(){
        int rand = Integer.MAX_VALUE;
        Random random = new Random();
        int i = 100;
        do {
            rand = random.nextInt(10);
            System.out.println(rand);
            i--;
        }while (i>0);
    }

    @Test
    public  void toHash( ) {
        String key = "/customerParam/addCustomerParam";
        int arraySize = 11113; // 数组大小一般取质数
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) { // 从字符串的左边开始计算
            int letterValue = key.charAt(i) - 96;// 将获取到的字符串转换成数字，比如a的码值是97，则97-96=1
            // 就代表a的值，同理b=2；
            hashCode = ((hashCode << 5) + letterValue) % arraySize;// 防止编码溢出，对每步结果都进行取模运算
        }
        System.out.println(hashCode);
    }

    @Test
    public void testVoToMap(){
        List<Person> peoples = new ArrayList<>(Arrays.asList(
                new Person("name1?12", 12),
                new Person("name2?ad?qw", 13),
                new Person("name3 ", 33),
                new Person("name4", 21),
                new Person("name5", 22),
                new Person("name6/?sd", 15)
        ));
        Map<Integer,String> map = peoples.stream().map(person -> {
            if (person.getName().contains("?")){
                person.setName(person.getName().substring(0,person.getName().indexOf("?")));
            }
            return person;
        }).collect(Collectors.toMap(person -> {
            return person.getAge();
        },Person::getName));

        for (Integer age:map.keySet()){
            System.out.println(age+":"+map.get(age));
        }
    }

    @Test
    public void testMap(){
        List<Person> peoples = new ArrayList<>(Arrays.asList(
                new Person("name1?12", 12),
                new Person("name2?ad?qw", 13),
                new Person("name3 ", 33),
                new Person("name4", 21),
                new Person("name5", 22),
                new Person("name6/?sd", 15)
        ));
        List<String> list = peoples.stream().map(Person::getName).map(name -> {
            if (name.contains("?")){
                return name.substring(0,name.indexOf("?"));
            }
            return name;
        }).collect(Collectors.toList());
        System.out.println(list.size());
        for (String name:list
             ) {
            System.out.println(name);
        }


    }
    class Person {
        String name;
        String com;
        Integer age;
        Integer house;

        public Person(String name, String com, Integer age, Integer house) {
            this.name = name;
            this.com = com;
            this.age = age;
            this.house = house;
        }

        public Integer getHouse() {
            return house;
        }

        public void setHouse(Integer house) {
            this.house = house;
        }

        public Person() {
        }

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Person(String name, String com, Integer age) {
            this.name = name;
            this.com = com;
            this.age = age;
        }

        public String getCom() {
            return com;
        }

        public void setCom(String com) {
            this.com = com;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public int hashCode() {

            return Objects.hash(name, age);
        }

        @Override
        public String toString(){
            return "name="+name+",age="+age;
        }
    }
}
