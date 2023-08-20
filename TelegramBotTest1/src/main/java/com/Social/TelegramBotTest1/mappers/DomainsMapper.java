package com.Social.TelegramBotTest1.mappers;

import com.Social.TelegramBotTest1.dto.DomainsDto;
import com.Social.TelegramBotTest1.model.Domains;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DomainsMapper {
    DomainsMapper INSTANCE = Mappers.getMapper(DomainsMapper.class);

    DomainsDto toDto(Domains domains);

    Domains toEntity(List<DomainsDto> dto);
}