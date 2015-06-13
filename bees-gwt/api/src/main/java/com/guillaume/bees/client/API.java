package com.guillaume.bees.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;

import com.guillaume.bees.client.rest.BeesEventAPI;

import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestServiceProxy;

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
public class API implements EntryPoint {

  private static  BeesEventAPI beesEventAPI;

  public void onModuleLoad() {
    setup();
  }

  private static void setup() {
    Resource resource = new Resource("http://localhost:8080/_ah/spi/v1/");
    beesEventAPI = GWT.create(BeesEventAPI.class);
    ((RestServiceProxy) beesEventAPI).setResource(resource);
  }

  public static BeesEventAPI getBeesEventAPI() {
    return beesEventAPI;
  }
}
