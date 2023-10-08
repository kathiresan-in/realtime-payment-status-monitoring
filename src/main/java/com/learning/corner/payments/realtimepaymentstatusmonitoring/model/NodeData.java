package com.learning.corner.payments.realtimepaymentstatusmonitoring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("payments")
public class NodeData {

    private String nodeReference;
    private NodeType nodeType;
    private String parentNodeReference;

    public NodeData(String nodeReference, NodeType nodeType, String parentNodeReference) {
        this.nodeReference = nodeReference;
        this.nodeType = nodeType;
        this.parentNodeReference = parentNodeReference;
    }

    public String getNodeReference() {
        return nodeReference;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public String getParentNodeReference() {
        return parentNodeReference;
    }

    @Override
    public String toString() {
        return "NodeData{" +
                "nodeReference='" + nodeReference + '\'' +
                ", nodeType=" + nodeType +
                ", parentNodeReference='" + parentNodeReference + '\'' +
                '}';
    }
}
