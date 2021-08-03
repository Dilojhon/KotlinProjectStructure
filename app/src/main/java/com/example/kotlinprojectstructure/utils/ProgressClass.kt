package com.example.kotlinprojectstructure.utils

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.content.ContextCompat
import com.example.kotlinprojectstructure.R
import com.kaopiz.kprogresshud.KProgressHUD

abstract class ProgressClass {

    companion object {

        @SuppressLint("StaticFieldLeak")
        private lateinit var progressbar: KProgressHUD

        fun createProgressBar(con: Context) {
            progressbar = KProgressHUD.create(con)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setBackgroundColor(
                    ContextCompat.getColor(
                        ContextClass.getContext(),
                        R.color.colorPrimary
                    )
                )
                .setCancellable(false)
                .setAnimationSpeed(1)
                .setDimAmount(0.6f)
        }

        fun showProgressBar() {
            progressbar.show()
        }

        fun hideProgressBar() {
            progressbar.dismiss()
        }
    }
}