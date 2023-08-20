package com.Social.TelegramBotTest1.repository;

import com.Social.TelegramBotTest1.dto.DomainsDto;
import com.Social.TelegramBotTest1.model.Domains;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomainsRepository extends CrudRepository<Domains, Long> {
    void save(List<DomainsDto> domainsDtos);
}
