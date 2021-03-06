/*
 * Copyright 2016 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.squareup.coordinators.sample.basic;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.squareup.coordinators.Coordinator;
import com.squareup.coordinators.CoordinatorProvider;
import com.squareup.coordinators.Coordinators;

public class BasicSampleActivity extends Activity {

  private static final TicTacToeBoard MODEL = new TicTacToeBoard();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tic_tac_toe_view);

    Coordinators.bind(findViewById(R.id.board_view), new CoordinatorProvider() {
      @Nullable @Override public Coordinator provideCoordinator(View view) {

        // A more interesting app could inspect the given view and choose an
        // appropriate coordinator for it -- perhaps based on the type of the view,
        // on on meta information in a tag on the view, so many possibilities...

        return new TicTacToeCoordinator(MODEL);
      }
    });
  }
}
