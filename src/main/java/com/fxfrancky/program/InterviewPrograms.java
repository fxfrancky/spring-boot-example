package com.fxfrancky.program;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewPrograms {

    public static void main(String[] args) {
        //********** program monnaie
//        monnaie(1653);

        //********** second greatest
//        List<Integer> numList = List.of(3,5,6,8,9);
//        secondGreatest(numList);
//        List<Integer> numList2 = List.of(3,5,6,7,9);
//        secondGreatest(numList2);


        //************* exist number
//        List<Person> personList = List.of(new Person("kwahi","Leonard",34),new Person("Kevin","Durant",28));
//        Integer age = 28;
//        boolean b = existAge(personList,age);
//        System.out.println("Person with age %s was found ? %s".formatted(age, b) );

        //********** recursive reverse
//        String str = "Hello";
//        reverseString(str);


        //******* recursive factoriel
//        Integer int1 = 5;
//        System.out.println("The result of factoriel of %d is %d".formatted(int1,factoriel(int1)));

        // Capital every second Letter
        String str = "hello";
        evenCapitalLetter(str);
    }

    private static void monnaie(Integer amount){

        List<Integer> currencies = List.of(500,100,50,10,5,2,1);

        Integer restAmount = amount;
        Integer rest = 0;
        Map<Integer,Integer> monnaieResult = new HashMap<>();

        for (Integer curr: currencies){

            if (restAmount.equals(1) && curr.equals(1)){
                System.out.println("We have %d currencies of %d ".formatted(1,1));
            } else if (restAmount >=curr){
                if (restAmount % curr ==0){
                    rest = restAmount/curr;
                } else {
                    rest = (restAmount - (restAmount % curr))/curr;
                }
                monnaieResult.put(rest,curr);
                restAmount -= rest*curr;
                System.out.println("We have %d currencies of %d ".formatted(rest,curr));
            }


        }

    }

    public static int secondGreatest(List<Integer> numbersList){
        Integer max = numbersList.stream().max(Integer::compare).get();
        Integer secondMax = numbersList.stream().filter(s -> !s.equals(max)).max(Integer::compare).get();
        System.out.println("The second greatest number is %d".formatted(secondMax));
        return secondMax;
    }

    public static boolean existAge(List<Person> persons, Integer age){
        return persons.stream().map(p -> p.age()).anyMatch(a -> a.equals(age));
    }
    public record Person(String name, String firstname, Integer age){}

    public static void reverseString(String str){

        if (str.isBlank()){
            return;
        }
        System.out.println(str.charAt(str.length()-1));
        reverseString(str.substring(0,str.length()-1));
    }

    public static Integer factoriel(Integer num1){

        if (num1 <=1){
            return 1;
        }
        return num1*(factoriel(num1-1));
    }

    public static void evenCapitalLetter(String str){
        if(str.isBlank()){
            return;
        }
        for (int i =0;i<str.length();i++){
            if(i%2!=0){
                System.out.println(str.toUpperCase().charAt(i));
            } else{
                System.out.println(str.toLowerCase().charAt(i));
            }
        }
    }
}
