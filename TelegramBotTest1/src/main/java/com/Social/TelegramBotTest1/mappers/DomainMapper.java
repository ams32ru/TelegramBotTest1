package com.Social.TelegramBotTest1.mappers;

import com.Social.TelegramBotTest1.dto.DomainDto;
import com.Social.TelegramBotTest1.model.Domain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DomainMapper {
    DomainMapper INSTANCE = Mappers.getMapper(DomainMapper.class);

    DomainDto toDto(Domain domains);

    Domain toEntity(List<DomainDto> dto);
}
