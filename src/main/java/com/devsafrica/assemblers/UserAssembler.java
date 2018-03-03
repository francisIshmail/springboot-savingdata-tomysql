package com.devsafrica.assemblers;

import com.devsafrica.domain.User;
import com.devsafrica.util.UserUtil;
import com.devsafrica.vo.CreateUserVO;
import com.devsafrica.vo.UpdateUserVO;
import com.devsafrica.vo.UserVO;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler {

//    CreateUserVO and convert to user

    public User toUser(CreateUserVO createUserVO){
        User user = new User();
        user.setFirstName(createUserVO.getFirstName());
        user.setLastName(createUserVO.getLastName());
        user.setUserName(createUserVO.getUserName());

        return user;
    }

//    User to UserVO

    public UserVO toUserVO (User user){
        UserVO userVO = new UserVO();
        userVO.setUserId(user.getId());
        userVO.setFullName(UserUtil.convertToFullName(user.getFirstName(), user.getLastName()));
        userVO.setUserName(user.getUserName());
        return userVO;
    }



//    UpdateUserVO to user
    public User toUser(UpdateUserVO updateUserVO){
        User user = new User();
        user.setId(updateUserVO.getUserId());
        user.setFirstName(updateUserVO.getFirstName());
        user.setLastName(updateUserVO.getLastName());
        user.setUserName(updateUserVO.getUserName());

        return user;
    }
}
