package com.kite.joco.webunihffrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kite.joco.webunihffrag.data.DataManager
import com.kite.joco.webunihffrag.databinding.FragmentGraphBinding
import com.kite.joco.webunihffrag.databinding.FragmentIncomeBinding

class IncomeFragment : Fragment() {
    private var _binding: FragmentIncomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentIncomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnIncomeSave.setOnClickListener {
            var value = binding.etIncome.text.toString().toInt()
            DataManager.incomes += value
            findNavController().navigate(R.id.action_income_to_graph)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}