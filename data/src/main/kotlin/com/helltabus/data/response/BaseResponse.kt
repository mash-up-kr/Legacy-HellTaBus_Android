package com.helltabus.data.response

abstract class BaseResponse<D> {
    var status: Int? = null
    var message: String? = null
    abstract val data: D?
}