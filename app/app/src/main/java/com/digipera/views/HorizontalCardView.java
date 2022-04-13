package com.digipera.views;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.digipera.R;
import com.digipera.dto.HorizontalCard;

import java.util.ArrayList;
import java.util.List;

public class HorizontalCardView {
    public static List<View> getViews(AppCompatActivity context,
                                      LinearLayout rootLayout,
                                      List<HorizontalCard> cards) {

        List<View> views = new ArrayList<>();
        cards.forEach(card -> {
            // Here you can access all views inside your child layout and assign them values
            View view = LayoutInflater.from(context).inflate(R.layout.horizontal_card, rootLayout,
                    false);
            TextView line1Left = view.findViewById(R.id.line1_left);
            line1Left.setText(card.getLine1Left());

            TextView line1Right = view.findViewById(R.id.line1_right);
            line1Right.setText(card.getLine1Right());

            TextView line2Left = view.findViewById(R.id.line2_left);
            line2Left.setText(card.getLine2Left());

            TextView line2Right = view.findViewById(R.id.line2_right);
            line2Right.setText(card.getLine2Right());
            views.add(view);
        });

        return views;
    }
}
