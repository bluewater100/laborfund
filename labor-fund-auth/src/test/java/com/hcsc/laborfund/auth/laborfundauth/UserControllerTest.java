package com.hcsc.laborfund.auth.laborfundauth;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcsc.laborfund.auth.laborfundauth.controller.UserController;
import com.hcsc.laborfund.auth.laborfundauth.model.User;
import com.hcsc.laborfund.auth.laborfundauth.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	@Mock
	private UserRepository userRepository;

	
    @InjectMocks
    private UserController userController;

	
    @Test
    public void testRetrieveUser() throws Exception {
    	   
    		User mockUser = new User(200,"Johnny");
    		Optional<User> optUser = Optional.of(mockUser);

        when(userRepository.findById(anyInt())).thenReturn(optUser);
        
        Optional<User> returnedUser = userRepository.findById(200);
        
        assertEquals("Johnny", returnedUser.get().getName());
        verify(userRepository, times(1)).findById(anyInt());
    }
    
}
