package com.example.android.clippingexample

import android.content.Context
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

//custom view extends View. '@JvmOverloads' annotation instructs Kotlin compiler to generate
//overloads for this function that substitute default parameter values
class ClippedView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

//    create and initialize Paint
    private val paint = Paint().apply {

//        smooth out edjes of what is drawn without affecting shape
//        enable anti-aliasing
        isAntiAlias = true
//        use stroke width
        strokeWidth = resources.getDimension(R.dimen.strokeWidth)
//        define text-size
        textSize = resources.getDimension(R.dimen.textSize)
    }

//    create and initialize path variable of Path to store locally path of whats been drawn
    private val path = Path()
}