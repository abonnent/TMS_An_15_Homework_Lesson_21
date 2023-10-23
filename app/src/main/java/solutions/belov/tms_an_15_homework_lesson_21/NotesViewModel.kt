package solutions.belov.tms_an_15_homework_lesson_21

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotesViewModel : ViewModel() {
    private val notesLiveData = MutableLiveData<List<Note>>()
    private val notes = mutableListOf<Note>()

    init {
        notesLiveData.value = notes
    }

    fun getNotes(): LiveData<List<Note>> {
        return notesLiveData
    }

    fun addNote(note: Note) {
        notes.add(note)
        notesLiveData.value = notes
    }
}
