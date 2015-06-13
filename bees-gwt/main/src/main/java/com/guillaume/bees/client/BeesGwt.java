package com.guillaume.bees.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;

import com.guillaume.bees.client.history.HistoryManager;
import com.guillaume.bees.client.history.LocationChangedEvent;
import com.vaadin.components.gwt.polymer.client.widget.CoreToolbar;
import com.vaadin.components.gwt.polymer.client.widget.PaperShadow;

public class BeesGwt implements EntryPoint {

  public void onModuleLoad() {

    HistoryManager historyManager;

    PaperShadow paperShadow = new PaperShadow();
    paperShadow.setZ(2);
    CoreToolbar coreToolbar = new CoreToolbar("Home !");

    paperShadow.add(coreToolbar);

    final FlowPanel content = new FlowPanel();
    Home.go(content);

    RootPanel.get().add(paperShadow);
    RootPanel.get().add(content);

    GlobalEventBus.get().addHandler(LocationChangedEvent.TYPE, new LocationChangedEvent.Handler() {
      public void applicationChanged(LocationChangedEvent event) {
        content.clear();
        switch (event.getLocation()) {
          case HOME:
            Home.go(content);
            break;
          case EDIT_EVENT:
            EditEvent.go(content);
            break;
        }
      }
    });
  }
}
