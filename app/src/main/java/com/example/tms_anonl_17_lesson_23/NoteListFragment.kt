package com.example.tms_anonl_17_lesson_23

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.tms_anonl_17_lesson_23.databinding.ActivityMainBinding
import com.example.tms_anonl_17_lesson_23.databinding.FragmentListBinding

class NoteListFragment : Fragment() {
    private var binding: FragmentListBinding? = null
    private val adapter = NotesRecyclerViewAdapter()
    private val viewModel: NoteViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)
        return binding?.root
    }

    //переопределили метод и вставили адаптер
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    initView()
        observeViewModel()

    }

    private fun initView() {
        binding?.recycler?.adapter = adapter
        binding?.addButton?.setOnClickListener {
            viewModel.onAddButtonClicked()
        }
    }

    private fun observeViewModel() {
        viewModel.notelist.observe(viewLifecycleOwner) { notes ->
            adapter.update(notes)
        }
        viewModel.goToAddScreen.observe(viewLifecycleOwner) {
            val fragment = NoteAddFragment()
            parentFragmentManager.beginTransaction().replace(R.id.container, fragment)
                .addToBackStack("back").commit()

        }
    }

    //метод ондестройвью вызывается каждый раз после возврата на экран
    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}