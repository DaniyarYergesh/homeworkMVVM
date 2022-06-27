package com.example.myapplication

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.blue
import androidx.core.graphics.green
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class PinTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var radius: Float
    private var hasBorder: Boolean
    private var borderColor: Int
    private var borderSize: Float

    init {
        val shapeDrawable: MaterialShapeDrawable
        context.theme.obtainStyledAttributes(attrs, R.styleable.CircledTextView, 0, 0).apply {
            try {
                radius = getDimensionPixelSize(R.styleable.CircledTextView_radius, 0).toFloat()
                hasBorder = getBoolean(R.styleable.CircledTextView_hasBorder, false)
                borderColor = getColor(R.styleable.CircledTextView_borderColor, 0)
                borderSize =
                    getDimensionPixelSize(R.styleable.CircledTextView_borderSize, 0).toFloat()
            } finally {
                recycle()
            }


            val shapeAppearanceModel: ShapeAppearanceModel =
                ShapeAppearanceModel().toBuilder().apply {
                    if (radius > 0) {
                        setAllCorners(
                            CornerFamily.ROUNDED,
                            radius
                        )
                    }
                }.build()

            shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
                if (hasBorder && borderColor != 0) {
                    strokeWidth = borderSize

                    strokeColor = ColorStateList.valueOf(borderColor)

                }
                fillColor = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.gray))
            }
            background = shapeDrawable
        }
    }


    fun setBorderColor(color: Int){
        borderColor = color
        invalidate()
    }

}