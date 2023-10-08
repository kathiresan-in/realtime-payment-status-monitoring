package com.learning.corner.payments.realtimepaymentstatusmonitoring.repository;

import com.learning.corner.payments.realtimepaymentstatusmonitoring.model.NodeData;
import com.learning.corner.payments.realtimepaymentstatusmonitoring.model.NodeType;

import java.util.List;

public class PaymentTreeResult {

    private String nodeReference;
    private NodeType nodeType;
    private String parentNodeReference;
    private List<NodeData> paymentTree;

    public PaymentTreeResult(String nodeReference, NodeType nodeType, String parentNodeReference, List<NodeData> paymentTree) {
        this.nodeReference = nodeReference;
        this.nodeType = nodeType;
        this.parentNodeReference = parentNodeReference;
        this.paymentTree = paymentTree;
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

    public List<NodeData> getPaymentTree() {
        return paymentTree;
    }

    @Override
    public String toString() {
        return "PaymentTreeResult{" +
                "nodeReference='" + nodeReference + '\'' +
                ", nodeType=" + nodeType +
                ", parentNodeReference='" + parentNodeReference + '\'' +
                ", paymentTree=" + paymentTree +
                '}';
    }
}
