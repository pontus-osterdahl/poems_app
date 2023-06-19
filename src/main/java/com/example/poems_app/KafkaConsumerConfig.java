package com.example.poems_app;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
	
    // @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress = "127.0.0.1:9092";

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
          ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, 
          bootstrapAddress);
       // props.put(
      //    ConsumerConfig.GROUP_ID_CONFIG, 
      //    groupId);
        props.put(
          ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, 
          StringDeserializer.class);
        props.put(
          ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, 
          StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }
    
    private static final String TEST_GROUP = "test-group";
    
    @Bean
    public ConsumerFactory<String, XmlPoemCreationRequest> xmlPoemCreationRequestConsumerFactory() {
    	 Map<String, Object> props = new HashMap<>();
         props.put(
           ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, 
           bootstrapAddress);
           props.put(
             ConsumerConfig.GROUP_ID_CONFIG, 
             TEST_GROUP);
         props.put(
           ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, 
           StringDeserializer.class);
         props.put(
           ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, 
           StringDeserializer.class);
         return new DefaultKafkaConsumerFactory<>(props,  new StringDeserializer(), 
        	      new JsonDeserializer<>(XmlPoemCreationRequest.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> 
      kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
          new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, XmlPoemCreationRequest> 
      xmlPoemCreationRequestKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, XmlPoemCreationRequest> factory =
          new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(xmlPoemCreationRequestConsumerFactory());
        return factory;
    }
}
