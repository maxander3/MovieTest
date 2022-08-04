package droid.maxaria.maxander.movietest.presenter.movielist

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import droid.maxaria.maxander.movietest.R
import droid.maxaria.maxander.movietest.databinding.FragmentListBinding

class MovieListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding: FragmentListBinding
        get() = _binding!!
    private val viewModel: MovieListViewModel by viewModels()

    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentListBinding.inflate(inflater)
        adapter = MovieAdapter()
        adapter.onMovieItemClickListener = {
            makeAlertDialog(it)
        }
        binding.movieRecycler.adapter = adapter
        observeViewModel()
        viewModel.loadMovieList()
        return binding.root
    }

    private fun makeAlertDialog(movieName: String) {
        val title = String.format(
            getString(R.string.movie_clicked),
            movieName
        )
        AlertDialog.Builder(context)
            .setTitle(title)
            .setPositiveButton(android.R.string.ok) { dialog, _ ->
                dialog?.dismiss()
            }
            .show()
    }

    private fun observeViewModel() {
        viewModel.movieList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.error.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_movieListFragment_to_errorFragment)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}