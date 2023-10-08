package com.learning.corner.payments.realtimepaymentstatusmonitoring;

import com.learning.corner.payments.realtimepaymentstatusmonitoring.model.NodeData;
import com.learning.corner.payments.realtimepaymentstatusmonitoring.model.NodeType;
import com.learning.corner.payments.realtimepaymentstatusmonitoring.repository.PaymentRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableMongoRepositories
public class RealtimePaymentStatusMonitoringApplication implements CommandLineRunner {

	@Autowired
	PaymentRepository paymentRepository;

	public static void main(String[] args) {
		SpringApplication.run(RealtimePaymentStatusMonitoringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bulkInsert();
		//System.out.println(findByNodeReference("d94053c6-c8cd-4da4-87ea-66ff6baf972d"));
		//System.out.println(findPaymentTreeByNodeReference("d94053c6-c8cd-4da4-87ea-66ff6baf972d").get(0).values());
		//System.out.println(getAllPaymentTree());
	}

	private Document findByNodeReference(String nodeReference) {
		return paymentRepository.findByNodeReference(nodeReference);
	}

	private List<Document> findPaymentTreeByNodeReference(String nodeReference) {
		return paymentRepository.findPaymentTreeByNodeReference(nodeReference);
	}

	private List<NodeData> getAllPaymentTree() {
		return paymentRepository.getAllPaymentTree();
	}

	private void bulkInsert() {
		String messageReference = UUID.randomUUID().toString();
		String ptRef = UUID.randomUUID().toString();
		List<NodeData> remittances = new ArrayList<>();
		for (int i=0;i<100;i++) {
			String remittanceReference = UUID.randomUUID().toString();
			System.out.println(NodeType.Remittance+", "+remittanceReference);
			List<NodeData> transations = new ArrayList<>();
			for (int j=0;j<2000;j++) {
				String transactionReference = UUID.randomUUID().toString();
				NodeData transaction = new NodeData(transactionReference, NodeType.Transaction, remittanceReference);
				transations.add(transaction);
			}
			paymentRepository.saveAll(transations);
			remittances.add(new NodeData(remittanceReference, NodeType.Remittance, messageReference));
		}
		paymentRepository.saveAll(remittances);
		paymentRepository.save(new NodeData(messageReference, NodeType.Message, ptRef));
		paymentRepository.save(new NodeData(ptRef, NodeType.PhysicalTransport, null));
		System.out.println(NodeType.Message+", "+messageReference);
		System.out.println(NodeType.PhysicalTransport+", "+ptRef);
	}
}
