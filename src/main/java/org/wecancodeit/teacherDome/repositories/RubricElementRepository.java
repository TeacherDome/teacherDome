package org.wecancodeit.teacherDome.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.teacherDome.model.RubricElement;

public interface RubricElementRepository extends CrudRepository<RubricElement, Long> {
	Collection<RubricElement> findByGivenAssignmentId(Long givenAssignmentId);
}
