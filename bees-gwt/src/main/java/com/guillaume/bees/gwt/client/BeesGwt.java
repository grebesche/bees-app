package com.guillaume.bees.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import com.guillaume.bees.gwt.client.rest.BeesEventAPI;
import com.guillaume.bees.shared.BeesEventDTO;
import com.vaadin.components.gwt.polymer.client.widget.CoreToolbar;
import com.vaadin.components.gwt.polymer.client.widget.PaperButton;
import com.vaadin.components.gwt.polymer.client.widget.PaperShadow;

import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestServiceProxy;

public class BeesGwt implements EntryPoint {

  public void onModuleLoad() {
    PaperShadow paperShadow = new PaperShadow();
    paperShadow.setZ(2);
    CoreToolbar coreToolbar = new CoreToolbar("My tool bar");
    paperShadow.add(coreToolbar);

    PaperButton button = new PaperButton("button !");
    button.setRaised(true);

    button.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
      }
    });

    RootPanel.get().add(paperShadow);
    RootPanel.get().add(button);

    Resource resource = new Resource(GWT.getModuleBaseURL() + "pizza-service");

    BeesEventAPI beesEventAPI = GWT.create(BeesEventAPI.class);
    ((RestServiceProxy)beesEventAPI).setResource(resource);

    BeesEventDTO event = beesEventAPI.getEvent(6192449487634432L);

    RootPanel.get().add(new Label(event.getName()));

  }
}
