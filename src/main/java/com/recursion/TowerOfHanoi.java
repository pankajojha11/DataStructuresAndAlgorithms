package com.recursion;

public class TowerOfHanoi {

    static void towerOfHanoi(int n, int s, int d, int h) {
        // base condition
        if (n == 0) {
            System.out.println("Moving plate " + n + " from s to d");
            return;
        }
        towerOfHanoi(n - 1, s, h, d);
        System.out.println("Moving plate " + n + " from s to d");
        towerOfHanoi(n - 1, h, d, n);
        return;

    }


    public static void main(String args[]) {
        int n = 4; // Number of disks
        towerOfHanoi(n, 's', 'd', 'h'); // A, B and C are names of rods
    }
}
