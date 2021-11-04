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

//    variables for dimensions for clipping rectangle around the whole set of shapes
    private val clipRectRight = resources.getDimension(R.dimen.clipRectRight)
    private val clipRectBottom = resources.getDimension(R.dimen.clipRectBottom)
    private val clipRectTop = resources.getDimension(R.dimen.clipRectTop)
    private val clipRectLeft = resources.getDimension(R.dimen.clipRectLeft)

//    variables for the inset of a rectangle and offset of a small rectangle
    private val rectInset = resources.getDimension(R.dimen.rectInset)
    private val smallRectOffset = resources.getDimensionPixelOffset(R.dimen.smallRectOffset)

//    variable for radius of circle. This circle is drawn inside rectangle
    private val circleRadius = resources.getDimension(R.dimen.circleRadius)

//    offset and text size for text that is drawn inside rectangle
    private val textOffset = resources.getDimension(R.dimen.textOffset)
    private val textSize = resources.getDimension(R.dimen.textSize)

//    set up coordinates for two columns
    private val columnOne = rectInset
    private val columnTwo = columnOne + rectInset + clipRectRight

//    add coordinate for each row, including the final row for transformed text
    private val rowOne = rectInset
    private val rowTwo = rowOne + rectInset + clipRectBottom
    private val rowThree = rowTwo + rectInset + clipRectBottom
    private val rowFour = rowThree + rectInset + clipRectBottom
    private val textRow = rowFour + (1.5f * clipRectBottom)
}