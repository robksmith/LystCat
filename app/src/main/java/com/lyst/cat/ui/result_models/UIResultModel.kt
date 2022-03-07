package com.lyst.cat.ui.result_models

data class UIResultModel<out T>(val status: Status, val data: T?, val message: String?, val code:Int)
{
    enum class Status
    {
        REQUESTING, SUCCESS, ERROR
    }

    companion object
    {
        fun <T> requesting(data: T?, code:Int): UIResultModel<T>
        {
            return UIResultModel(
                Status.REQUESTING,
                data,
                null,
                code
            )
        }

        fun <T> success(data: T?, code:Int): UIResultModel<T>
        {
            return UIResultModel(
                Status.SUCCESS,
                data,
                null,
                code
            )
        }

        fun <T> error(message: String, data: T? = null): UIResultModel<T>
        {
            return UIResultModel(
                Status.ERROR,
                data,
                null,
                -1
            )
        }
    }
}
