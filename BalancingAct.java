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
        
        BufferedReader bf = new BufferedReader(new FileReader(new File("src/TREES.IN")));

        for(int y=0; y<5; y++) {
            String[] split = bf.readLine().split(" ", 2);
            int k = Integer.parseInt(split[0]);
            String s = split[1];
            ArrayList<BST> trees = new ArrayList<>();
            for(int i=0; i<k; i++) {
            	Node head = new Node(s.substring(i,i+1));
            	trees.add(new BST(head));
            }
            for(int idx=k; idx<s.length(); idx++) {
            	Node node = new Node(s.substring(idx,idx+1));
            	int minDepth = Integer.MAX_VALUE;
                BST treeMinDepth = null;
                for(BST tree : trees) {
                	int depth = tree.getDepth(tree, node);
                	if(minDepth > depth) {
                		minDepth = depth;
                		treeMinDepth = tree;
                	}
                }
                treeMinDepth.addNode(node);
            }
            System.out.println(trees.get(0).preOrder());
        }

    }

}

class BST {
    
    public Node head;

    public BST(Node head) {
        this.head = head;
    }
    
    public void addNode(Node node) {
    	Node current = head;
    	int depth = 1;
    	while(true) {
    		if(current.compareTo(node) == 1) {
    			if(current.left == null) {
    				current.left = node;
    				break;
    			}
    			else {
    				++depth;
    				current = current.left;
    			}
    		}
    		if(current.compareTo(node) < 1) {
    			if(current.right == null) { 
    				current.right = node;
    				break;
    			}
    			else {
    				++depth;
    				current = current.right;
    			}
    		}
    	}
    }
    
    public int getDepth(BST tree, Node node) {
    	Node current = tree.head;
    	int depth = 1;
    	while(true) {
    		if(current.compareTo(node) == 1) {
    			if(current.left == null) return depth;
    			else {
    				++depth;
    				current = current.left;
    			}
    		}
    		if(current.compareTo(node) < 1) {
    			if(current.right == null) return depth;
    			else {
    				++depth;
    				current = current.right;
    			}
    		}
    	}
    }
    
    public String preOrder() {
    	StringBuilder sb = new StringBuilder();
    	ArrayDeque<Node> q = new ArrayDeque<>();
    	q.add(head);
    	while(!q.isEmpty()) {
    		Node current = q.removeFirst();
    		sb.append(current.name).append(" ");
    		if(current.left != null) {
    			q.addFirst(current);
    			q.addFirst(current.left);
    		} else if(current.right != null) {
    			q.addFirst(current.right);
    		}
    	}
    	return sb.toString().trim();
    }

}

class Node implements Comparable<Node> {
    
    String name;
    public Node left, right;

    public Node(String s) {
        this.name = s;
        this.left = null;
        this.right = null;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
    }

}
