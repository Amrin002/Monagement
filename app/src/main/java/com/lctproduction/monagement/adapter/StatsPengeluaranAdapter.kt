package com.lctproduction.monagement.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lctproduction.monagement.R
import com.lctproduction.monagement.datasources.Pengeluaran
import com.lctproduction.monagement.datasources.StatsPengeluaran

class StatsPengeluaranAdapter(private val daftarStatsPengeluaran: List<StatsPengeluaran>) :
    RecyclerView.Adapter<StatsPengeluaranAdapter.PengeluaranViewHolder>() {

    class PengeluaranViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val labelPengeluaran: TextView = itemView.findViewById(R.id.labelPengeluaran)
        val imgItemPengeluaran: ImageView = itemView.findViewById(R.id.imgItemPengeluaran)
        val danaPengeluaran: TextView = itemView.findViewById(R.id.danapengeluaran)
        val vItem: View = itemView.findViewById(R.id.vItem) //ini beda dengan labelRv
        val labelRv: ViewGroup = itemView.findViewById(R.id.labelRv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PengeluaranViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_pengeluaran, parent, false)
        return PengeluaranViewHolder(view)
    }

    override fun onBindViewHolder(holder: PengeluaranViewHolder, position: Int) {
        val statsPengeluaran = daftarStatsPengeluaran[position]
        holder.labelPengeluaran.text = statsPengeluaran.nama
        holder.imgItemPengeluaran.setImageResource(statsPengeluaran.imageResId)
        holder.danaPengeluaran.text = "- Rp. ${statsPengeluaran.jumlah}"
        holder.vItem.setBackgroundResource(statsPengeluaran.vItemBackgroundResId)
        holder.labelRv.setBackgroundColor(
            ContextCompat.getColor(holder.itemView.context, statsPengeluaran.labelRvBackgroundColor)
        )// ini ganti menggunakan warna saja untuk backgroundnya
    }

    override fun getItemCount(): Int = daftarStatsPengeluaran.size
}
