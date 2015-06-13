package com.guillaume.bees.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;

import com.guillaume.bees.shared.BeesEventDTO;
import com.vaadin.components.gwt.polymer.client.widget.PaperButton;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

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
public class Home {
  public static void go(final HasWidgets container) {
    container.clear();

    PaperButton button = new PaperButton("button on Home!");
    button.setRaised(true);
    button.getElement().getStyle().setBackgroundColor("#4285f4");
    button.getElement().getStyle().setColor("#FFFFFF");
    container.add(button);

    button.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        API.getBeesEventAPI().getEvent(123L, new MethodCallback<BeesEventDTO>() {
          public void onFailure(Method method, Throwable exception) {

          }

          public void onSuccess(Method method, BeesEventDTO response) {
            container.add(new Label(response.getName()));
          }
        });
      }
    });

    HomeView homeView = new HomeView();
    homeView.setName("My span");
    container.add(homeView.asWidget());
  }
}
