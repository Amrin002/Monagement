package com.lctproduction.monagement.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.lctproduction.monagement.R

class CustomCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {
    private val path = Path()
    private val rect = RectF()

    private var cornerRadiusBottomLeft = 0f
    private var cornerRadiusBottomRight = 0f

    init {
        context.theme.obtainStyledAttributes(
            attrs, R.styleable.CustomCardView, 0, 0
        ).apply {
            try {
                cornerRadiusBottomLeft = getDimension(R.styleable.CustomCardView_cornerRadiusBottomLeft, 0f)
                cornerRadiusBottomRight = getDimension(R.styleable.CustomCardView_cornerRadiusBottomRight, 0f)
            } finally {
                recycle()
            }
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        rect.set(0f, 0f, w.toFloat(), h.toFloat())
        path.reset()
        path.addRoundRect(
            rect, floatArrayOf(0f, 0f, 0f, 0f, cornerRadiusBottomLeft, cornerRadiusBottomLeft, cornerRadiusBottomRight, cornerRadiusBottomRight),
            Path.Direction.CW
        )
        path.close()
    }

    override fun onDraw(canvas: Canvas) {
        canvas.clipPath(path)
        super.onDraw(canvas)
    }
}