package com.wangzhen.spbbootstrapinaction.repository;

import com.wangzhen.spbbootstrapinaction.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}

