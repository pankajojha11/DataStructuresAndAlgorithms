package com.tree;

import java.util.ArrayList;

public class TreeNodeGenericNary {
    int data;
    ArrayList<TreeNodeGenericNary> children;

    public TreeNodeGenericNary(int data) {
        this.data = data;
        this.children = new ArrayList<TreeNodeGenericNary>();
    }
}
