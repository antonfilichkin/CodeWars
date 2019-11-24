package TheLift;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dinglemouse {
    public static int[] theLift(final int[][] queues, final int capacity) {
        int currentFloor = 0;
        List<Integer> stops = new ArrayList<>();

        //start point
        stops.add(0);

        while (true) {
            //get initial max floor
            int maxFloorQueue = -1;
            for (int i = queues.length - 1; i >= 0; i--) {
                if (queues[i].length > 0) {
                    maxFloorQueue = i;
                    break;
                }
            }

            //get initial min floor
            int minFloorQueue = -1;
            for (int i = 0; i < queues.length; i++) {
                if (queues[i].length > 0) {
                    minFloorQueue = i;
                    break;
                }
            }

            //return to ground floor and finish
            if (minFloorQueue < 0 && maxFloorQueue < 0) {
                if (stops.get(stops.size()-1) != 0) {
                    stops.add(0);
                }
                return stops.stream().mapToInt(i -> i).toArray();
            }

            List<Integer> peopleInLift = new ArrayList<>();

            //go up
            while (currentFloor <= maxFloorQueue) {
                boolean buttonPressed = false;

                //get off
                if (peopleInLift.contains(currentFloor)) {
                    int floor = currentFloor;
                    peopleInLift.removeIf(person -> person == floor);
                    buttonPressed = true;
                }

                //get on
                int[] queue = queues[currentFloor];
                if (queue.length > 0) {
                    List<Integer> left = new ArrayList<>();
                    for (int person : queue) {
                        if (person > currentFloor) {
                            buttonPressed = true;
                            if (peopleInLift.size() < capacity) {
                                peopleInLift.add(person);
                                maxFloorQueue = Math.max(person, maxFloorQueue);
                            } else {
                                left.add(person);
                            }
                        } else {
                            left.add(person);
                        }
                    }
                    queues[currentFloor] = left.stream().mapToInt(i -> i).toArray();
                }

                //lift stopped
                if (buttonPressed && stops.get(stops.size()-1) != currentFloor) {
                    stops.add(currentFloor);
                }
                currentFloor += 1;
            }

            //reset counter
            currentFloor -= 1;

            //go down
            while (currentFloor >= minFloorQueue) {
                boolean buttonPressed = false;

                //get off
                if (peopleInLift.contains(currentFloor)) {
                    int floor = currentFloor;
                    peopleInLift.removeIf(person -> person == floor);
                    buttonPressed = true;
                }

                //get on
                int[] queue = queues[currentFloor];
                if (queue.length > 0) {
                    List<Integer> left = new ArrayList<>();
                    for (int person : queue) {
                        if (person < currentFloor) {
                            buttonPressed = true;
                            if (peopleInLift.size() < capacity) {
                                peopleInLift.add(person);
                                minFloorQueue = Math.min(person, minFloorQueue);
                            } else {
                                left.add(person);
                            }
                        } else {
                            left.add(person);
                        }
                    }
                    queues[currentFloor] = left.stream().mapToInt(i -> i).toArray();
                }

                //lift stopped
                if (buttonPressed && stops.get(stops.size()-1) != currentFloor) {
                    stops.add(currentFloor);
                }
                currentFloor -= 1;
            }

            //reset counter
            currentFloor += 1;
        }
    }

    public static void main(String[] args) {
        final int[][] queues = {
                new int[]{6,3}, // G
                new int[]{0}, // 1
                new int[0], // 2
                new int[0], // 3
                new int[]{2}, // 4
                new int[]{3}, // 5
                new int[0], // 6
        };

        System.out.println(Arrays.toString(Dinglemouse.theLift(queues, 1)));
        //{0,5,4,3,2,1,0}
    }
}