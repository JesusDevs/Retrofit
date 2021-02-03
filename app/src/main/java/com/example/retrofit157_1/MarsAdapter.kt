package com.example.retrofit157_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.persistableBundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit157_1.databinding.MarsItemListBinding
import com.example.retrofit157_1.pojo.MarsTerrain


//extender recycler luego adapter.clase creada
class MarsAdapter : RecyclerView.Adapter<MarsAdapter.MarsVH>() {

    //2 agregarvista en segundo fragment, crear variable envuelta en live data
    private val selectedMars = MutableLiveData<MarsTerrain>()
    //2 metodo
    fun selectedMarsItem():LiveData<MarsTerrain> =selectedMars


    //crear listado
    private var listaMarsItem = listOf<MarsTerrain>()
    //metodo para recibir las vistas en listado
        fun update (list: List<MarsTerrain>){
            listaMarsItem = list
        //metodo al final de crear adaptador informa si se realixaron cambios
        notifyDataSetChanged()
        }
    inner class MarsVH(private val binding: MarsItemListBinding):RecyclerView.ViewHolder
        (binding.root) ,View.OnClickListener {
     //metodo para mostrar imagen
        fun bind(marsTerrain: MarsTerrain) {
            Glide.with(binding.imageView)
                .load(marsTerrain.srcImg)
                .centerCrop()
                .into(binding.imageView)
         //asignar inclick a tod.o el view holder
                itemView.setOnClickListener(this)
        }
        // 2 asiganar onclick en pantalla a live data
        override fun onClick(p0: View?) {
        selectedMars.value=listaMarsItem[adapterPosition]
        } }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsVH {
        return MarsVH(MarsItemListBinding.inflate(LayoutInflater.from(parent.context)))

    }

    override fun onBindViewHolder(holder: MarsVH, position: Int) {
        val marsTerrain = listaMarsItem[position]
        holder.bind(marsTerrain)


    }

    override fun getItemCount(): Int =listaMarsItem.size

}