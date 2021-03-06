package com.guillaume.bees.server;

import com.googlecode.objectify.ObjectifyService;
import com.guillaume.bees.server.jdo.BeesEvent;
import com.guillaume.bees.server.jdo.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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
public class OfyHelper implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    ObjectifyService.register(BeesEvent.class);
    ObjectifyService.register(User.class);
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {

  }
}
