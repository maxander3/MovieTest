package droid.maxaria.maxander.movietest.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import droid.maxaria.maxander.movietest.R


class ErrorFragment : Fragment() {

    lateinit var btnRetry: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_error, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnRetry = view.findViewById(R.id.retry_btn)
        btnRetry.setOnClickListener {
            findNavController().navigate(R.id.action_errorFragment_to_movieListFragment)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}