package solutions.belov.tms_an_15_homework_lesson_21

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import solutions.belov.tms_an_15_homework_lesson_21.databinding.FragmentAddNoteBinding
import java.util.Date


class AddNoteFragment : Fragment() {
    private lateinit var binding: FragmentAddNoteBinding
    private lateinit var viewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(requireActivity()).get(NotesViewModel::class.java)

        binding.saveButton.setOnClickListener {
            val title = binding.titleEdit.text.toString()
            val text = binding.textEdit.text.toString()
            val date = SimpleDateFormat("HH:mm:ss").format(Date())
            val important = binding.noteImportant.isChecked

            if (title.isNotBlank() && text.isNotBlank()) {
                val note = Note(title, text, date, important)

                viewModel.addNote(note)

                binding.titleEdit.text.clear()
                binding.textEdit.text.clear()
                binding.noteImportant.isChecked = false
            }
        }

        return view
    }
}