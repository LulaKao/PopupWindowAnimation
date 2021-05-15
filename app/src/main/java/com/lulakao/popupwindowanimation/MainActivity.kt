package com.lulakao.popupwindowanimation

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import com.lulakao.popupwindowanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnShow.setOnClickListener { showPopupWindow() }
    }

    private fun showPopupWindow() {
        val mPopupWindow = PopupWindow(
            LayoutInflater.from(this).inflate(R.layout.popupview, null),
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        mPopupWindow.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mPopupWindow.isOutsideTouchable = false
        mPopupWindow.isFocusable = false
//        mPopupWindow.animationStyle = R.style.AnimationFromTop
        mPopupWindow.animationStyle = R.style.AlphaAnimation
        mPopupWindow.showAtLocation(binding.root, Gravity.LEFT or Gravity.TOP, 0, 0)

        Handler().postDelayed(Runnable {
            mPopupWindow.dismiss()
        }, 5000)
    }
}