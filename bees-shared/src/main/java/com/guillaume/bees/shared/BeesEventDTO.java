package com.guillaume.bees.shared;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Copyright 2015 Guillaume Rebesche
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
public class BeesEventDTO implements Serializable{

  private Long id;
  private Date creationDate;
  private String name;
  private String description;
  private UserDTO author;
  private Set<UserDTO> participants = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UserDTO getAuthor() {
    return author;
  }

  public void setAuthor(UserDTO author) {
    this.author = author;
  }

  public Set<UserDTO> getParticipants() {
    return participants;
  }

  public void setParticipants(Set<UserDTO> participants) {
    this.participants = participants;
  }
}
