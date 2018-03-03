package com.devsafrica.controller;

import com.devsafrica.assemblers.UserAssembler;
import com.devsafrica.domain.User;
import com.devsafrica.repo.UserRepository;
import com.devsafrica.service.UserService;
import com.devsafrica.vo.CreateUserVO;
import com.devsafrica.vo.UpdateUserVO;
import com.devsafrica.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserVO getUser(@PathVariable("id") Long id){
        return userAssembler.toUserVO(userService.getUserById(id));
    }


    @RequestMapping (value = "/test", method= RequestMethod.GET)
    public String test(){
        return "It is working";
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserVO createUser(@RequestBody CreateUserVO userVO){
        //Convert to user
        User user = userAssembler.toUser(userVO);
        //Save user
        User savedUser = userService.createUser(user);
        //Convert to userVO
        return userAssembler.toUserVO(savedUser);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UserVO updateUser(@RequestBody UpdateUserVO updateUserVO){
        //Convert to user
        User user = userAssembler.toUser(updateUserVO);
        //Update User
        User updatedUser = userService.updateUser(user);
        //convert to userVO
        return userAssembler.toUserVO(user);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

//    private UserRepository userRepository;
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public User getUser(@PathVariable("id") Long id)  {
//        return userRepository.findOne(id);
//    }

}
