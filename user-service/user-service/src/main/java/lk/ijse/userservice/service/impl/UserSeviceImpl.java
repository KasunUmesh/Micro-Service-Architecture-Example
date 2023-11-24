package lk.ijse.userservice.service.impl;

import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.repo.UserRepo;
import lk.ijse.userservice.service.UserService;
import lk.ijse.userservice.util.DataTypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserSeviceImpl implements UserService {

    @Autowired
    private DataTypeConversion dataTypeConversion;

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return dataTypeConversion.getUserDTO(userRepo.save(dataTypeConversion.getUserEntity(userDTO)));
    }
}
