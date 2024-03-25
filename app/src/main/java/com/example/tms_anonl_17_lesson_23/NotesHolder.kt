package com.example.tms_anonl_17_lesson_23

import java.util.Date

object NotesHolder {
    val notes = mutableListOf<Note>(
        Note("example note", "Some useless text", Date().toString())
    )
}