package com.lctproduction.monagement.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.lctproduction.monagement.R

class CustomImageView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var initial: String = "A"
    private val paint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.grey) // Use the grey color from resources
        textAlign = Paint.Align.CENTER
        textSize = 100f // Adjust the text size as needed
    }

    private val circlePaint = Paint().apply {
        color = Color.WHITE // Adjust the circle color as needed
    }

    fun setInitial(name: String) {
        initial = name.first().toUpperCase().toString()
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw circle
        val radius = width.coerceAtMost(height) / 2f
        canvas.drawCircle(width / 2f, height / 2f, radius, circlePaint)

        // Draw initial
        val xPos = width / 2f
        val yPos = (height / 2f - (paint.descent() + paint.ascent()) / 2)
        canvas.drawText(initial, xPos, yPos, paint)
    }
}