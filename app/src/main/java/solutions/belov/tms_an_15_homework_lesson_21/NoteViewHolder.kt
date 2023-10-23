package solutions.belov.tms_an_15_homework_lesson_21

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import solutions.belov.tms_an_15_homework_lesson_21.databinding.NoteItemBinding

class NoteViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    val binding = NoteItemBinding.bind(item)

    fun bind(note: Note) = with(binding) {
        noteTitle.text = note.title
        noteText.text = note.text
        noteDate.text = note.date
    }
}