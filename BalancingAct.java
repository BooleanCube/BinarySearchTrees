/*
 * BooleanCube Grade 11
 * Doral Academy SENIOR Division
 * 1996-1997 American Computer Science League
 * Contest #4 "ACSL Balancing Act" DATE 11/09/21
 * CLASS NAME: BalancingAct
 * INPUT FILE: TREES.IN
 *
 * On my honor I have neither given nor received help, nor will I give help on this program
*/

import java.io.*;
import java.util.*;

public class BalancingAct {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new FileReader(new File("TREES.IN")));

        for(int y=0; y<5; y++) {
            String[] split = bf.readLine().split(" ", 2);
            int k = Integer.parseInt(split[0]);
            String s = split[1];
        }

    }

}

class BinarySearchTree {
    
    public BSTNode head;

    public BinarySearchTree(BSTNode head) {
        this.head = head;
    }

}

class BSTNode implements Comparable<BSTNode> {
    
    String name;
    public BSTNode left, right;

    public BSTNode(String s) {
        this.name = s;
        this.left = null;
        this.right = null;
    }

    public String toString() {
        return name;
    }

    public int compareTo(BSTNode other) {
        return this.name.compareTo(other.name);
    }

}

