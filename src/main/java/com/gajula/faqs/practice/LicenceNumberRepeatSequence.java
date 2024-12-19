package com.gajula.faqs.practice;

public class LicenceNumberRepeatSequence {
    /*public static void main(String[] args) {
        String licenceNumber = "1234567891";
        //String licenceNumber = "2222224321";
        System.out.println("licenceNumber"+licenceNumber);
        checkIsNumberRepeated(licenceNumber);
        checkIsNumberSequentials(licenceNumber);
    }*/

    public static boolean checkIsNumberRepeated(String licenceNumber){
        boolean repeated = false;
        int singlefirstchar = Character.getNumericValue(licenceNumber.charAt(0));
        System.out.println("====checkIsNumberRepeated===="+licenceNumber);
        for(int i=1; i<licenceNumber.length(); i++){
            int nextchar = Character.getNumericValue(licenceNumber.charAt(i));
            if(i<6){
                if(singlefirstchar == nextchar) {
                    repeated = true;
                    System.out.println(singlefirstchar + "==" + nextchar);
                }
            }
        }
        System.out.println("Repeated=="+repeated);
        return repeated;
    }

    public static boolean checkIsNumberSequentials(String licenceNumber){
        boolean sequentials = false;
        int singlefirstchar = Character.getNumericValue(licenceNumber.charAt(0));
        System.out.println("===checkIsNumberSequentials==="+licenceNumber);
        for(int i=1; i<licenceNumber.length(); i++){
            int nextchar = Character.getNumericValue(licenceNumber.charAt(i));
            if(i<6){
                singlefirstchar = singlefirstchar + 1;
                if(singlefirstchar == nextchar) {
                    System.out.println(licenceNumber.charAt(0)+"=="+nextchar);
                    sequentials = true;
                }
            }
        }
        System.out.println("Sequentials=="+sequentials);
        return sequentials;
    }
}
