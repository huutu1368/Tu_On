package com.example.ktgk_2415053122346_chitieudihoc

import androidx.core.widget.doAfterTextChanged
import com.example.ktgk_2415053122346_chitieudihoc.databinding.FormKhoanChiBinding

private val regexTen = Regex("""\p{L}[\p{L}\p{M}0-9 .'-]{1,39}""")
private val regexTien = Regex("[1-9][0-9]{0,7}")

fun docSoTien(raw: String): Long? {
    val text = raw.trim()
    if (!regexTien.matches(text)) return null
    return text.toLongOrNull()?.takeIf { it in 1L..10_000_000L }
}

fun FormKhoanChiBinding.xoaLoiKhiSua() {
    tenInput.doAfterTextChanged { tenLayout.error = null }
    tienInput.doAfterTextChanged { tienLayout.error = null }
}

fun FormKhoanChiBinding.docKhoanChi(
    id: Long,
    daThanhToan: Boolean = false
): KhoanChi? {
    val ten = tenInput.text.toString().trim()
    val tenHopLe = regexTen.matches(ten)
    val tien = docSoTien(tienInput.text.toString())

    tenLayout.error = if (tenHopLe) null else
        "Tên phải dài 2–40 ký tự, bắt đầu bằng chữ cái"
    tienLayout.error = if (tien != null) null else
        "Nhập số nguyên từ 1 đến 10.000.000, không có số 0 đầu"

    if (!tenHopLe || tien == null) return null
    return KhoanChi(id, ten, tien, ghiChuInput.text.toString().trim(), daThanhToan)
}