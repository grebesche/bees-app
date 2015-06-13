package com.guillaume.bees.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

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
public class HomeView implements IsWidget {

  interface UiBinder extends com.google.gwt.uibinder.client.UiBinder<HTMLPanel, HomeView> {
  }

  private static UiBinder uiBinder = GWT.create(UiBinder.class);

  private Widget root;

  public Widget asWidget() {
    return root;
  }

  @UiField
  SpanElement nameSpan;
  @UiField
  PaperButton myPaperButton;


  public HomeView() {
    root = uiBinder.createAndBindUi(this);
  }

  public void setName(String name) {
    nameSpan.setInnerText(name);
  }
}
