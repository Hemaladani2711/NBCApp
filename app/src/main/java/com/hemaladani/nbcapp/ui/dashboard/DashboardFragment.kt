package com.hemaladani.nbcapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hemaladani.nbcapp.R
import com.hemaladani.nbcapp.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val helloWorldTextView = root.findViewById<ComposeView>(R.id.text_dashboard)
        helloWorldTextView.setContent { helloWorld_Text("Dashboard") }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}