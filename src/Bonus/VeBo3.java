package Bonus;

import java.util.*;


public class VeBo3 {
    public static class StartUp {
        private int stt;
        private int money;

        public StartUp(int stt, int money) {
            this.stt = stt;
            this.money = money;
        }

        public int getStt() {
            return stt;
        }

        public void setStt(int stt) {
            this.stt = stt;
        }

        public int getMoney() {
            return money;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<StartUp> minHeapStartUp = new PriorityQueue<StartUp>(new Comparator<StartUp>() {
            @Override
            public int compare(StartUp o1, StartUp o2) {
                return o1.getMoney() - o2.getMoney();
            }
        });
        long sum = 0;
        List<Integer> pos = new ArrayList<>();
        int query = sc.nextInt();
        for (int i = 0; i < query - 1; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                int n = sc.nextInt();
                StartUp su = new StartUp(i + 1, n);
                minHeapStartUp.offer(su);
            } else if (op == 2) {
                int v = sc.nextInt();
                while (minHeapStartUp.size() >= v) {
                    if (!minHeapStartUp.isEmpty()) {
                        StartUp su = minHeapStartUp.poll();
                    }
                }
            }
        }

        int op = sc.nextInt();
        int v = sc.nextInt();
        if(minHeapStartUp.size() < v){
            System.out.println(-1);
        }else{
            while (!minHeapStartUp.isEmpty()) {
                StartUp su = minHeapStartUp.poll();
                pos.add(su.getStt());
                sum += su.getMoney();
            }
            System.out.println(sum);
            Collections.sort(pos);
            for (int x : pos) {
                System.out.print(x + " ");
            }
        }


    }
}
