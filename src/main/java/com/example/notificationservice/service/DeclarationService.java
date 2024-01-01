package com.example.notificationservice.service;

import com.example.notificationservice.dto.DeclarationDto;
import com.example.notificationservice.model.Declaration;

public interface DeclarationService {
    Declaration createDeclaration(DeclarationDto declarationDto);

}
