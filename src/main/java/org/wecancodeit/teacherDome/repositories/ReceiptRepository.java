package org.wecancodeit.teacherDome.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.teacherDome.model.Receipt;

public interface ReceiptRepository extends CrudRepository<Receipt, Long> {

}
