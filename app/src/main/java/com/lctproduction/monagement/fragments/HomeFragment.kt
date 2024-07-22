package com.lctproduction.monagement.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.lctproduction.monagement.R
import com.lctproduction.monagement.adapter.PengeluaranAdapter
import com.lctproduction.monagement.databinding.FragmentHomeBinding
import com.lctproduction.monagement.datasources.Pengeluaran

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get user info from SharedPreferences
        val sharedPreferences = requireActivity().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val userName = sharedPreferences.getString("userName", "User")
        // Set initial for InitialCircleView
        binding.intialCircleView.setInitial(userName ?: "User")

        val rvPengeluaran = binding.rvPengeluaran

        val daftarPengeluaran = listOf(
            Pengeluaran("Belanja", 60000.0, R.drawable.shop_icon, R.drawable.bg_radius2, R.color.lightyellow),
            Pengeluaran("BBM", 30000.00, R.drawable.transportasi, R.drawable.bg_radius22, R.color.textcolorred)



            // Tambahkan pengeluaran lainnya sesuai kebutuhan
        )
        val adapter = PengeluaranAdapter(daftarPengeluaran)

        rvPengeluaran.layoutManager = LinearLayoutManager(requireContext())
        rvPengeluaran.adapter = adapter //Type mismatch: inferred type is PengeluaranAdapter but RecyclerView.Adapter<(raw) RecyclerView.ViewHolder!>? was expected


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // To avoid memory leaks
    }
}
