package com.example.retrofit157_1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofit157_1.databinding.FragmentFirstBinding
import com.example.retrofit157_1.pojo.MarsTerrain

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var binding : FragmentFirstBinding
    private val viewModel : MarsViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //instanciar adaptador
        //instaniar adapter
        val adapter = MarsAdapter()
        binding.rvView.adapter=adapter
        binding.rvView.layoutManager=GridLayoutManager(context,2)

        // Observador vieja confiable
        viewModel.getFetchTerrains().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })

        //Observador Con Corutinas
        viewModel.getFetchTerrainsWithCoroutines().observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.d("LISTADO COROUTINAS", it.toString())
            }
        })


        /*view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
        // Esto esta observando al objeto expuesto en el viewModel


        adapter.selectedMarsItem().observe( viewLifecycleOwner,{
            it?.let {
            viewModel.selected(it)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        })
    }
}