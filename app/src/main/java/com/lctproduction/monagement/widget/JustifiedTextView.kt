package com.lctproduction.monagement.widget

import android.content.Context
import android.graphics.Canvas
import android.text.Layout
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.NotificationCompat.Style

class JustifiedTextView  @JvmOverloads constructor(
    context : Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatTextView(context, attrs, defStyle){
    override fun onDraw(canvas: Canvas) {
        val  text = text.toString()
        val width = width
        val layout = layout

        if (layout != null){
            for (i in 0 until layout.lineCount){
                val lineStart = layout.getLineStart(i)
                val lineEnd = layout.getLineEnd(i)
                val line = text.substring(lineStart, lineEnd)
                if (i== layout.lineCount - 1){
                    canvas.drawText(line,0f, layout.getLineBaseline(i).toFloat(),paint)
                } else {
                    val trimmedLine = line.trim{it <= ' '}
                    val lineWidth = Layout.getDesiredWidth(trimmedLine, paint)
                    val  gapWidth = (width - lineWidth) / (trimmedLine.length - 1)
                    var x = 0f
                    for (char in trimmedLine){
                        canvas.drawText(char.toString(), x, layout.getLineBaseline(i).toFloat(), paint)
                        x += Layout.getDesiredWidth(char.toString(),paint)+ gapWidth
                    }
                }
            }
        }
    }
}