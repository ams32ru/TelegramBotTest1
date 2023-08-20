package com.Social.TelegramBotTest1.repository;

import com.Social.TelegramBotTest1.model.Domain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainsRepository extends CrudRepository<Domain, Long> {

}
