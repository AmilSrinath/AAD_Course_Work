package lk.ijse.gdse.conversion;

import lk.ijse.gdse.DTO.UserDTO;
import lk.ijse.gdse.Entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Amil Srinath
 */
@Component
public class Mapping {
    final private ModelMapper mapper;

    public Mapping(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public UserDTO toUserDTO(User user) {
        return  mapper.map(user, UserDTO.class);
    }
    public User toUser(UserDTO userDTO) {
        return  mapper.map(userDTO, User.class);
    }
    public List<UserDTO> toUserDTOList(List<User> users) {
        return mapper.map(users, List.class);
    }
}
