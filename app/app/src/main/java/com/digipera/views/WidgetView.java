package com.digipera.views;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.dto.Widget;

import java.util.ArrayList;
import java.util.List;

public class WidgetView {
    public static List<View> getWidgetViews(
            AppCompatActivity context, LinearLayout rootLayout, List<Widget> widgets) {

        List<View> views = new ArrayList<>();
        widgets.forEach(widget -> {
            // Here you can access all views inside your child layout and assign them values
            View view = LayoutInflater.from(context).inflate(R.layout.widget, rootLayout, false);

            ImageView widgetImage = view.findViewById(R.id.widgetImage);
            widgetImage.setId(widget.getWidgetId());
            widgetImage.setImageResource(widget.getWidgetImage());

            TextView widgetText = view.findViewById(R.id.widgetText);
            widgetText.setText(widget.getWidgetText());
            if (widget.getWidgetText().equalsIgnoreCase(Constants.QUIZ)
                    || widget.getWidgetText().equalsIgnoreCase(Constants.ADD_QUIZ)
                    || widget.getWidgetText().equalsIgnoreCase(Constants.ADD_MONEY)) {
                view.setBackground(ContextCompat.getDrawable(context, R.drawable.rounded_square_grey));
            }
            views.add(view);
        });

        return views;
    }
}
