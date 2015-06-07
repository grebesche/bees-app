package com.guillaume.bees.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class BeesGwt implements EntryPoint {

  public void onModuleLoad() {

    GWT.runAsync(new RunAsyncCallback() {
      public void onFailure(Throwable reason) {

      }

      public void onSuccess() {
        Home.go(RootPanel.get());
      }
    });
  }
}
