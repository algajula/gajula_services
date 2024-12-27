package com.gajula.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BatchEventtListener {

    private final static Logger admin = LogManager.getLogger(BatchEventtListener.class.getName());

    @Scheduled(cron = "${gajula.event.cron}")
    public void MyBatchExpiredEventCron() throws Exception {
	try {
	    admin.info("MyBatchExpiredEventCron start ");
	    admin.info("MyBatchExpiredEventCron end ");
	} catch (Exception e) {
	    admin.error("Error occured in MyBatchExpiredEventCron " + e.getMessage());
	}
    }

}
