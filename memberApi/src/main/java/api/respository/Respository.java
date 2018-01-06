package api.respository;

import org.springframework.data.repository.CrudRepository;

import api.model.Member;

public interface Respository  extends CrudRepository<Member, Long>{

}
