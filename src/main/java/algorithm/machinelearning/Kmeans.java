package algorithm.machinelearning;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Kmeans {
    static int K = 3;

    static class Point {
        public double x;
        public double y;
        public int clusterNum;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public void setCluster(int num) {
            this.clusterNum = num;
        }
    }

    static class Cluster {
        public int num;
        public double x;
        public double y;
        public ArrayList<Point> belongPoints;

        public Cluster(double x, double y) {
            this.x = x;
            this.y = y;
            this.belongPoints = new ArrayList<>();
        }

        public void clean() {
            this.belongPoints = new ArrayList<>();
        }

        public void addPoint(Point p) {
            this.belongPoints.add(p);
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point[] points = new Point[150];
        int i = 0;


        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] nums = line.split(" ");
            Double x = Double.valueOf(nums[0]);
            Double y = 0.0;
            if (nums[1].contains(",")) {
                y = Double.valueOf(nums[1].substring(0, nums[1].length() -1 ));
            } else {
                y = Double.valueOf(nums[1]);
            }
            points[i] = new Point(x, y);
            i++;
        }
        kmeans(points);
    }

    public static Cluster[] kmeans(Point[] points) {
        int len = points.length;
        Random rand = new Random();
        Cluster[] clusters = new Cluster[K];

        //initialize cluster
        for (int i = 0; i < K; i++) {
            int idx = rand.nextInt(len);
            clusters[i] = new Cluster(points[idx].x, points[idx].y);
            clusters[i].setNum(i);
        }

        while (true) {
            for (int j = 0; j < K; j++) {
                clusters[j].clean();
            }

            //assign cluster to all point
            for (Point point : points) {
                double min = 0;
                int k = -1;
                for (int j = 0; j < K; j++) {
                    //distance from j cluster to this point
                    double distance = Math.pow((clusters[j].x - point.x), 2) + Math.pow((clusters[j].y - point.y), 2);
                    if (distance < min) {
                        k = j;
                    }
                }
                clusters[k].addPoint(point);
                point.setCluster(k);
            }

            //re calculate cluster
            boolean changed = false;
            for (Cluster c: clusters) {
                int numOfPoints = c.belongPoints.size();
                double sumX = 0, sumY = 0;
                for (Point p: c.belongPoints) {
                    sumX += p.x;
                    sumY += p.y;
                }

                double newX = sumX / numOfPoints;
                double newY = sumY / numOfPoints;

                if (c.x != newX || c.y != newY) {
                    changed = true;
                    c.x = newX;
                    c.y = newY;
                }
            }

            if (!changed) {
                return clusters;
            }

        }
    }
}
