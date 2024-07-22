package com.lctproduction.monagement.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.lctproduction.monagement.R

import com.lctproduction.monagement.adapter.StatsPengeluaranAdapter
import com.lctproduction.monagement.adapter.StatsTotalDanaAdapter
import com.lctproduction.monagement.databinding.FragmentStatistikBinding

import com.lctproduction.monagement.datasources.StatsPengeluaran
import com.lctproduction.monagement.datasources.TotalDana

class StatistikFragment : Fragment() {

    private var _binding: FragmentStatistikBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatistikBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvStatsPengeluaran = binding.rvPengeluaran2

        val daftarStatsPengeluaran = listOf(
            StatsPengeluaran("Belanja", 60000.0, R.drawable.shop_icon, R.drawable.bg_radius2, R.color.lightyellow),
//            Pengeluaran("Transportasi", 300000.0, R.drawable.transportasi, R.drawable.bg_radius22 )


            // Tambahkan pengeluaran lainnya sesuai kebutuhan
        )
        val adapter = StatsPengeluaranAdapter(daftarStatsPengeluaran)

        rvStatsPengeluaran.layoutManager = LinearLayoutManager(requireContext())
        rvStatsPengeluaran.adapter = adapter //Type mismatch: inferred type is PengeluaranAdapter but RecyclerView.Adapter<(raw) RecyclerView.ViewHolder!>? was expected

        // Total Dana
        val rvTotalDana = binding.rvTotalDanaKeluar

        val daftarStatsTotalDana = listOf(
            TotalDana("Belanja", 60000.0, R.drawable.shop_icon, R.drawable.bg_radius2, R.color.lightyellow),
//            Pengeluaran("Transportasi", 300000.0, R.drawable.transportasi, R.drawable.bg_radius22 )


            // Tambahkan pengeluaran lainnya sesuai kebutuhan
        )
        val adapter2 = StatsTotalDanaAdapter(daftarStatsTotalDana)

        rvTotalDana.layoutManager = LinearLayoutManager(requireContext())
        rvTotalDana.adapter = adapter2
        // Now you can access views using binding, e.g., binding.someTextView.text = "Hello"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // To avoid memory leaks
    }
}