package com.gajula.faqs;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class GajulaUtilHelper {

    public final static int numericValue1 = 1234214512;
    public final static String numericValue2 = "123421451253145216321";
    public final static String numericValue3 = "01010122013003010131001";
    public final static int[] numericValue4 = {1, 2, 4, 2, 6, 6, 2, 3, 5, 1, 3};
    public final static String[] arrayNumericValue1 = new String[]{"123", "435", "123", "567", "234", "345", "123", "789"};
    public final static String[] arrayNumericValue2 = new String[]{"3", "7", "2", "1", "4", "3", "1", "7"};
    public final static List<String> listOfStringNumeric1 = Arrays.asList("123", "435", "732", "123", "980", "567", "234", "345", "123", "789");
    public final static List<String> listOfStringNumeric2 = Arrays.asList("3", "7", "2", "1", "4", "3", "1", "7");
    public final static List<Integer> listOfIntegerNumeric1 = Arrays.asList(123, 435, 123, 567, 234, 345, 123, 789);
    public final static List<Integer> listOfIntegerNumeric2 = Arrays.asList(3, 7, 2, 1, 4, 3, 1, 7);

    public final static String stringValue1 = "abcbcadefghidacbdefge";
    public final static String stringValue2 = "abcbcadefghidacbdefge";
    public final static String[] arrayStringValue1 = new String[]{"test", "gajula", "bakash", "test", "test2", "gajula", "abc", "test3"};
    public final static String[] arrayCharValue1 = new String[]{"f", "w", "d", "a", "c", "c", "a", "d", "g", "c", "t", "n"};
    public final static List<String> listString1 = Arrays.asList("test", "gajula", "bakash", "test", "test2", "gajula", "abc", "test3");
    public final static List<String> listString2 = Arrays.asList("f", "w", "d", "a", "c", "c", "a", "d", "g", "c", "t", "n");

    public final static String inputPairsString = "[(]{}{[()()]()}";

    public void repeatedOrDuplicatesOrUniqueOrFirstRepeatOrFirstNonRepeatDigits(){
        System.out.println("======= repeatedOrDuplicatesOrUniqueOrFirstRepeatOrFirstNonRepeatDigits Start ==========");

        System.out.println("");
        System.out.println("INPUT=="+numericValue1);
        Map<Object, Long> result1 = Arrays.stream(String.valueOf(numericValue1).split(""))
                                    .map(Integer::valueOf)
                                    .collect(Collectors.groupingBy(value -> value, LinkedHashMap::new, Collectors.counting()));
        System.out.println("RESULT1=="+result1);
        Set<Object> result1_Repeated = result1.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT1 Repeated=="+result1_Repeated);
        Set<Object> result1_Unique = result1.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT1 Unique=="+result1_Unique);
        Integer result1_FIrstRepeated = (Integer) result1.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT1 FIrstRepeated=="+result1_FIrstRepeated);
        Integer result1_FIrstNonRepeated = (Integer) result1.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT1 FIrstNonRepeated=="+result1_FIrstNonRepeated);

        System.out.println("");
        System.out.println("INPUT== {1, 2, 4, 2, 6, 6, 2, 3, 5, 1, 3} ");
        Map<Object, Long> result2 = Arrays.stream(numericValue4).boxed()
                .collect(Collectors.groupingBy(value -> value, LinkedHashMap::new, Collectors.counting()));
        System.out.println("RESULT2=="+result2);
        Set<Object> result2_Repeated = result2.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT2 Repeated=="+result2_Repeated);
        Set<Object> result2_Unique = result2.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT2 Unique=="+result2_Unique);
        Integer result2_FIrstRepeated = (Integer) result2.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT2 FIrstRepeated=="+result2_FIrstRepeated);
        Integer result2_FIrstNonRepeated = (Integer) result2.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT2 FIrstNonRepeated=="+result2_FIrstNonRepeated);

        System.out.println("");
        System.out.println("INPUT== new String[]{\"123\", \"435\", \"123\", \"567\", \"234\", \"345\", \"123\", \"789\"}");
        Map<Object, Long> result3 = Arrays.stream(arrayNumericValue1)
                .collect(Collectors.groupingBy(value -> value, LinkedHashMap::new, Collectors.counting()));
        System.out.println("RESULT3=="+result3);
        Set<Object> result3_Repeated = result3.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT3 Repeated=="+result3_Repeated);
        Set<Object> result3_Unique = result3.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT3 Unique=="+result3_Unique);
        String result3_FIrstRepeated = (String) result3.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT3 FIrstRepeated=="+result3_FIrstRepeated);
        String result3_FIrstNonRepeated = (String) result3.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT3 FIrstNonRepeated=="+result3_FIrstNonRepeated);

        System.out.println("");
        System.out.println("INPUT=="+listOfStringNumeric1);
        Map<Object, Long> result4 = listOfStringNumeric1.stream()
                .collect(Collectors.groupingBy(value -> value, LinkedHashMap::new, Collectors.counting()));
        System.out.println("RESULT4=="+result4);
        Set<Object> result4_Repeated = result4.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT4 Repeated=="+result4_Repeated);
        Set<Object> result4_Unique = result4.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT4 Unique=="+result4_Unique);
        String result4_FIrstRepeated = (String) result4.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT4 FIrstRepeated=="+result4_FIrstRepeated);
        String result4_FIrstNonRepeated = (String) result4.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT4 FIrstNonRepeated=="+result4_FIrstNonRepeated);

        System.out.println("");
        System.out.println("INPUT=="+listOfStringNumeric2);
        Map<Object, Long> result5 = listOfStringNumeric2.stream()
                .collect(Collectors.groupingBy(value -> value, LinkedHashMap::new, Collectors.counting()));
        System.out.println("RESULT5=="+result5);
        Set<Object> result5_Repeated = result5.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT5 Repeated=="+result5_Repeated);
        Set<Object> result5_Unique = result5.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT5 Unique=="+result5_Unique);
        String result5_FIrstRepeated = (String) result5.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT5 FIrstRepeated=="+result5_FIrstRepeated);
        String result5_FIrstNonRepeated = (String) result5.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT5 FIrstNonRepeated=="+result5_FIrstNonRepeated);

        System.out.println("");
        System.out.println("INPUT=="+listOfIntegerNumeric1);
        Map<Object, Long> result6 = listOfIntegerNumeric1.stream()
                .collect(Collectors.groupingBy(value -> value, LinkedHashMap::new, Collectors.counting()));
        System.out.println("RESULT6=="+result6);
        Set<Object> result6_Repeated = result6.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT6 Repeated=="+result6_Repeated);
        Set<Object> result6_Unique = result6.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT6 Unique=="+result6_Unique);
        Integer result6_FIrstRepeated = (Integer) result6.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT6 FIrstRepeated=="+result6_FIrstRepeated);
        Integer result6_FIrstNonRepeated = (Integer) result6.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT6 FIrstNonRepeated=="+result6_FIrstNonRepeated);

        System.out.println("");
        System.out.println("INPUT=="+listOfIntegerNumeric2);
        Map<Object, Long> result7 = listOfIntegerNumeric2.stream()
                .collect(Collectors.groupingBy(value -> value, LinkedHashMap::new, Collectors.counting()));
        System.out.println("RESULT7=="+result7);
        Set<Object> result7_Repeated = result7.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT7 Repeated=="+result7_Repeated);
        Set<Object> result7_Unique = result7.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT7 Unique=="+result7_Unique);
        Integer result7_FIrstRepeated = (Integer) result7.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT7 FIrstRepeated=="+result7_FIrstRepeated);
        Integer result7_FIrstNonRepeated = (Integer) result7.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT7 FIrstNonRepeated=="+result7_FIrstNonRepeated);

        System.out.println("======= repeatedOrDuplicatesOrUniqueOrFirstRepeatOrFirstNonRepeatDigits End ==========");
    }

    public void repeatedOrDuplicatesOrUniqueOrFirstRepeatOrFirstNonRepeatCharsOrWords(){
        System.out.println("======= repeatedOrDuplicatesOrUniqueOrFirstRepeatOrFirstNonRepeatCharsOrWords Start ==========");

        System.out.println("");
        System.out.println("INPUT=="+stringValue1);
        Map<Object, Long> result1 = Arrays.stream(String.valueOf(stringValue1).split(""))
                .map(String::valueOf)
                .collect(Collectors.groupingBy(value -> value, LinkedHashMap::new, Collectors.counting()));
        System.out.println("RESULT1=="+result1);
        Set<Object> result1_Repeated = result1.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT1 Repeated=="+result1_Repeated);
        Set<Object> result1_Unique = result1.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT1 Unique=="+result1_Unique);
        String result1_FIrstRepeated = (String) result1.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT1 FIrstRepeated=="+result1_FIrstRepeated);
        String result1_FIrstNonRepeated = (String) result1.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT1 FIrstNonRepeated=="+result1_FIrstNonRepeated);

        System.out.println("");
        System.out.println("INPUT== new String[]{\"test\", \"gajula\", \"bakash\", \"test\", \"test2\", \"gajula\", \"abc\", \"test3\"} ");
        Map<Object, Long> result2 = Arrays.stream(arrayStringValue1)
                .collect(Collectors.groupingBy(value -> value, LinkedHashMap::new, Collectors.counting()));
        System.out.println("RESULT2=="+result2);
        Set<Object> result2_Repeated = result2.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT2 Repeated=="+result2_Repeated);
        Set<Object> result2_Unique = result2.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT2 Unique=="+result2_Unique);
        String result2_FIrstRepeated = (String) result2.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT2 FIrstRepeated=="+result2_FIrstRepeated);
        String result2_FIrstNonRepeated = (String) result2.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT2 FIrstNonRepeated=="+result2_FIrstNonRepeated);

        System.out.println("");
        System.out.println("INPUT=="+listString1);
        Map<Object, Long> result3 = listString1.stream()
                .collect(Collectors.groupingBy(value -> value, LinkedHashMap::new, Collectors.counting()));
        System.out.println("RESULT3=="+result3);
        Set<Object> result3_Repeated = result3.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT3 Repeated=="+result3_Repeated);
        Set<Object> result3_Unique = result3.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("RESULT3 Unique=="+result3_Unique);
        String result3_FIrstRepeated = (String) result3.entrySet().stream() .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT3 FIrstRepeated=="+result3_FIrstRepeated);
        String result3_FIrstNonRepeated = (String) result3.entrySet().stream() .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().get();
        System.out.println("RESULT3 FIrstNonRepeated=="+result3_FIrstNonRepeated);
        System.out.println("");

        System.out.println("======= repeatedOrDuplicatesOrUniqueOrFirstRepeatOrFirstNonRepeatCharsOrWords End ==========");
    }


    public void NthHighestNumberfromInt(int position){
        System.out.println("======= NthHighestNumberfromInt Start ==========");

        System.out.println("\nINPUT======"+numericValue1);
        List<String> list1 =  Arrays.stream(String.valueOf(numericValue1).split(""))
                .sorted(Collections.reverseOrder())
                .toList();
        System.out.println("List1=="+list1);
        System.out.println("Nth Highest====="+list1.get(position));

        System.out.println("\nINPUT====== {1, 2, 4, 2, 6, 6, 2, 3, 5, 1, 3}");
        List<Integer> list2 =  Arrays.stream(numericValue4)
                .boxed()
                .sorted(Collections.reverseOrder())
                .toList();
        System.out.println("List2=="+list2);
        System.out.println("Nth Highest====="+list2.get(position));

        System.out.println("\nINPUT======{\"123\", \"435\", \"123\", \"567\", \"234\", \"345\", \"123\", \"789\"}");
        List<Integer> list3 = Arrays.stream(arrayNumericValue1)
                .map(Integer::valueOf)
                .collect(Collectors.toSet())
                .stream()
                .sorted(Collections.reverseOrder()).toList();
        System.out.println("List3=="+list3);
        System.out.println("Nth Highest====="+list3.get(position));

        System.out.println("\nINPUT=="+listOfStringNumeric1);
        List<Integer> list4 = listOfStringNumeric1.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toSet())
                .stream()
                .sorted(Collections.reverseOrder()).toList();
        System.out.println("List4=="+list4);
        System.out.println("Nth Highest====="+list4.get(position));

        System.out.println("======= NthHighestNumberfromInt End ==========");
    }

    public void findAllElementsStartFromDigit(String digit){
        System.out.println("======= findAllElementsStartFromDigit Start ==========");

        System.out.println("\nINPUT===="+numericValue1);
        List<String> output1 = Arrays.stream(String.valueOf(numericValue1).split(""))
                .filter(b->b.startsWith(digit))
                .toList();
        System.out.println("RESULT===="+output1);

        System.out.println("\nINPUT==== {1, 2, 4, 2, 6, 6, 2, 3, 5, 1, 3}");
        List<String> output2 = Arrays.stream(numericValue4).boxed().map(String::valueOf)
                .filter(b->b.startsWith(digit))
                .toList();
        System.out.println("RESULT===="+output2);

        System.out.println("\nINPUT=====  String[]{\"123\", \"435\", \"123\", \"567\", \"234\", \"345\", \"123\", \"789\"}");
        List<String> output3 = Arrays.stream(arrayNumericValue1).map(String::valueOf)
                .filter(b->b.startsWith(digit))
                .toList();
        System.out.println("RESULT===="+output3);

        System.out.println("\nINPUT====="+listOfStringNumeric1);
        List<String> output4 = listOfStringNumeric1.stream().map(String::valueOf)
                .filter(b->b.startsWith("2"))
                .toList();
        System.out.println("RESULT===="+output4);

        System.out.println("======= findAllElementsStartFromDigit End ==========");
    }

    public void findAllElementsStartFromCharestor(String c){
        System.out.println("======= findAllElementsStartFromCharestor Start ==========");

        System.out.println("\nINPUT==== "+stringValue1);
        List<String> output1 = Arrays.stream(String.valueOf(stringValue1).split(""))
                .filter(b->b.startsWith(c))
                .toList();
        System.out.println("RESULT===="+output1);

        System.out.println("\nINPUT====  new String[]{\"test\", \"gajula\", \"bakash\", \"test\", \"test2\", \"gajula\", \"abc\", \"test3\"}");
        List<String> output2 = Arrays.stream(arrayStringValue1)
                .filter(b->b.startsWith(c))
                .toList();
        System.out.println("RESULT===="+output2);

        System.out.println("\nINPUT====="+listString1);
        List<String> output3 = listString1.stream().map(String::valueOf)
                .filter(b->b.startsWith(c))
                .toList();
        System.out.println("RESULT===="+output3);

        System.out.println("======= findAllElementsStartFromCharestor End ==========");
    }

    public void findPairsAreCorrectOrder(){
        System.out.println("======= findPairsAreCorrectOrder Start ==========");

        System.out.println("\nINPUT=========="+inputPairsString);
        //Stack<Character> stack  =  new Stack<>();//stack is synchronized so we can use Deque also
        Deque<Character> stack  =new  ArrayDeque<>();
        for(int i=0;i<inputPairsString.length();i++) {
            if(!(inputPairsString.charAt(i) == '}' || inputPairsString.charAt(i) == ']' || inputPairsString.charAt(i) == ')') ){
                stack.push(inputPairsString.charAt(i));
            }
            if((inputPairsString.charAt(i) == '}' || inputPairsString.charAt(i) == ']' || inputPairsString.charAt(i) == ')')) {
                if(stack.isEmpty())
                    System.out.println("Not Balanced ");
                char top = stack.pop();
                // Check if the popped opening bracket matches the current closing bracket
                if ((inputPairsString.charAt(i)  == ')' && top != '(') ||
                        (inputPairsString.charAt(i)  == ']' && top != '[') ||
                        (inputPairsString.charAt(i)  == '}' && top != '{')) {
                    System.out.println("Not Balanced ");
                }
            }
        }
        String result =  stack.isEmpty()  ? "Balanced" : "Not Balanced ";
        System.out.println("Result====="+result);

        System.out.println("======= findPairsAreCorrectOrder End ==========");
    }

    public void SwapTwoNumberWithoutThirdVariable(){
        System.out.println("======= SwapTwoNumberWithoutThirdVariable Start ==========");
        int x = 110, y = 215;
        System.out.println("Before Swapping x="+x+" y="+y);
        x = x + y; // x now becomes 15
        y = x - y; // y becomes 10
        x = x - y; // x becomes 5
        System.out.println("After Swapping x="+x+" y="+y);
        System.out.println("======= SwapTwoNumberWithoutThirdVariable End ==========");
    }

    public void arrangeSequentialOrder(){
        System.out.println("======= arrangeSequentialOrder Start ==========");
        System.out.println("INPUT======="+numericValue1);
        List<Integer> output1 = Arrays.stream(String.valueOf(numericValue1).split(""))
                .map(Integer::valueOf)
                .sorted().toList();
        System.out.println("OUTPUT1======="+output1);

        System.out.println("\nINPUT======="+numericValue3);
        List<Integer> output2 = Arrays.stream(numericValue3.split(""))
                .map(Integer::valueOf)
                .sorted().toList();
        System.out.println("OUTPUT2======="+output2);

        System.out.println("\nINPUT=======  {1, 2, 4, 2, 6, 6, 2, 3, 5, 1, 3}");
        List<Integer> output3 = Arrays.stream(numericValue4).boxed()
                .sorted().toList();
        System.out.println("OUTPUT2======="+output3);

        System.out.println("\nINPUT=======  new String[]{\"123\", \"435\", \"123\", \"567\", \"234\", \"345\", \"123\", \"789\"}");
        List<String> output4 = Arrays.stream(arrayNumericValue1)
                .sorted().toList();
        System.out.println("OUTPUT2======="+output4);

        System.out.println("\nINPUT======="+listOfStringNumeric1);
        List<String> output5 = listOfStringNumeric1.stream()
                .sorted().toList();
        System.out.println("OUTPUT2======="+output5);

        System.out.println("======= arrangeSequentialOrder End ==========");
    }

    public static List<Employee> getEmployeeList(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1101, "gajula", 110000.00));
        list.add(new Employee(1102, "bakash", 120000.00));
        list.add(new Employee(1103, "test", 130000.00));
        list.add(new Employee(1104, "gajula", 140000.00));
        list.add(new Employee(1105, "bakash", 150000.00));
        list.add(new Employee(1106, "abc", 160000.00));
        list.add(new Employee(1107, "xyz", 170000.00));
        list.add(new Employee(1108, "gajula", 180000.00));
        list.add(new Employee(1109, "pqr", 190000.00));
        list.add(new Employee(1110, "mno", 200000.00));
        return list;
    }


}

class Employee implements Serializable{
    private Integer empno;
    private String ename;
    private Double salary;

    public Employee(){}

    public Employee(Integer empno, String ename, Double salary) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                '}';
    }
}
