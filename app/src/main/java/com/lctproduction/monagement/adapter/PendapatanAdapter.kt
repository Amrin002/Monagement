package com.lctproduction.monagement.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lctproduction.monagement.R
import com.lctproduction.monagement.datasources.Pendapatan

class PendapatanAdapter(private val daftarPendapatan: List<Pendapatan>) :
    RecyclerView.Adapter<PendapatanAdapter.PendapatanHolder>() {

    class PendapatanHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val uangSisa: TextView = itemView.findViewById(R.id.sisaMoney)
        val uangTotal: TextView = itemView.findViewById(R.id.totalMoney)
        val progresMoney: ProgressBar = itemView.findViewById(R.id.progresMoney)
        val presentasiMoney: TextView = itemView.findViewById(R.id.presentasiMoney)
        val namaPekerjaan: TextView = itemView.findViewById(R.id.namaPekerjaan2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendapatanHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_pendapatan, parent, false)
        return PendapatanHolder(view)
    }

    override fun onBindViewHolder(holder: PendapatanHolder, position: Int) {
        val pendapatan = daftarPendapatan[position]
        holder.uangSisa.text = "Rp. ${pendapatan.sisaMoney} /"
        holder.uangTotal.text = "Rp. ${pendapatan.totalMoney}"
        holder.progresMoney.progress = pendapatan.progresMoney
        holder.presentasiMoney.text = "${pendapatan.presentasiMoney}%"
        holder.namaPekerjaan.text = pendapatan.pekerjaan
    }

    override fun getItemCount(): Int = daftarPendapatan.size
}
