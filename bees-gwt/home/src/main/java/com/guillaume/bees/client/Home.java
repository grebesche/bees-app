package com.guillaume.bees.client;

import com.google.gwt.user.client.ui.HasWidgets;

import com.vaadin.components.gwt.polymer.client.widget.CoreToolbar;
import com.vaadin.components.gwt.polymer.client.widget.PaperButton;
import com.vaadin.components.gwt.polymer.client.widget.PaperShadow;

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
  public static void go(HasWidgets container) {

    container.clear();


    PaperShadow paperShadow = new PaperShadow();
    paperShadow.setZ(2);
    CoreToolbar coreToolbar = new CoreToolbar("Home !");
    paperShadow.add(coreToolbar);

    PaperButton button = new PaperButton("button on Home!");
    button.setRaised(true);

    container.add(paperShadow);
    container.add(button);
  }
}
