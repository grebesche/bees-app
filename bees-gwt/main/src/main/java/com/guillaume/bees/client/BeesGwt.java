package com.guillaume.bees.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;

import com.vaadin.components.gwt.polymer.client.widget.CoreToolbar;
import com.vaadin.components.gwt.polymer.client.widget.PaperShadow;

public class BeesGwt implements EntryPoint {

  public void onModuleLoad() {

    PaperShadow paperShadow = new PaperShadow();
    paperShadow.setZ(2);
    CoreToolbar coreToolbar = new CoreToolbar("Home !");

    paperShadow.add(coreToolbar);

    FlowPanel content = new FlowPanel();
    Home.go(content);

    RootPanel.get().add(paperShadow);
    RootPanel.get().add(content);
  }
}
