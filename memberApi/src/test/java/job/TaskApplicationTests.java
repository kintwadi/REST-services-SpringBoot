package job;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import api.service.MemberService;
import api.util.Converter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTests extends Converter{

	static final String BASE_URL = "http://localhost:8080/task/";

	
	private MockMvc mockMvc;

	
	@Autowired
	private MemberService service;

	//@InjectMocks
	//private Controller controller;
	
	

	@Before
	public void setUp()throws Exception{
		//mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
	}
	
	/*
	// --------------------------------TEST MORE -----------------------------------------------------

	// 200 OK
	@Test
	public void getMemberById() throws Exception {

		String uri = "http://localhost:8080/task/getMember/{id}";
		Long id = new Long(1);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri, id)
				.accept(MediaType.APPLICATION_JSON)).andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		System.out.println("content "+content.toString());
		Assert.assertEquals("failure - expected HTTP status 200", 404, status);
		//Assert.assertTrue("failure - expected HTTP response body to have a value",content.trim().length() > 0);

	}


	// testing 404 Not Found
	@Test
	public void testGetMemberNotFound() throws Exception {

		String uri = "http://localhost:8080/task/getMember/{id}";
		Long id = Long.MAX_VALUE;

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri, id)
				.accept(MediaType.APPLICATION_JSON)).andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();


		System.out.println("content "+ content.toString());

		Assert.assertEquals("failure - expected HTTP status 404", 404, status);
		// Assert.assertTrue("failure - expected HTTP response body to be empty",
		//content.trim().length() == 0);

	}

	// create a Member
	@Test
	public void createMember() throws Exception {
		Member member;
		String uri = "http://localhost:8080/task/createMember";
		member = new Member();
		member.setId(2);
		member.setFirstName("Pedro");
		member.setLastName("Marta");
		member.setPostalCode("14444");
		member.setDateOfBirth(new Date());
		
		String inputJson = mapToJson(member);
		
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post(uri)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON).content(inputJson))
						.andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		Assert.assertEquals("failure - expected HTTP status 201", 201, status);
		Assert.assertTrue(
				"failure - expected HTTP response body to have a value",
				content.trim().length() > 0);
		

		member = mapFromJson(content, Member.class);

		Assert.assertNotNull("failure - expected member not null",
				member);
		Assert.assertNotNull("failure - expected member.id not null",
				member.getId());
		Assert.assertEquals("failure - expected member.firstName match", "Jonas",
				member.getFirstName());

	}

	@Test
	public void updateMember() throws Exception {

		Member member;
		String uri = "/api/greetings/{id}";
		
		member = service.findById(1);
		member.setFirstName("carlos");// update name
		
		String inputJson = mapToJson(member);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.put(uri, member.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON).content(inputJson))
						.andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		Assert.assertEquals("failure - expected HTTP status 200", 200, status);
		Assert.assertTrue(
				"failure - expected HTTP response body to have a value",
				content.trim().length() > 0);

		Member updatedMember = mapFromJson(content, Member.class);

		Assert.assertNotNull("failure - expected member not null",
				updatedMember);
		Assert.assertEquals("failure - expected member.id unchanged",
				member.getId(), updatedMember.getId());
		Assert.assertEquals("failure - expected updated member firstName match",
				member.getFirstName(), updatedMember.getFirstName());

	}



	// detele member
	@Test
	public void deleteMember() throws Exception {


		Member member;
		
		String uri = "http://localhost:8080/task/deleteMember/{id}";
		Long id = new Long(1);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete(uri, id)
				.contentType(MediaType.APPLICATION_JSON)).andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		Assert.assertEquals("failure - expected HTTP status 204", 204, status);
		Assert.assertTrue("failure - expected HTTP response body to be empty",
				content.trim().length() == 0);

		member = service.findById(id);

		Assert.assertNull("failure - expected member to be null",member);

	}

*/
	
	@Test
	public void testLoad(){
		
	}


}
