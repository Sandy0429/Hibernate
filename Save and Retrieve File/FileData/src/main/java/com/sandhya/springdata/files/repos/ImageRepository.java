package com.sandhya.springdata.files.repos;

import org.springframework.data.repository.CrudRepository;

import com.sandhya.springdata.files.entities.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
