package com.example.demo.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingInt;

public class DecryptData {

    public static void main(String[] args) throws Exception {
        DecryptData d = new DecryptData();

        List<Person> peoples = new ArrayList<>(Arrays.asList(
                new Person("name1", 12),
                new Person("name2", 13),
                new Person("name3", 33),
                new Person("name1", 21),
                new Person("name1", 22),
                new Person("name2", 15)
        ));

        //过滤数据，获取年龄小于15的person
        //1）过滤后返回一个list
        List<Person> list = peoples.stream().filter(person -> person.getAge() < 30).collect(Collectors.toList());
        //2）过滤后直接forEach遍历输出
        peoples.stream().filter(person -> person.getAge() < 30).forEach(System.out::println);
        //3）过滤后获取每个person的name属性
        List<String> nameList = peoples.stream().filter(person -> person.getAge() < 30).map(person->person.getName()).collect(Collectors.toList());
        List<String> nameList1 = peoples.stream().filter(person -> person.getAge() < 30).map(Person::getName).collect(Collectors.toList());
        nameList.stream().forEach(System.out::println);
        nameList1.stream().forEach(System.out::println);

        //4）根据age从小到大排序
        //peoples.stream().sorted().forEach(System.out::println);//会报错，class com.example.demo.stream.DecryptData$Person cannot be cast to class java.lang.Comparable
        peoples.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
        //5）根据age从大到小排序
        peoples.stream().sorted(Comparator.comparing(Person::getAge).reversed()).forEach(System.out::println);
        //6）现根据age排序，再根据name排序
        peoples.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName)).forEach(System.out::println);
        //7）另一种排序方式（这种就不是流了）
        peoples.sort(Comparator.comparing(Person::getAge));

        //8）分组统计，统计相同name的age总和(IntSummaryStatisticsd对象包含计数、合计、最大、最小和平均)
        Map<String, IntSummaryStatistics>  map= peoples.stream().collect(groupingBy(Person::getName,summarizingInt(Person::getAge)));
        //map不能转成stream，但set可以。。。
        map.keySet().stream().forEach(item -> System.out.println(map.get(item)));

    }

    public void testName() throws Exception {
        List<Person> peoples = new ArrayList<>(Arrays.asList(
                new Person("name1", 12),
                new Person("name2", 13),
                new Person("name2", 14),
                new Person("name3", 15)
        ));
        // 传统增强for
        for (Person people : peoples) {
            System.out.println(people.getName());
        }
        // 新特性ForEach
        peoples.forEach(people -> System.out.println(people.getName()));
    }

    public void filterAge() throws Exception {
        List<Person> peoples = new ArrayList<>(Arrays.asList(
                new Person("name1", 12),
                new Person("name2", 13),
                new Person("name3", 33),
                new Person("name4", 21),
                new Person("name1", 22),
                new Person("name2", 15)
        ));
        // 传统过滤
        List<Person> ps = new ArrayList<>();
        for (Person people : peoples) {
            if (people.getAge() > 18) {
                ps.add(people);
            }
        }
        System.err.println(ps);
        // 新特性过滤
        List<Person> collect = peoples.stream().filter(person -> person.getAge() > 18).collect(Collectors.toList());
        System.err.println(collect);
    }

    public void filterFailed() throws Exception {

        List<Person> peoples = new ArrayList<>(Arrays.asList(
                new Person("name1", 12),
                new Person("name2", 13),
                new Person("name3", 33),
                new Person("name4", 21),
                new Person("name1", 22),
                new Person("name2", 15)
        ));
        // 传统增强for
        List<String> names = new ArrayList<>();
        for (Person people : peoples) {
            names.add(people.getName());
        }
        System.err.println(names);
        // 新特性ForEach
        List<String> collect = peoples.stream().map(Person::getName).collect(Collectors.toList());
        System.err.println(collect);

    }

    public void statistic() throws Exception {
        // 统计每个人房子数量
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        List<Person> peoples = new ArrayList<>(Arrays.asList(
                new Person("思聪", "杭州", 19, 50),
                new Person("马云", "北京", 50, 100),
                new Person("思聪", "北京", 19, 20),
                new Person("温州大婶", "西安", 1, 120),
                new Person("温州大婶", "杭州", 1, 100),
                new Person("我", null, 18, 0),
                new Person("温州大婶", "新西兰", 1, 200)
        ));
        // 传统增强for 统计
        List<Integer> sum = new ArrayList<>();
        for (Person people : peoples) {
            //人生如此艰难，我还要继续。。。此处省略
        }
        System.err.println(sum);

        // 新特性ForEach
        Map<String, IntSummaryStatistics> map = peoples.stream().collect(groupingBy(Person::getName, summarizingInt(Person::getHouse)));
        System.err.println(map);

    }

    static class Person {
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DecryptData.Person person = (DecryptData.Person) o;
            return Objects.equals(name, person.name) &&
                    Objects.equals(age, person.age);
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
