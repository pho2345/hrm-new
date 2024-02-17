package sgu.hrm.module_kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

//@Component
@Configuration
public class KafkaTopicSendMail {
    private final String bootstrapServers = "127.0.0.1:9092";
    private final Logger log = LoggerFactory.getLogger(KafkaTopicSendMail.class);
    public static Properties properties = new Properties();

    public KafkaTopicSendMail() {
        // create Producer properties
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    }

}
