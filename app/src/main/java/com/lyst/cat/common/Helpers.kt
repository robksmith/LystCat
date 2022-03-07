package com.lyst.cat.common

import android.app.Activity
import android.content.Intent

inline fun<reified T: Activity> Activity.startNewActivity(finishCallingActivity: Boolean = true)
{
    val intent = Intent(this, T::class.java)
//    if ( Constants.RetainAcititiesLikeIos )
//        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT //- like iOS this and remove the finish below
//    else
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
    startActivity(intent)
    //overridePendingTransition(R.animator.fade_in, R.animator.fade_out)
    if (finishCallingActivity) this.finish()
}