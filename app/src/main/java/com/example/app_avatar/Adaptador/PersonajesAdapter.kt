package com.example.app_avatar.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.example.app_avatar.R
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.app_avatar.clases.Personajes

class PersonajesAdapter (private var dataList: List<Personajes>): RecyclerView.Adapter<PersonajesAdapter.PersonajesViewHolder>() {

    // 2. Establecer el clic en la card de categoría
    private var onItemClickListener: ((Personajes) -> Unit)? = null

    fun setOnItemClickListener(listener: (Personajes) -> Unit) {
        onItemClickListener = listener
    }

    class PersonajesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val categoriaImage: ImageView = itemView.findViewById(R.id.imgcategoria)
        val categoriaNameTextView: TextView = itemView.findViewById(R.id.txtcattitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajesViewHolder {
        // Inflar la vista de la cardview desde el layout xml
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_categoria, parent, false)
        return PersonajesAdapter.PersonajesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: PersonajesViewHolder, position: Int) {
        val category = dataList[position]

        Glide.with(holder.itemView.context)
            .load(category.photoUrl)
            .into(holder.categoriaImage)

        holder.categoriaNameTextView.text =category.name
        /*---*/
        holder.itemView.setOnClickListener {

        }

        // 2. Configurar el clic en la card de categoría
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(category)
        }
    }

    fun setData(categoria: List<Personajes>) {
        dataList = categoria
        notifyDataSetChanged()
    }




}