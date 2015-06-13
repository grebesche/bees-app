package com.guillaume.bees.client.history;

import com.google.web.bindery.event.shared.Event;

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
public class LocationChangedEvent extends Event<LocationChangedEvent.Handler> {

  public static final Type<Handler> TYPE = new Type<Handler>();

  private BeesLocation location;

  public LocationChangedEvent(BeesLocation location) {
    this.location = location;
  }

  public BeesLocation getLocation() {
    return location;
  }

  @Override
  public Type<Handler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(Handler handler) {
    handler.applicationChanged(this);
  }

  public interface Handler {
    void applicationChanged(LocationChangedEvent event);
  }
}
