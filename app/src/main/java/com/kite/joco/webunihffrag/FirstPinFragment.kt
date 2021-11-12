package com.kite.joco.webunihffrag

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import androidx.navigation.fragment.findNavController
import com.kite.joco.webunihffrag.databinding.PinfragmentBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstPinFragment : Fragment() {

    companion object {
        const val goodpin = "1234"
        val TAG = "FIRSTPINFRAG"
    }

    private var _binding: PinfragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PinfragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var pin = ""
        binding.pinEditText.setOnCompleteListener {
            if (it.length == 4) {
                binding.btnLogin.isEnabled = true
                Log.i(TAG,"Value: $it")
                pin = it
            }
        }

        binding.btnLogin.setOnClickListener {
            pin = binding.pinEditText.text.toString()
            Log.i(TAG,"value is : $pin")
            if (pin == goodpin) {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            } else {
                Toast.makeText(this.activity,"Nem megfelelő PIN kód",Toast.LENGTH_SHORT)
            }
        }




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}