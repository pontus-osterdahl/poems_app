package com.example.poems_app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.poems_app.xml.XmlPoem;

public interface XmlPoemRepository extends CrudRepository<XmlPoem, Integer> {
	Optional<XmlPoem> findByContentItems_id(int id);
}
