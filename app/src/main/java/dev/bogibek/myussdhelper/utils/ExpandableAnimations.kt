package dev.bogibek.myussdhelper.utils

import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation


fun View.expand() {
    expandAction(this)
}

fun View.collapse() {
    val actualHeight: Int = measuredWidth
    val animation: Animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            if (interpolatedTime == 1f) {
                visibility = View.GONE
            } else {
                layoutParams.width =
                    actualHeight - (actualHeight * interpolatedTime).toInt()
                requestLayout()
            }
        }
    }
    animation.duration =
        (actualHeight / context.resources.displayMetrics.density).toLong()
    startAnimation(animation)
}

private fun expandAction(view: View): Animation {
    view.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
    val actualHeight: Int = view.measuredWidth
    view.layoutParams.width = 0
    view.visibility = View.VISIBLE
    val animation: Animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            view.layoutParams.width =
                if (interpolatedTime == 1f) ViewGroup.LayoutParams.WRAP_CONTENT else (actualHeight * interpolatedTime).toInt()
            view.requestLayout()
        }
    }
    animation.duration = (actualHeight / view.context.resources.displayMetrics.density).toLong()
    view.startAnimation(animation)
    return animation
}