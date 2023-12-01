package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainDay1 {
    public static void main(String[] args) {
        try {
            firstTaskSolution();
            secondTaskSolution();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    static  void  firstTaskSolution(){
        try {
            float start = System.nanoTime();
            BufferedReader br = new BufferedReader(new FileReader("src/day1/input.txt"));
            ArrayList<Integer> numbers = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                for (String number : line.split("\n")) {

                    String numberOnly= number.replaceAll("[^0-9]", "");
                    if(numberOnly.length()==1){
                        numbers.add(Integer.parseInt(numberOnly+numberOnly));

                    }if(numberOnly.length()>1){
                        numbers.add(Integer.parseInt(numberOnly.charAt(0)+String.valueOf(numberOnly.charAt(numberOnly.length()-1))));
                    }
                }
            }
            int sum = 0;
            for (Integer number : numbers) {
                sum += number;
            }
            float end = System.nanoTime();
            System.out.println("Part One:");
            System.out.println("Answer: " + sum);
            System.out.println("Time: " + (end - start) / 1000000 + "ms");


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void secondTaskSolution(){
        try {
            float start = System.nanoTime();
            BufferedReader br = new BufferedReader(new FileReader("src/day1/input.txt"));
            Map<String,Integer>letter= new HashMap<>();
            letter.put("one",1);
            letter.put("two",2);
            letter.put("three",3);
            letter.put("four",4);
            letter.put("five",5);
            letter.put("six",6);
            letter.put("seven",7);
            letter.put("eight",8);
            letter.put("nine",9);


            for (int i = 1; i < 10; i++)
            {
                letter.put(String.valueOf(i),i);
            }



            String line;
            int sum = 0;
            while ((line = br.readLine()) != null) {
                var firstIndex = line.length();
                var lastIndex = -1;
                var firstValue = 0;
                var lastValue = 0;

                for(var  a : letter.entrySet()){
                    var index = line.indexOf(a.getKey());

                    if(index==-1){
                           continue;
                    }
                    if(index<firstIndex){
                        firstIndex=index;
                        firstValue=a.getValue();
                    }
                    index = line.lastIndexOf(a.getKey());
                    if(index>lastIndex){
                        lastIndex=index;
                        lastValue=a.getValue();
                    }

                }

                var fullNumber = firstValue * 10 + lastValue;
                sum += fullNumber;
            }
            float end = System.nanoTime();
            System.out.println("Part Two:");
            System.out.println("Answer: " + sum);
            System.out.println("Time: " + (end - start) / 1000000 + "ms");


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
