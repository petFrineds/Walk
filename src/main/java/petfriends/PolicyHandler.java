package petfriends;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import petfriends.config.KafkaProcessor;
import petfriends.walk.repository.WalkRepository;

@Service
public class PolicyHandler{
	
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }
    
    @Autowired
    WalkRepository walkRepository;

    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){
    	
    	
    }

}
