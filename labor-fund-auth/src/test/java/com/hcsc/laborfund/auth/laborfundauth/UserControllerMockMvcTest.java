package com.hcsc.laborfund.auth.laborfundauth;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.hcsc.laborfund.auth.laborfundauth.controller.UserController;
import com.hcsc.laborfund.auth.laborfundauth.model.User;
import com.hcsc.laborfund.auth.laborfundauth.repository.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerMockMvcTest {
	
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

	
    @Test
    public void testRetrieveUser() throws Exception {
    	
		User mockUser = new User(200,"Johnny");
		Optional<User> optUser = Optional.of(mockUser);

	    when(userRepository.findById(anyInt())).thenReturn(optUser);	   
    		
        MvcResult mvcResult = mockMvc.perform(get("/users/200"))
                .andExpect( status().isOk())
                .andReturn();
        
        String returnedJson = mvcResult.getResponse().getContentAsString();

        assertTrue(returnedJson.contains("Johnny"));
         
        String expected = "{id:200,name:Johnny}";
        
        // The false means strict is off since we are not checking for every field
		JSONAssert.assertEquals(expected, mvcResult.getResponse()	.getContentAsString(), false);
		

    }
    
}
