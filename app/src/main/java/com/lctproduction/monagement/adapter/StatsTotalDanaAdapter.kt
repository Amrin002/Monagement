package com.lctproduction.monagement.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lctproduction.monagement.R

import com.lctproduction.monagement.datasources.TotalDana

class StatsTotalDanaAdapter(private val daftarStatsTotalDana: List<TotalDana>) :
    RecyclerView.Adapter<StatsTotalDanaAdapter.TotalDanaViewHolder>() {

    class TotalDanaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val labelPengeluaran: TextView = itemView.findViewById(R.id.labelPengeluaran)
        val imgItemPengeluaran: ImageView = itemView.findViewById(R.id.imgItemPengeluaran)
        val danaPengeluaran: TextView = itemView.findViewById(R.id.danapengeluaran)
        val vItem: View = itemView.findViewById(R.id.vItem) //ini beda dengan labelRv
        val labelRv: ViewGroup = itemView.findViewById(R.id.labelRv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TotalDanaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_pengeluaran, parent, false)
        return TotalDanaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TotalDanaViewHolder, position: Int) {
        val statsTotalDana = daftarStatsTotalDana[position]
        holder.labelPengeluaran.text = statsTotalDana.nama
        holder.imgItemPengeluaran.setImageResource(statsTotalDana.imageResId)
        holder.danaPengeluaran.text = "- Rp. ${statsTotalDana.jumlah}"
        holder.vItem.setBackgroundResource(statsTotalDana.vItemBackgroundResId)
        holder.labelRv.setBackgroundColor(
            ContextCompat.getColor(holder.itemView.context, statsTotalDana.labelRvBackgroundColor)
        )// ini ganti menggunakan warna saja untuk backgroundnya
    }

    override fun getItemCount(): Int = daftarStatsTotalDana.size
}
