package com.quiz;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

  @Id
  private UUID id;

  private String firstName;

  private String lastName;

}
