package com.quiz;

import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
  private UserRepository userRepository;

  public void createUsers (List<User> l){
      l.forEach(this::createOrUpdateUser);
  }

  @Transactional
  void createOrUpdateUser(User u) {
    if(userRepository.existsById(u.getId())){
      User c = userRepository.findById(u.getId()).get();
      c.setFirstName(u.getFirstName());
      c.setLastName(u.getLastName());
      userRepository.save(c);
    } else {
      u.setId(UUID.randomUUID());
      userRepository.save(u);
    }
  }
}
