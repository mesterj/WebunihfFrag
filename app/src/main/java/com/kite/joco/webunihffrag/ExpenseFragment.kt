package com.kite.joco.webunihffrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kite.joco.webunihffrag.data.DataManager
import com.kite.joco.webunihffrag.databinding.FragmentExpenseBinding
import com.kite.joco.webunihffrag.databinding.FragmentIncomeBinding


class ExpenseFragment : Fragment() {

    private var _binding: FragmentExpenseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentExpenseBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnExpenseSave.setOnClickListener {
            var value = binding.etExpense.text.toString().toInt()
            DataManager.expenses += value
            findNavController().navigate(R.id.action_expense_to_graph)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}