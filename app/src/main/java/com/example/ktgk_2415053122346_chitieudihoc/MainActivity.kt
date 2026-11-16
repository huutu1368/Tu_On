package com.example.ktgk_2415053122346_chitieudihoc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktgk_2415053122346_chitieudihoc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val danhSach = mutableListOf<KhoanChi>()
    private val adapter = KhoanChiAdapter(danhSach)
    private var idTiepTheo = 1L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.danhSach.layoutManager = LinearLayoutManager(this)
        binding.danhSach.adapter = adapter
        binding.form.xoaLoiKhiSua()
        binding.themButton.setOnClickListener { themKhoanChi_2346() }

    }
    private fun themKhoanChi_2346() {
        val khoan = binding.form.docKhoanChi(idTiepTheo) ?: return
        idTiepTheo++
        danhSach.add(khoan)
        adapter.notifyItemInserted(danhSach.lastIndex)

        binding.form.tenInput.text?.clear()
        binding.form.tienInput.text?.clear()
        binding.form.ghiChuInput.text?.clear()
    }

}