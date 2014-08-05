package repository;

import model.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ольга on 04.08.2014.
 */
public interface MessageRepository  extends CrudRepository<Message, Long> {

    @Query("select m from Message m order by date desc")
    Iterable<Message> findAllOrderBy();

}
