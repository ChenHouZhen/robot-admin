package com.chenhz.server.utils;

import com.chenhz.server.dto.Node;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.iteye.com/blog/ysj5125094-2283159
 */
public class TreeBuilder {

    @SuppressWarnings("unchecked")
    public static List<Node> buildListToTree(List<Node> dirs){
        List<Node> roots = findRoots(dirs);
        List<Node> notRoots = (List<Node>) CollectionUtils.subtract(dirs, roots);
        for (Node root : roots) {
            List<Node> rootChildren = findChildren(root, notRoots);
            if (CollectionUtils.isEmpty(rootChildren)){
                root.setLeaf(Boolean.TRUE);
            }else {
                root.setLeaf(Boolean.FALSE);
            }
            root.setChildren(rootChildren);
        }
        return roots;
    }

    private static List<Node> findRoots(List<Node> allNodes){
        List<Node> results = new ArrayList<>();
        for (Node node : allNodes){
            boolean isRoot = true;
            for (Node compareOne: allNodes){
                if (compareOne.getId().equals(node.getPId())){
                    isRoot = false;
                    break;
                }
            }
            if (isRoot){
                node.setLevel(0);
                results.add(node);
            }
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    private static List<Node> findChildren(Node root,List<Node> allNodes){
        List<Node> children = new ArrayList<>();

        for (Node compareOne : allNodes){
            if (root.getId().equals(compareOne.getPId())){
//                compareOne.setPNode(root);
                compareOne.setLevel(root.getLevel() + 1);
                children.add(compareOne);
            }
        }

        List<Node> notChildren = (List<Node>) CollectionUtils.subtract(allNodes,children);
        for (Node child: children){
            List<Node> tmpChildren = findChildren(child,notChildren);
            if (tmpChildren == null || tmpChildren.size() < 1){
                child.setLeaf(true);
            }else {
                child.setLeaf(false);
            }
            child.setChildren(tmpChildren);
        }
        return children;
    }

}
