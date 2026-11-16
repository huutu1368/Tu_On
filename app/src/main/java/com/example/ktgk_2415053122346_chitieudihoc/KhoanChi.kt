package com.example.ktgk_2415053122346_chitieudihoc

data class KhoanChi(
    val id: Long,
    val ten: String,
    val soTien: Long,
    val ghiChu: String,
    val daThanhToan: Boolean = false
)