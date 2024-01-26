package com.dudewithnuke.productingredients.domain;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
public abstract class AbstractTreeDataStruct {
    @Getter(AccessLevel.NONE)
    private int depth;

    private final String name;
    private AbstractTreeDataStruct parent;
    private final Set<AbstractTreeDataStruct> childrenSet;

    protected AbstractTreeDataStruct(String name) {
        this.depth = 1;
        this.name = name;
        this.childrenSet = new LinkedHashSet<>();
    }

    protected void add(AbstractTreeDataStruct childNode) {
        this.childrenSet.add(childNode);
        childNode.setParent(this);
        childNode.depth += this.depth;
    }

    protected boolean hasParent() {
        return parent != null;
    }

    private void setParent(AbstractTreeDataStruct parentNode) {
        this.parent = parentNode;
    }

    public void printAll() {
        AbstractTreeDataStruct current = this;
        while (current.hasParent()) {
            current = current.parent;
        }

        this.printCurrent(current);
    }

    public void printCurrent(AbstractTreeDataStruct current) {
        String indent = new String(new char[current.depth]).replace("\0", "-");

        System.out.println(indent + current.name);
        current.childrenSet.forEach(this::printCurrent);
    }
}
