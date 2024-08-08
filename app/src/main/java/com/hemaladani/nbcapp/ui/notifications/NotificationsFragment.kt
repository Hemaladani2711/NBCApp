package com.hemaladani.nbcapp.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hemaladani.nbcapp.R
import com.hemaladani.nbcapp.databinding.FragmentNotificationsBinding
import com.hemaladani.nbcapp.ui.dashboard.helloWorld_Text

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val textNotifications = root.findViewById<ComposeView>(R.id.text_notifications)
        textNotifications.setContent { helloWorld_Text() }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}