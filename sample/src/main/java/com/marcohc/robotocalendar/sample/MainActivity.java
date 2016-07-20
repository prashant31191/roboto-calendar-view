/*
 * Copyright (C) 2015 Marco Hernaiz Cao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.marcohc.robotocalendar.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.marcohc.robotocalendar.RobotoCalendarView;
import com.marcohc.robotocalendar.RobotoCalendarView.RobotoCalendarListener;
import com.marcohc.robotocalendarsample.R;

import java.util.Calendar;
import java.util.Random;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Sample Activity
 *
 * @author Marco Hernaiz Cao
 */
public class MainActivity extends AppCompatActivity implements RobotoCalendarListener {

    private RobotoCalendarView robotoCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Gets the calendar from the view
        robotoCalendarView = (RobotoCalendarView) findViewById(R.id.robotoCalendarPicker);

        // Set listener, in this case, the same activity
        robotoCalendarView.setRobotoCalendarListener(this);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onDaySelected(Calendar daySelectedCalendar) {

        Toast.makeText(this, "onDaySelected!", Toast.LENGTH_SHORT).show();

        // Mark that day with random colors
        final Random random = new Random(System.currentTimeMillis());
        final int style = random.nextInt(3);
        switch (style) {
            case 0:
                robotoCalendarView.markFirstUnderlineWithStyle(RobotoCalendarView.BLUE_COLOR, daySelectedCalendar);
                break;
            case 1:
                robotoCalendarView.markSecondUnderlineWithStyle(RobotoCalendarView.GREEN_COLOR, daySelectedCalendar);
                break;
            case 2:
                robotoCalendarView.markFirstUnderlineWithStyle(RobotoCalendarView.RED_COLOR, daySelectedCalendar);
                break;
            default:
                break;
        }
    }

    @Override
    public void onRightButtonClick() {
        Toast.makeText(this, "onRightButtonClick!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLeftButtonClick() {
        Toast.makeText(this, "onLeftButtonClick!", Toast.LENGTH_SHORT).show();
    }

}
