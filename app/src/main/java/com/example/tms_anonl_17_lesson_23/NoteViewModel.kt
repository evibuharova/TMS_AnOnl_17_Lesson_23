package com.example.tms_anonl_17_lesson_23

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Date

class NoteViewModel : ViewModel() {
    private val _notelist = MutableLiveData<List<Note>>()
    val notelist: LiveData<List<Note>> = _notelist
    val goToAddScreen=SingleLiveEvent<Unit>()
    val goBack=SingleLiveEvent<Unit>()

    fun initSample(){
        _notelist.value=listOf<Note>(
            Note("example note", "Some useless text", Date().toString())
        )
    }
     fun onAddButtonClicked(){
         goToAddScreen.value = Unit
     }
    fun onSaveButtonClicked(text:String, header:String){
        val newMote = Note(text, header, Date().toString())
        NotesHolder.notes.add(newMote)
        goBack.value=Unit
    }
}
