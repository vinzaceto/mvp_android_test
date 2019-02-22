package com.vinzaceto.mvptest.weather.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.vinzaceto.mvptest.R
import kotlinx.android.synthetic.main.view_custom_loader.view.*

/**
 * NTT Data Italia S.p.A.
 * File created on 22/02/2019.
 *
 * @author Vincenzo Aceto - vincenzo.aceto@nttdata.com
 * @version 1.0
 */

class LoaderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyle, defStyleRes) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.view_custom_loader, this, true)
        initView()
    }

    private fun initView() {
        av_from_code.setAnimation("loading-animation.json")
        av_from_code.loop(true)
    }

    fun showLoader(){
        av_from_code.playAnimation()
    }

    fun hideLoader(){
        av_from_code.pauseAnimation()
    }
}