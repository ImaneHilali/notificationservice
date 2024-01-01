package com.example.notificationservice.serviceImpl;

import com.example.notificationservice.dto.DeclarationDto;
import com.example.notificationservice.dto.NotificationEvent;
import com.example.notificationservice.model.Declaration;
import com.example.notificationservice.service.DeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeclarationServiceImpl implements DeclarationService {

    @Value("${existing.microservice.url}")
    private String existingMicroserviceUrl;

    private final RestTemplate restTemplate;

    private final KafkaTemplate<String, NotificationEvent> kafkaTemplate;

    @Autowired
    public DeclarationServiceImpl(RestTemplate restTemplate, KafkaTemplate<String, NotificationEvent> kafkaTemplate) {
         this.restTemplate = restTemplate;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Declaration createDeclaration(DeclarationDto declarationDto) {
        String createDeclarationUrl = existingMicroserviceUrl + "/declaration/";
        ResponseEntity<Declaration> responseEntity = restTemplate.postForEntity(createDeclarationUrl, declarationDto, Declaration.class);

        NotificationEvent notificationEvent = new NotificationEvent();
        notificationEvent.setMessage("New declaration created: " + responseEntity.getBody().getId());
        kafkaTemplate.send("disaster-declaration-topic", notificationEvent);

        return responseEntity.getBody();
    }

}

