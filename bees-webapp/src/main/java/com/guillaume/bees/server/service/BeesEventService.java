package com.guillaume.bees.server.service;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.guillaume.bees.shared.BeesEventDTO;
import com.guillaume.bees.shared.UserDTO;
import com.guillaume.bees.server.jdo.BeesEvent;
import com.guillaume.bees.server.jdo.User;

import java.util.Date;

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
public class BeesEventService {

  public BeesEventDTO getEvent(Long id) {

    BeesEvent event = ObjectifyService.ofy().load().key(
            Key.create(com.guillaume.bees.server.jdo.BeesEvent.class, id)).now();
    if (event == null) {
      return null;
    }
    return convertToDTO(event);
  }

  public BeesEventDTO createEvent(BeesEventDTO dto) {

    com.guillaume.bees.server.jdo.BeesEvent jdo = new com.guillaume.bees.server.jdo.BeesEvent();
    jdo.setName(dto.getName());
    jdo.setCreationDate(new Date());
    jdo.setDescription(dto.getDescription());

    if (dto.getAuthor() != null) {
      User authorJdo = new User();
      authorJdo.setEmail(dto.getAuthor().getEmail());
      authorJdo.setFirstName(dto.getAuthor().getFirstName());
      authorJdo.setLastName(dto.getAuthor().getLastName());
      jdo.setAuthor(authorJdo);
    }

    ObjectifyService.ofy().save().entity(jdo).now();
    return convertToDTO(jdo);
  }

  public void deleteEvent(Long id) {
    ObjectifyService.ofy().delete().key(Key.create(com.guillaume.bees.server.jdo.BeesEvent.class, id));
  }

  private BeesEventDTO convertToDTO(BeesEvent event) {
    BeesEventDTO dto = new BeesEventDTO();
    dto.setId(event.getId());
    dto.setName(event.getName());
    dto.setCreationDate(event.getCreationDate());
    dto.setDescription(event.getDescription());

    if (event.getAuthor() != null) {
      UserDTO author = new UserDTO();
      author.setId(event.getAuthor().getId());
      author.setEmail(event.getAuthor().getEmail());
      author.setFirstName(event.getAuthor().getFirstName());
      author.setLastName(event.getAuthor().getLastName());
      dto.setAuthor(author);
    }
    return dto;
  }
}
