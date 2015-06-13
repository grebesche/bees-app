package com.guillaume.bees.client.history;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

import com.guillaume.bees.client.GlobalEventBus;

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
public class HistoryManager {

  static {
    History.addValueChangeHandler(new ValueChangeHandler<String>() {
      public void onValueChange(ValueChangeEvent<String> event) {
        String historyToken = event.getValue();
        if (BeesLocation.HOME.getTocken().equals(historyToken)) {
          GlobalEventBus.get().fireEvent(new LocationChangedEvent(BeesLocation.HOME));
        } else if (BeesLocation.EDIT_EVENT.getTocken().equals(historyToken)) {
          GlobalEventBus.get().fireEvent(new LocationChangedEvent(BeesLocation.EDIT_EVENT));
        }
      }
    });
  }

  public static void navigateTo(BeesLocation beesLocation) {
    if (beesLocation == null) return;
    History.newItem(beesLocation.getTocken());
  }
}
