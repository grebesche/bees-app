package com.guillaume.bees.server.servlet;

import com.guillaume.bees.dto.BeesEventDTO;
import com.guillaume.bees.server.service.BeesEventService;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
@Singleton
@Path("/event")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BeesEventServlet {

  private BeesEventService service;

  public BeesEventServlet() {
    service = new BeesEventService();
  }

  @GET
  @Path("{id}")
  public BeesEventDTO getEvent(@PathParam("id") Long id) {
    return service.getEvent(id);
  }

  @POST
  public BeesEventDTO postEvent(BeesEventDTO event) {
    return service.createEvent(event);
  }

  @DELETE
  @Path("{id}")
  public void deleteEvent(@PathParam("id") Long id) {
    service.deleteEvent(id);
  }
}
