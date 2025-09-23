package kr.co.ch07.service;

import kr.co.ch07.dto.UserDTO;
import kr.co.ch07.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public List<UserDTO> getUsers(){
        return null;
    }
    public UserDTO getUser(String usid){
        return null;
    }
    public void save(UserDTO userDTO){
        String plain = userDTO.getPass();
        String encode = passwordEncoder.encode(plain);
        userDTO.setPass(encode);

        userRepository.save(userDTO.toEntity());
    }
    public void modify(){}
    public void deletc(){}
}
