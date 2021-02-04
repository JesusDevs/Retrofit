package com.example.retrofit157_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.retrofit157_1.databinding.FragmentSecondBinding
import com.example.retrofit157_1.pojo.MarsTerrain

/*** A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var binding : FragmentSecondBinding
    private val viewModel : MarsViewModel by activityViewModels()

    private var marsItemSelectedListener : MarsTerrain? = null


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.selectedMars.observe(viewLifecycleOwner,{
            it.let{
                Glide.with(binding.img2).load(it.srcImg).into(binding.img2)

            }
        })


        view.findViewById<Button>(R.id.back2).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}