package api.controller;

import java.util.List;







import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import api.model.Member;
import api.service.MemberService;
import api.util.Validation;

@RestController
@RequestMapping("/api")
public class Controller {
	public static final Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	MemberService memberService; //Service which will do all data retrieval/manipulation work
	@Autowired
	private Validation validation;


	//-------------------unknownResource--------------------------------------------------------

	@RequestMapping(value="/**",method = RequestMethod.GET)
	public ResponseEntity<String> unmappedRequest(){

		return new ResponseEntity<String>("There is no resource mapping the provided url", HttpStatus.BAD_REQUEST);
	}


	// -------------------Retrieve All Members---------------------------------------------

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> listAllMembers() {

		List<Member> members = memberService.findAllMembers();
		if (members.isEmpty()) {
			return new ResponseEntity<List<Member>>(members,HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
	}

	// -------------------Retrieve Single Member------------------------------------------

	@RequestMapping(value = "/getMember/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getMember(@PathVariable("id") long id) {

		logger.info("Fetching Member with id {}", id);

		Member member = memberService.findById(id);
		if (member == null) {
			logger.error("member with id {} not found.", id);
			return new ResponseEntity<Object>("member with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(member, HttpStatus.OK);
	}

	// -------------------Create a Member-------------------------------------------

	@RequestMapping(value = "/createMember", method = RequestMethod.POST)
	public ResponseEntity<Object> createMember(@Validated @RequestBody Member member, BindingResult bindingResult,UriComponentsBuilder ucBuilder) {

		validation.validate(member, bindingResult);

		memberService.saveMember(member);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/member/{id}").buildAndExpand(member.getId()).toUri());
		return new ResponseEntity<Object>(headers, HttpStatus.CREATED);

	}

	// ------------------- Update a Member ------------------------------------------------

	@RequestMapping(value = "/updateMember/{id}", method = RequestMethod.PUT)
	
	public ResponseEntity<Object> updateMember(@Validated @PathVariable("id") long id, @RequestBody Member member,BindingResult bindingResult){

		validation.validate(member, bindingResult);
		member.setId(id);
		if(memberService.updateMember(member)){
		return new ResponseEntity<Object>(member, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("", HttpStatus.BAD_REQUEST);
	}

	// ------------------- Delete a Member-----------------------------------------

	@RequestMapping(value = "/deleteMember/{id}", method = RequestMethod.DELETE)
	
	public ResponseEntity<Object> deleteMember(@Validated @PathVariable("id") long id) {
		
		
		if(memberService.deleteMemberById(id)){
			
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	// ------------------- Delete All Members-----------------------------

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public ResponseEntity<Member> deleteAllMember() {

		logger.info("Deleting All Members");

		memberService.findDeleteMembers();
		return new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
	}



}
