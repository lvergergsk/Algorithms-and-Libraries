package leetcode.task_scheduler_0621;

import java.util.*;
//import java.util.logging.Logger;

class Solution {

//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public int leastInterval(char[] tasks, int n) {
        Hashtable<Character, Integer> workloadRecorder = new Hashtable<>();
        for (char c : tasks) {
            workloadRecorder.merge(c, 1, (a, b) -> a + b);
        }

        ArrayList<Integer> workload = new ArrayList<>();
        for (Character c : workloadRecorder.keySet()) {
            workload.add(workloadRecorder.get(c));
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(workload.size(), Collections.reverseOrder());
        queue.addAll(workload);
//        LOGGER.info(queue.toString());

        List<Integer> cooldown = new ArrayList<>();

        int res = 0;
        int clock = 0;
        while (!(queue.isEmpty() && cooldown.isEmpty())) {
            Integer task = queue.poll();
            if (task != null && task != 1) cooldown.add(task - 1);

            res++;
            clock++;


            if (clock > n) {
                clock = 0;
                queue.addAll(cooldown);
                cooldown = new ArrayList<>();
            }
//            LOGGER.info("queue: " + queue + ", cooldown: " + cooldown);
        }

        return res;
    }
}
