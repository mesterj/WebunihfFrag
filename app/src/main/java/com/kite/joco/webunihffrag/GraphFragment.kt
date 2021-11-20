package com.kite.joco.webunihffrag

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.kite.joco.webunihffrag.data.DataManager
import com.kite.joco.webunihffrag.databinding.FragmentGraphBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class GraphFragment : Fragment() {

    private var _binding: FragmentGraphBinding? = null
    private val binding get() = _binding!!
    private val LOGTAG = "GraphFrag"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGraphBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(LOGTAG,"Income ${DataManager.incomes}")
        Log.i(LOGTAG,"Expenses ${DataManager.expenses}")

        drawgraph()

        binding.btnIncome.setOnClickListener {
            findNavController().navigate(R.id.action_graph_to_incomeFragment)
        }

        binding.btnExpense.setOnClickListener {
            findNavController().navigate(R.id.action_graph_to_expenseFragment)
        }
    }

    private fun drawgraph() {
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(DataManager.incomes.toFloat(), "Bevételek"))
        entries.add(PieEntry(DataManager.expenses.toFloat(), "Kiadások"))

        val dataSet = PieDataSet(entries, "Balance")

        dataSet.setDrawIcons(false)

        dataSet.sliceSpace = 3f
        dataSet.selectionShift = 5f

        val colors = ArrayList<Int>()
        colors.add(Color.GREEN)
        colors.add(Color.RED)

        dataSet.colors = colors

        val data = PieData(dataSet)
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.BLUE)

        binding.graphPie.data = data

        binding.graphPie.highlightValues(null)

        binding.graphPie.invalidate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}