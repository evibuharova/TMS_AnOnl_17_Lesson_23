package com.example.tms_anonl_17_lesson_23

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.tms_anonl_17_lesson_23.databinding.ActivityMainBinding
import com.example.tms_anonl_17_lesson_23.databinding.FragmentAddBinding
import com.example.tms_anonl_17_lesson_23.databinding.FragmentListBinding
import java.util.Date

class NoteAddFragment : Fragment() {
    private var binding: FragmentAddBinding? = null
    private val viewModel: NoteViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater)
        return binding?.root

    }

    //переопределили метод и вставили адаптер
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        binding?.saveButton?.setOnClickListener {
            viewModel.onSaveButtonClicked(
                binding?.headerEditText?.text?.toString() ?: "",
                binding?.textEditText?.text?.toString() ?: "",
            )
        }
    }

    private fun observeViewModel() {
        //чтобы перейти на предыдущий экран ,вызовем функцию
        viewModel.goBack.observe(viewLifecycleOwner) {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    //метод ондестройвью вызывается каждый раз после возврата на экран
    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}