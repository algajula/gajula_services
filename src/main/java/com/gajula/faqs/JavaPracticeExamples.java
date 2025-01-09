package com.gajula.faqs;

public class JavaPracticeExamples {

    public static void main(String[] args) {
        GajulaUtilHelper helper = new GajulaUtilHelper();
        System.out.println("======= JavaPracticeExamples Start ==========");
        helper.repeatedOrDuplicatesOrUniqueOrFirstRepeatOrFirstNonRepeatDigits();
        helper.repeatedOrDuplicatesOrUniqueOrFirstRepeatOrFirstNonRepeatCharsOrWords();
        helper.NthHighestNumberfromInt(1); //pass position
        helper.findAllElementsStartFromDigit("2"); //pass digit
        helper.findAllElementsStartFromCharestor("g"); //pass charector
        String inputPairsString = "[(]{}{[()()]()}";
        helper.findPairsAreCorrectOrder(inputPairsString);
        inputPairsString = "[]{}{[()()]()}";
        helper.findPairsAreCorrectOrder(inputPairsString);
        helper.SwapTwoNumberWithoutThirdVariable();
        helper.arrangeSequentialOrder();

        System.out.println("======= Employee manipulation ========================");
        helper.getEmployeeListINPUT();
        helper.sortingEmployeesByEmpoyeeNameAndSalary();
        helper.findHighestSalaryfromEmployees();
        helper.findNthHighestSalaryfromEmployees(2);
        helper.findSameSalaryfromEmployees();
        helper.findEmployeeNameStartFromCharector("g");

        System.out.println("======= JavaPracticeExamples End ===========");
    }


    /*
        ############### Numerics: ######################
        Arrays.stream(String.valueOf(numericValue1).split(""))  == primitive to streams
        Arrays.stream(numericValue4).boxed()  == int[] to streams with wrapper object
        Arrays.stream(arrayNumericValue1)  == numerics of String[] to streams
        listOfStringNumeric1.stream()  == list<String> to streams String= "123"/123
        ################ Strings: ####################
        Arrays.stream(String.valueOf(stringValue1).split("")) == String Object to streams
        Arrays.stream(arrayStringValue1)  == String[] to streams
        listString1.stream()  == list<String> to streams
        ################ Intermediate operation: ################
        .map(Integer::valueOf)/ .map(Map.Entry::getKey)/ .map(String::valueOf) == Intermediate operation to convert exact type
        .sorted(Collections.reverseOrder()) == stateful intermediate operation.
        .sorted(Collections.reverseOrder((emp1, emp2) -> emp1.getEname().compareTo(emp2.getEname()) == 0 ?
                                emp1.getEname().compareTo(emp2.getEname()) : emp2.getEname().compareTo(emp1.getEname()) ) ) == stateful intermediate operation.
        .filter(b->b.startsWith(digit))  == intermediate operation
        .filter(m -> m.getValue() == 1) == intermediate operation
        ################ Terminal Operation: ################
        .collect(Collectors.toSet());
        .collect(Collectors.groupingBy(value -> value, LinkedHashMap::new, Collectors.counting()));
        .toList()
        .forEach(System.out::println);
        ################  Reduction Operation: ################
        .findFirst(), Collectors.counting(), Collectors.groupingBy()
     */
}

















