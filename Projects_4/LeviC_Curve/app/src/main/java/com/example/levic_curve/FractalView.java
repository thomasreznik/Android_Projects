package com.example.levic_curve;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class FractalView extends View {
    private float x1;
    private float y1;
    private float x2;
    private float y2;
    public int level;
    private Fractal fractal;

    public FractalView(Context context) {
        super(context);
        level =2;
        fractal = new Fractal();
    }

    protected void onDraw(Canvas canvas){
        //Get dimensions of the canvas

        x1 = canvas.getWidth() /3;
        y1 = canvas.getHeight()/4;

        x2 = canvas.getWidth() - x1;
        y2 = y1;

        //Fill canvas with white paint
        canvas.drawRGB(255,255,255);

        //Draw the C-Curve
        fractal.drawCCurve(canvas,x1,y1,x2,y2,level);
    }

}
