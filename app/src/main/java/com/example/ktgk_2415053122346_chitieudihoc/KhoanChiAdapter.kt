package com.example.ktgk_2415053122346_chitieudihoc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ktgk_2415053122346_chitieudihoc.databinding.ItemKhoanChiBinding

class KhoanChiAdapter(
    private val danhSach: List<KhoanChi>
) : RecyclerView.Adapter<KhoanChiAdapter.KhoanChiViewHolder>() {

    class KhoanChiViewHolder(val binding: ItemKhoanChiBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KhoanChiViewHolder {
        val binding = ItemKhoanChiBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return KhoanChiViewHolder(binding)
    }

    override fun getItemCount(): Int = danhSach.size

    override fun onBindViewHolder(holder: KhoanChiViewHolder, position: Int) {
        val khoan = danhSach[position]
        with(holder.binding) {
            tenText.text = khoan.ten
            tienText.text = "${khoan.soTien} đ"
            trangThaiText.text =
                if (khoan.daThanhToan) "Đã thanh toán" else "Chưa thanh toán"
        }
    }
}