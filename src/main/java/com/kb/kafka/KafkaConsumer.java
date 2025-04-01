package com.kb.kafka;

import com.kb.alarm.dto.AlarmEvent;
import com.kb.alarm.service.AlarmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {
    private final AlarmService alarmService;

    public KafkaConsumer(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.notification}", groupId = "test01")
    public void listen(AlarmEvent event, Acknowledgment ack) {
        try {
            log.info("Received event: {}", event);
            alarmService.sendAlarm(event.getStdId(), event.getAlarmArgs(), event.getProductId());
            ack.acknowledge();
        } catch (Exception e) {
            log.error("Error processing Kafka event: {}", e.getMessage());
            // 메시지를 커밋하지 않고 재시도 가능
        }
    }
}
