package com.example.course.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Topic (
   @StringRes val stringResource : Int,
    val label : Int,
   @DrawableRes val imageResource :Int
)