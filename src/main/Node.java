/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Node {
    public String tag;
    public ArrayList<Node> children = new ArrayList<>();
    public String value;
    public int id;
    
    
    public Node(){}
    
    public Node(String tag){
        this.tag = tag;
        this.id = 0;
        this.value = "";
    }

    // Sets
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    public void setChildren(ArrayList children) {
        this.children = children;
    }
    
    public void setChild (Node n){
        children.add(n);
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    // Gets
    public String getTag(){
        return tag;
    }
    
    public ArrayList<Node> getChildren(){
        return children;
    }
    
    public String getValue(){
        return value;
    }
    
    public int getId(){
        return id;
    }
}
