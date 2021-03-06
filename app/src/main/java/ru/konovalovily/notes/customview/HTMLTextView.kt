package ru.konovalovily.notes.customview

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT
import ru.konovalovily.notes.R

@SuppressLint("CustomViewStyleable", "WrongConstant")
class HTMLTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultAttrs: Int = 0
) : AppCompatTextView(context, attrs, defaultAttrs) {

    init {
        context.obtainStyledAttributes(
            attrs,
            R.styleable.HtmlParseTextView,
            defaultAttrs,
            0
        ).apply {
            try {
                val shouldParseHtml = getBoolean(
                    R.styleable.HtmlParseTextView_htmlParse,
                    false
                )
                if (shouldParseHtml) {
                    val parsedText = HtmlCompat.fromHtml(text as String, FROM_HTML_MODE_COMPACT)
                    text = parsedText
                }
            } finally {
                recycle()
            }
        }
    }
}