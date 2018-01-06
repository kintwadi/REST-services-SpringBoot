package api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.model.Member;
import api.respository.Respository;

@Service
public class MemberService {

	@Autowired
	private Respository repository;

	public List<Member> findAllMembers() {

		return (List<Member>) repository.findAll();
	}

	public Member findById(long id) {

		return repository.findOne(id);
	}

	public void saveMember(Member member) {
		member.setId(getLastInsertId());
		repository.save(member);


	}

	public boolean updateMember(Member member) {
		Member aux = repository.findOne(member.getId());
		if(aux != null){

			repository.save(member);
			return true;

		}
		return false;

	}


	public boolean  deleteMemberById(long id) {
		if(id > 0 ){
			repository.delete(id);
			return true;
		}
		return false;

	}

	public void findDeleteMembers() {
		repository.deleteAll();

	}

	public long getLastInsertId(){
		List<Member> list = (List<Member>) repository.findAll();
		return list.size()+1;
	}







}
