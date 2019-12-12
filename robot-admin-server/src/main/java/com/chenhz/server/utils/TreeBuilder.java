package com.chenhz.server.utils;

import com.chenhz.server.dto.Node;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.iteye.com/blog/ysj5125094-2283159
 */
@Slf4j
public class TreeBuilder {

    @SuppressWarnings("unchecked")
    public static List<Node> buildListToTree(List<Node> dirs){
        List<Node> roots = root(dirs);
        List<Node> notRoots = (List<Node>) CollectionUtils.subtract(dirs, roots);
        for (Node root : roots) {
            List<Node> rootChildren = children(root, notRoots);
            if (CollectionUtils.isEmpty(rootChildren)){
                root.setLeaf(Boolean.TRUE);
            }else {
                root.setLeaf(Boolean.FALSE);
            }
            root.setChildren(rootChildren);
        }
        return roots;
    }

    private static List<Node> root(List<Node> allNodes){
        List<Node> results = new ArrayList<>();
        List<Long> ids = allNodes.stream().map(Node::getId).collect(Collectors.toList());
        List<Node> rootNodes = allNodes.stream().filter(i -> !ids.contains(i.getPId())).collect(Collectors.toList());
        for (Node node:rootNodes) {
            node.setLevel(0);
            results.add(node);
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    private static List<Node> children(Node root, List<Node> allNodes){
        List<Node> children = new ArrayList<>();

        for (Node compareOne : allNodes){
            if (root.getId().equals(compareOne.getPId())){
                compareOne.setLevel(root.getLevel() + 1);
                children.add(compareOne);
            }
        }
        log.info(">>>>> children");
        List<Node> notChildren = (List<Node>) CollectionUtils.subtract(allNodes,children);
        for (Node child: children){
            List<Node> tmpChildren = children(child,notChildren);
            if (CollectionUtils.isEmpty(tmpChildren)){
                child.setLeaf(true);
            }else {
                child.setLeaf(false);
            }
            child.setChildren(tmpChildren);
        }
        return children;
    }

}
