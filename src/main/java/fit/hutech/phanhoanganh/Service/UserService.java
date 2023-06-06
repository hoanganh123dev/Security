package fit.hutech.phanhoanganh.Service;


import fit.hutech.phanhoanganh.dto.UserDto;
import fit.hutech.phanhoanganh.model.User;

import java.util.List;
public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
