package org.zerock.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration

@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class NewsControllerTests {
	
	@Setter(onMethod_=@Autowired)
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		
		//this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		
		DefaultMockMvcBuilder a = MockMvcBuilders.webAppContextSetup(ctx);
		
		this.mockMvc = a.build();
		
	}
	
	@Test
	public void testTest() {
		log.info("test.....");
		log.info(ctx);
		log.info(mockMvc);
	}
	
	@Test
	public void testNews() throws Exception{
		ResultActions a = mockMvc.perform(MockMvcRequestBuilders.get("/news/naver"));		
		MvcResult b = a.andReturn();
		
		ModelAndView c = b.getModelAndView();
		
		ModelMap d = c.getModelMap();
		
		log.info(d);
	}


}
