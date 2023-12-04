package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class MainDay4 {

    public static void main(String[] args) {
        try {
            String fileName = "src/day4/input.txt";
            StringBuilder inputDataBuilder = new StringBuilder();
            String line;
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                inputDataBuilder.append(line.trim()).append("\n");
            }
           firstTaskSolution(inputDataBuilder);
            secondTaskSolution(inputDataBuilder);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static  void  firstTaskSolution(StringBuilder inputDataBuilder){
        try {
            float start = System.nanoTime();
            String[] lines = inputDataBuilder.toString().split("\n");
            int sum=0;
            for (String line : lines) {
                String[] parts = line.split("\\|");
                String[] firstParts = parts[0].split(":");
                String card = firstParts[1].trim();
                String[] cardNums = card.split("\\s+");
                Set<Integer> cardSet = new HashSet<>();
                for (String num : cardNums) {
                    cardSet.add(Integer.parseInt(num));
                }
                String[] restNums = parts[1].trim().split("\\s+");
                Set<Integer> restSet = new HashSet<>();
                for (String num : restNums) {
                    restSet.add(Integer.parseInt(num));
                }

                int val = intersectionSize(cardSet, restSet);
                if (val > 0) {
                    sum += Math.pow(2, val - 1);
                }


            }


            System.out.println("Part One:");
            System.out.println("Answer: " + sum);
            float end = System.nanoTime();
            System.out.println("Time: " + (end - start) / 1000000 + "ms");



        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    static  void  secondTaskSolution(StringBuilder inputDataBuilder) {

            float start = System.nanoTime();
            String[] lines = inputDataBuilder.toString().trim().split("\n");
            Map<Integer, Integer> scratchcards  = new HashMap<>();
            for (int i = 0; i < lines.length; i++) {
                scratchcards.put(i, 1);
                String[] parts = lines[i].split("\\|");
                String[] firstParts = parts[0].split(":");
                String id = firstParts[0].trim();
                String card = firstParts[1].trim();
                String[] cardNums = card.split("\\s+");
                Set<Integer> cardSet = new HashSet<>();
                for (String num : cardNums) {
                    cardSet.add(Integer.parseInt(num));
                }

                String[] restNums = parts[1].trim().split("\\s+");
                Set<Integer> restSet = new HashSet<>();
                for (String num : restNums) {
                    restSet.add(Integer.parseInt(num));
                }

                int val = intersectionSize(cardSet, restSet);


                for (int j = 0; j < val; j++) {
                    scratchcards.put(i + 1 + j, scratchcards.getOrDefault(i, 0) + scratchcards.get(i + 1 + j));
                }
            }


            System.out.println("Part Two:");
            System.out.println("Answer: " + scratchcards.get(lines.length));
            float end = System.nanoTime();
            System.out.println("Time: " + (end - start) / 1000000 + "ms");



    }

    private static <T> int intersectionSize(Set<T> set1, Set<T> set2) {
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection.size();
    }
}
