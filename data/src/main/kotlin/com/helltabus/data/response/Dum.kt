package com.helltabus.data.response

data class Dum(
    override val data: DumDto?
) : BaseResponse<DumDto>()