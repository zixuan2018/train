package com.example.train.Repository;

import com.example.train.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name="user")
public interface UserRepository extends CrudRepository<UserEntity,Integer> {
}
