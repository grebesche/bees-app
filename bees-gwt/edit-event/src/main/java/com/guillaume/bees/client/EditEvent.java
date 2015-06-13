package com.guillaume.bees.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasWidgets;

import com.guillaume.bees.client.history.BeesLocation;
import com.guillaume.bees.client.history.HistoryManager;
import com.vaadin.components.gwt.polymer.client.widget.PaperButton;

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
public class EditEvent {

  public static void go(final HasWidgets container) {
    PaperButton button = new PaperButton("Go big or go HOME");
    button.setRaised(true);
    button.getElement().getStyle().setBackgroundColor("#4285f4");
    button.getElement().getStyle().setColor("#FFFFFF");
    container.add(button);

    button.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        HistoryManager.navigateTo(BeesLocation.HOME);
      }
    });
  }
}
