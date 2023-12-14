package hu.cubix.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.logistics.config.LogisticsConfig;

@Service
public class DelayService {

	@Autowired
	LogisticsConfig config;

	public DelayService(){

	}

	public long getDecreasingPercent(long minutes){
		if(minutes < config.getDelay().getFirstminlimit()){
			return 0;
		} else if(minutes < config.getDelay().getSecondminlimit()){
			return config.getDecreasePercent().getFirstpercentlimit();
		} else if(minutes < config.getDelay().getThirdminlimit()){
			return config.getDecreasePercent().getSecondpercentlimit();
		} else {
			return config.getDecreasePercent().getThirdpercentlimit();
		}
	}
}
