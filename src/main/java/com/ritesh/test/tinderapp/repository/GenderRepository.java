package com.ritesh.test.tinderapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ritesh.test.tinderapp.entity.Gender;


@Repository
public interface GenderRepository extends CrudRepository<Gender, Integer>{

}
