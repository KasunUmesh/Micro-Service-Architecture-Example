package lk.ijse.userservice.util;

import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DataTypeConversion {

    private final ModelMapper modelMapper;

    DataTypeConversion(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

   public UserDTO getUserDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }
    public User getUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }
}
