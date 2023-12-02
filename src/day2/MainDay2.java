package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainDay2 {
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
            BufferedReader br = new BufferedReader(new FileReader("src/day2/input.txt"));

            //Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green

            int t=0;
            String line;
            while ((line = br.readLine()) != null) {
                String gameId = line.split(":")[0];
                String[] games = line.split(": ")[1].split("; ");
               boolean isGameValid = true;
                for (String game : games) {
                    Map<String, Integer> ballsMap = new HashMap<>();
                    ballsMap.put("blue", 0);
                    ballsMap.put("red", 0);
                    ballsMap.put("green", 0);

                    String[] balls = game.split(", ");
                    for (String ball : balls) {
                        String[] ballColor = ball.split(" ");
                        ballsMap.put(ballColor[1], Integer.parseInt(ballColor[0]));
                    }

                    if (ballsMap.get("blue") > 14 || ballsMap.get("red") > 12 || ballsMap.get("green") > 13) {
                        isGameValid = false;
                    }
                }
                if(isGameValid){

                        int id=Integer.parseInt(gameId.split(" ")[1]);
                        t=t+id;


                }
            }


            System.out.println("Part One:");
            System.out.println("Answer: " + t);
            float end = System.nanoTime();
            System.out.println("Time: " + (end - start) / 1000000 + "ms");



        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static  void  secondTaskSolution() throws FileNotFoundException {
        try {
            float start = System.nanoTime();
            BufferedReader br = new BufferedReader(new FileReader("src/day2/input.txt"));

            //Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green

            int t=0;
            String line;
            while ((line = br.readLine()) != null) {
                String gameId = line.split(":")[0];
                String[] games = line.split(": ")[1].split("; ");
                boolean isGameValid = true;
                Map<String, Integer> ballsMap = new HashMap<>();
                ballsMap.put("blue", 0);
                ballsMap.put("red", 0);
                ballsMap.put("green", 0);
                for (String game : games) {


                    String[] balls = game.split(", ");
                    for (String ball : balls) {
                        String[] ballColor = ball.split(" ");
                        ballsMap.put(ballColor[1], Integer.parseInt(ballColor[0])>ballsMap.get(ballColor[1])?Integer.parseInt(ballColor[0]):ballsMap.get(ballColor[1]));
                    }


                }



                    t+=ballsMap.get("blue")*ballsMap.get("red")*ballsMap.get("green");



            }


            System.out.println("Part Two:");
            System.out.println("Answer: " + t);
            float end = System.nanoTime();
            System.out.println("Time: " + (end - start) / 1000000 + "ms");



        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
