package com.chenhz.server.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = {"pNode"})
@Data
public class Node implements Serializable {

    public Node(){
        super();
        this.children = new ArrayList<>();
    }

    private Long id;

    private Long pId;

//    private Node pNode;

    private String name;

    private Integer level;

    private boolean isLeaf;

    private List<Node> children;

    public void add(Node child){
        children.add(child);
    }
}
