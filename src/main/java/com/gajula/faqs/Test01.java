package com.gajula.faqs;

import java.util.*;
import java.util.stream.Collectors;
import static com.gajula.faqs.GajulaUtilHelper.getEmployeeList;

public class Test01 {

    public final static int intValue = 1234214512;
    public final static String intStringValue = "01010122013003010131001";
    public final static int[] intArrayValue = {1, 2, 4, 2, 6, 6, 2, 3, 5, 1, 3};
    public final static String[] stringArrayIntValue = new String[]{"123", "435", "123", "567", "234", "345", "123", "789"};
    public final static List<String> listOfStringNumeric = Arrays.asList("123", "435", "732", "123", "980", "567", "234", "345", "123", "789");
    public final static List<Integer> listOfIntegerNumeric = Arrays.asList(123, 435, 123, 567, 234, 345, 123, 789);
    public final static String stringValue = "abcbcadefghidacbdefge";
    public final static String[] stringArrayValue = new String[]{"test", "gajula", "bakash", "test", "test2", "gajula", "abc", "test3"};
    public final static List<String> listString = Arrays.asList("test", "gajula", "bakash", "test", "test2", "gajula", "abc", "test3");

    public static void main(String[] args) {
        // integers == 1234523, {1,2,3,2,5,7,2,9}, {"123", 435", 786"}, ("123", "435"), (123, 435)
        // strings  == "gajula", {"test", "gajula", "bakash"}, ("test", "gajula", "bakash")

        Set<Object> list1 = //Arrays.stream(String.valueOf(intValue).split(""))
          //Arrays.stream(String.valueOf(intStringValue).split(""))
          //Arrays.stream(intArrayValue).boxed()
          //Arrays.stream(stringArrayIntValue)
            listOfStringNumeric.stream()
                .map(Integer::valueOf)
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(m -> m.getValue() >1)
                .collect(Collectors.toSet());
        list1.stream().forEach(value -> { System.out.println("Value=="+value); });
        Object firstOccur = list1.stream().findFirst().get();
        System.out.println("firstOccur=="+firstOccur);

        List<Integer> list3 = //Arrays.stream(String.valueOf(intValue).split(""))
                //Arrays.stream(String.valueOf(intStringValue).split(""))
                //Arrays.stream(intArrayValue).boxed()
                //Arrays.stream(stringArrayIntValue)
                listOfStringNumeric.stream()
                    .map(Integer::valueOf)
                    .collect(Collectors.toSet())
                    .stream()
                    .distinct()
                    .sorted(Collections.reverseOrder())
                    .toList();
        System.out.println("List3=="+list3);
        System.out.println("Nth Highest====="+list3.get(2));

        Employee emp = getEmployeeList().stream()
                .sorted((emp1, emp2) -> emp1.getSalary().compareTo(emp2.getSalary()) == 0 ?
                        emp1.getSalary().compareTo(emp2.getSalary()):emp2.getSalary().compareTo(emp1.getSalary()) )
                .toList()
                .get(2);
        List<Employee> list = getEmployeeList().stream()
                .filter(employee -> emp.getEname().startsWith("startCHar"))
                .toList();
        getEmployeeList().stream()
                .map(Employee::getSalary)
                .collect(Collectors.groupingBy(value -> value, LinkedHashMap::new, Collectors.counting())) //Map<Object, Long>
                .entrySet()
                .stream()
                .filter(m -> m.getValue() > 1)
                .collect(Collectors.toSet()); //Set<Object>

    }
}
