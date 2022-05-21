import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "you are sitting in front of a computer learning java"));
        locations.put(1, new Location(1, "you are standing at the end of a road before a small bridge"));
        locations.put(2, new Location(2, "you are standing at the top of a hill"));
        locations.put(3, new Location(3, "you are in the forest"));

        locations.get(1).addExit("w", 2);
        locations.get(1).addExit("e", 3);
        locations.get(1).addExit("Q", 0);

        locations.get(2).addExit("N", 5);
        locations.get(2).addExit("Q", 0);

        locations.get(3).addExit("w", 1);
        locations.get(3).addExit("Q", 0);


        Map<String,String> vocabulary = new HashMap<String, String>();
        vocabulary.put("Quit","Q");
        vocabulary.put("North","N");
        vocabulary.put("South","s");
        vocabulary.put("west","w");
        vocabulary.put("east","E");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits are");
            for (String exit : exits.keySet()) {
                System.out.println(exit + ",");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if(direction.length()>1){
                String[] words = direction.split("");
                for(String word : words){
                    if(vocabulary.containsKey(word)){
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("you cannot go in that direction");
            }
        }
    }
}


