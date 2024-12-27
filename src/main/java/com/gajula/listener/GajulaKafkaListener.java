package com.gajula.listener;

import com.gajula.dto.BookDto;
import com.gajula.dto.CustomerDto;
import com.gajula.model.ResponseBean;
import com.gajula.service.BookService;
import com.gajula.service.CustomerService;
import com.gajula.util.APIConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class GajulaKafkaListener {

	private final static Logger admin = LogManager.getLogger(GajulaKafkaListener.class.getName());

	@Value("train.kafka.topics.CUSTOMER_TOPIC")
	private String customerTopic;
	@Value	("train.kafka.topics.CUSTOMER_TOPIC_ERROR")
	private String customerErrorTopic;
	@Value	("train.kafka.topics.BOOK_TOPIC")
	private String bookTopic;
	@Value	("train.kafka.topics.BOOK_TOPIC_ERROR")
	private String bookErrorTopic;

    @Autowired
	CustomerService customerService;

	@Autowired
	BookService bookService;

	@Autowired
	KafkaTemplate<String , String> kafkaTemplate;

    @KafkaListener(topics = "${train.kafka.topics.CUSTOMER_TOPIC}", containerFactory = "customerFactory")
    public void processCUSTOMER(String payload, Acknowledgment ack) throws Exception {
		admin.info(String.format("$$$$ =>CUSTOMER Consumed message: " + payload));
		try{
			admin.info("process CUSTOMER start");
			CustomerDto customer = APIConstants.getObjectMapper().readValue(payload, CustomerDto.class);
			admin.info("CustomeId=======" + customer.getCustNumber());
			boolean updtedFlag = customerService.saveCustomerDetails(customer);
			admin.info("Customer addedd successfully! "+updtedFlag);
			ack.acknowledge();
			admin.info("process CUSTOMER end");
		}catch (Exception e){
			admin.error("process CUSTOMER Error "+e.getMessage());
			kafkaTemplate.send(customerErrorTopic, "CUSTOMER_TOPIC_ERROR",payload);
		}
    }

	@KafkaListener(topics = "${train.kafka.topics.BOOK_TOPIC}", containerFactory = "bookFactory")
	public void processBOOK(String payload, Acknowledgment ack) throws Exception {
		admin.info(String.format("$$$$ =>BOOK Consumed message: " + payload));
		try{
			admin.info("process BOOK start");
			BookDto book = APIConstants.getObjectMapper().readValue(payload,BookDto.class);
			admin.info("BookID=======" + book.getBook_id());
			ResponseBean response = bookService.addNewBook(book);
			admin.info("Book added successfully! ===="+response);
			ack.acknowledge();
			admin.info("process BOOK end");
		}catch (Exception e){
			admin.error("process BOOK Error "+e.getMessage());
			kafkaTemplate.send(bookErrorTopic, "BOOK_TOPIC_ERROR",payload);
		}
	}
}
