package com.example.notificationservice.repository;

import com.example.notificationservice.model.Declaration;
import com.example.notificationservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeclarationRepository extends JpaRepository<Declaration,Long> {
}
