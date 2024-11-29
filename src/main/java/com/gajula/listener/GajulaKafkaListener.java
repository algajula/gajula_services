package com.gajula.listener;

import com.gajula.dto.Address_Info;
import com.gajula.dto.User_Info;
import com.gajula.model.ResponseBean;
import com.gajula.service.TrainService;
import com.gajula.service.UserService;
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

	private final static Logger admin = LogManager.getLogger("admin");

	@Value("train.kafka.topics.USERINFO_TOPIC")
	private String userTopic;
	@Value	("train.kafka.topics.USERINFO_TOPIC_ERROR")
	private String userErrTopic;
	@Value	("train.kafka.topics.ADDRESS_TOPIC")
	private String addressTopic;
	@Value	("train.kafka.topics.ADDRESS_TOPIC_ERROR")
	private String addressErrorTopic;

    @Autowired
    TrainService trainService;

	@Autowired
	UserService userService;

	@Autowired
	KafkaTemplate<String , String> kafkaTemplate;

    @KafkaListener(topics = "${train.kafka.topics.USERINFO_TOPIC}", containerFactory = "userFactory")
    public void processUSERINFO(String payload, Acknowledgment ack) throws Exception {
		admin.info(String.format("$$$$ =>USERINFO Consumed message: " + payload));
		try{
			admin.info("process USERINFO start");
			User_Info userinfo = APIConstants.convertrequestToUserDto(payload);
			ResponseBean response = new ResponseBean();
			admin.info("UserID=======" + userinfo.getUserid());
			boolean updtedFlag = userService.saveUserInfo(userinfo);
			if (updtedFlag) {
				response.setStatusCode(APIConstants.STATUS_SUCCESS_CODE);
				response.setStatusDescription(APIConstants.STATUS_SUCCESS_DESC);
				response.setResult("User saved successfully! " + updtedFlag);
			} else {
				response.setStatusCode(APIConstants.DATA_ERR_CODE);
				response.setStatusDescription(APIConstants.DATA_ERR_DESC);
				response.setResult("error while save user data! " + updtedFlag);
			}
			ack.acknowledge();
			admin.info("process USERINFO end");
		}catch (Exception e){
			admin.error("process USERINFO Error "+e.getMessage());
			kafkaTemplate.send(userErrTopic, "USERINFO_TOPIC_ERROR",payload);
		}
    }

	@KafkaListener(topics = "${train.kafka.topics.ADDRESS_TOPIC}", containerFactory = "addressFactory")
	public void processADDRESS(String payload, Acknowledgment ack) throws Exception {
		admin.info(String.format("$$$$ =>ADDRESS Consumed message: " + payload));
		try{
			admin.info("process ADDRESS start");
			Address_Info addressinfo = APIConstants.convertrequestToAddressinfo(payload);
			ResponseBean response = new ResponseBean();
			admin.info("UserID=======" + addressinfo.getUserid());
			boolean updtedFlag = userService.saveAddressInfo(addressinfo);
			if (updtedFlag) {
				response.setStatusCode(APIConstants.STATUS_SUCCESS_CODE);
				response.setStatusDescription(APIConstants.STATUS_SUCCESS_DESC);
				response.setResult("User saved successfully! " + updtedFlag);
			} else {
				response.setStatusCode(APIConstants.DATA_ERR_CODE);
				response.setStatusDescription(APIConstants.DATA_ERR_DESC);
				response.setResult("error while save user data! " + updtedFlag);
			}
			ack.acknowledge();
			admin.info("process ADDRESS end");
		}catch (Exception e){
			admin.error("process ADDRESS Error "+e.getMessage());
			kafkaTemplate.send(addressErrorTopic, "ADDRESS_TOPIC_ERROR",payload);
		}
	}
}
