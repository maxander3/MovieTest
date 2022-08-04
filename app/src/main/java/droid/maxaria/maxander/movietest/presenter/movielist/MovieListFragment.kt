package droid.maxaria.maxander.movietest.presenter.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import droid.maxaria.maxander.movietest.R
import droid.maxaria.maxander.movietest.databinding.FragmentListBinding

class MovieListFragment : Fragment() {

    private var _binding:FragmentListBinding? = null
    private val binding:FragmentListBinding
        get() = _binding!!

    private val viewModel:MovieListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentListBinding.inflate(inflater)
        val adapter = MovieAdapter()
        binding.movieRecycler.adapter = adapter
        viewModel.movieList.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
        viewModel.error.observe(viewLifecycleOwner){
            findNavController().navigate(R.id.action_movieListFragment_to_errorFragment)
        }
        viewModel.loadMovieList()
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}