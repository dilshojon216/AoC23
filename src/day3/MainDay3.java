package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MainDay3 {
    public static void main(String[] args) {
        try {
            String fileName = "src/day3/input.txt";
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

    static  void firstTaskSolution(StringBuilder inputDataBuilder){
        try {
            float start = System.nanoTime();
            String[] lines = inputDataBuilder.toString().split("\n");
            int R = lines.length;
            int C = lines[0].length();

            int p1 = 0;

            for (int r = 0; r < R; r++) {

                int n = 0;
                boolean hasPart = false;
                for (int c = 0; c <= C; c++) {
                    if (c < C && Character.isDigit(lines[r].charAt(c))) {
                        n = n * 10 + Character.getNumericValue(lines[r].charAt(c));
                        for (int rr = -1; rr <= 1; rr++) {
                            for (int cc = -1; cc <= 1; cc++) {
                                if (0 <= r + rr && r + rr < R && 0 <= c + cc && c + cc < C) {
                                    char ch = lines[r + rr].charAt(c + cc);
                                    if (!Character.isDigit(ch) && ch != '.') {
                                        hasPart = true;
                                    }

                                }
                            }
                        }
                    } else if (n > 0) {
                        if (hasPart) {
                            p1 += n;
                        }
                        n = 0;
                        hasPart = false;

                    }
                }
            }
            System.out.println("Part One:");
            System.out.println("Answer: " + p1);
            float end = System.nanoTime();
            System.out.println("Time: " + (end - start) / 1000000 + "ms");


        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    static  void  secondTaskSolution(StringBuilder inputDataBuilder) {
        try {
            float start = System.nanoTime();
            String[] lines = inputDataBuilder.toString().split("\n");
            int R = lines.length;
            int C = lines[0].length();
            Map<String, HashSet<Integer>> nums = new HashMap<>();
            for (int r = 0; r < R; r++) {
                HashSet<String> gears = new HashSet<>();
                int n = 0;

                for (int c = 0; c <= C; c++) {
                    if (c < C && Character.isDigit(lines[r].charAt(c))) {
                        n = n * 10 + Character.getNumericValue(lines[r].charAt(c));
                        for (int rr = -1; rr <= 1; rr++) {
                            for (int cc = -1; cc <= 1; cc++) {
                                if (0 <= r + rr && r + rr < R && 0 <= c + cc && c + cc < C) {
                                    char ch = lines[r + rr].charAt(c + cc);

                                    if (ch == '*') {
                                        gears.add((r + rr) + "," + (c + cc));
                                    }
                                }
                            }
                        }
                    } else if (n > 0) {
                        for (String gear : gears) {

                            nums.computeIfAbsent(gear, k -> new HashSet<>()).add(n);
                        }


                        n = 0;

                        gears.clear();
                    }
                }
            }


            int p2 = 0;
            for (Map.Entry<String, HashSet<Integer>> entry : nums.entrySet()) {
                if (entry.getValue().size() == 2) {
                    int[] values = entry.getValue().stream().mapToInt(Integer::intValue).toArray();
                    p2 += values[0] * values[1];
                }
            }
            System.out.println("Part Two:");
            System.out.println("Answer: " + p2);
            float end = System.nanoTime();
            System.out.println("Time: " + (end - start) / 1000000 + "ms");


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
