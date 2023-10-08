package com.learning.corner.payments.realtimepaymentstatusmonitoring.repository;

import com.learning.corner.payments.realtimepaymentstatusmonitoring.model.NodeData;
import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PaymentRepository extends MongoRepository<NodeData, String> {

    @Query("{nodeReference:'?0'}")
    Document findByNodeReference(String nodeReference);

    @Query("[\n" +
            "  {\n" +
            "    $match:\n" +
            "      {\n" +
            "        parentNodeReference:\n" +
            "          '?0',\n" +
            "      },\n" +
            "  },\n" +
            "  {\n" +
            "    $graphLookup:\n" +
            "      {\n" +
            "        from: 'payments',\n" +
            "        startWith: '$parentNodeReference',\n" +
            "        connectFromField: 'parentNodeReference',\n" +
            "        connectToField: 'nodeReference',\n" +
            "        maxDepth: 3,\n" +
            "        depthField: 'nodeOrder',\n" +
            "        as: 'paymentHierarchy',\n" +
            "      },\n" +
            "  }\n" +
            "]")
    List<Document> findPaymentTreeByNodeReference(String nodeReference);

    @Query("[\n" +
            "  {\n" +
            "    $graphLookup:\n" +
            "      {\n" +
            "        from: 'payments',\n" +
            "        startWith: '$parentNodeReference',\n" +
            "        connectFromField: 'parentNodeReference',\n" +
            "        connectToField: 'nodeReference',\n" +
            "        maxDepth: 3,\n" +
            "        depthField: 'nodeHierarchy',\n" +
            "        as: 'paymentTree',\n" +
            "      },\n" +
            "  },\n" +
            "]")
    List<NodeData> getAllPaymentTree();
}
