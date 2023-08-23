package com.example.app_avatar

import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_avatar.Adaptador.PersonajesAdapter
import com.example.app_avatar.clases.Personajes


import okhttp3.Response
import javax.security.auth.callback.Callback

class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var miAdapter: PersonajesAdapter
    private val personajeList = mutableListOf<Personajes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = view.findViewById(R.id.rcvcardcat)
        val layoutManager = GridLayoutManager(activity, 2) // Cambia el número '2' al número de columnas que desees
        recyclerView.layoutManager = layoutManager

        miAdapter = PersonajesAdapter(personajeList ) // Corregir aquí, usar CategoriaAdapter en lugar de ProductoAdapter
        recyclerView.adapter = miAdapter
        return view

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Configurar el onItemClickListener para el CategoriaAdapter
        miAdapter.setOnItemClickListener { categoria ->

        }

        obtenerProductos()

    }

    private fun obtenerProductos() {
        val retrofitTraer = retroficpersonajes.consumirApi.getTraerCategoria()

        retrofitTraer.enqueue(object : Callback<List<Personajes>> {
            override fun onResponse(call: Call<List<Personajes>>, response: Response<List<Personajes>>) {
                if (response.isSuccessful) {
                    val categorias = response.body()
                    if (categorias != null) {
                        miAdapter.setData(categorias)
                    } else {
                        Toast.makeText(activity, "No se encontraron personajes.", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(activity, "Error al obtener los personajes.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Personajes>>, t: Throwable) {
                Toast.makeText(activity, "Error al consultar API Rest", Toast.LENGTH_SHORT).show()
            }
        })
    }


}